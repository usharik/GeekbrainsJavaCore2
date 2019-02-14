package ru.geekbrains.lesson4.swing;

import javax.swing.*;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Network implements Closeable {

    private static final String AUTH_PATTERN = "/auth %s %s";
    private static final String MESSAGE_PATTERN = "/w %s %s";
    private static final Pattern MESSAGE_PARS_PATTERN = Pattern.compile("^/w (\\w+) (.+)", Pattern.MULTILINE);

    private final Socket socket;
    private final DataOutputStream out;
    private final DataInputStream in;
    private final MessageSender messageSender;
    private final Thread receiver;

    private String username;

    public Network(String hostName, int port, MessageSender messageSender) throws IOException {
        this.socket = new Socket(hostName, port);
        this.out = new DataOutputStream(socket.getOutputStream());
        this.in = new DataInputStream(socket.getInputStream());
        this.messageSender = messageSender;

        this.receiver = createReceiverThread();
    }

    private Thread createReceiverThread() {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        String text = in.readUTF();
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println("New message " + text);
                                Matcher matcher = MESSAGE_PARS_PATTERN.matcher(text);
                                if (matcher.matches()) {
                                    Message msg = new Message(matcher.group(1), username,  matcher.group(2));
                                    messageSender.submitMessage(msg);
                                }
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void sendMessageToUser(Message message) {
        sendMessage(String.format(MESSAGE_PATTERN, message.getUserTo(), message.getText()));
    }

    private void sendMessage(String msg) {
        try {
            out.writeUTF(msg);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void authorize(String username, String password) {
        try {
            out.writeUTF(String.format(AUTH_PATTERN, username, password));
            String response = in.readUTF();
            if (response.equals("/auth successful")) {
                this.username = username;
                receiver.start();
            } else {
                throw new AuthException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void close() throws IOException {
        socket.close();
        receiver.interrupt();
        try {
            receiver.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
