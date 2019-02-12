package ru.geekbrains.lesson4.swing;

import javax.swing.*;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Network implements Closeable {

    private static final String AUTH_PATTERN = "/auth %s %s";

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

        this.receiver = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        String msg = in.readUTF();
                        SwingUtilities.invokeLater(new Runnable() {
                                                       @Override
                                                       public void run() {
                                                           System.out.println("New message " + msg);
                                                           messageSender.submitMessage("server", msg);
                                                       }
                                                   });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    public void sendMessage(String msg) {
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
                throw new AuthException("");
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
