package ru.geekbrains.lesson7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.regex.Pattern;


public class ClientHandler {

    private static final Pattern MESSAGE_PATTERN = Pattern.compile("^/w (.+) (.+)$");
    private final Thread handleThread;
    private final DataInputStream inp;
    private final DataOutputStream out;

    private final String username;
    private final Socket socket;

    public ClientHandler(String username, Socket socket) throws IOException {
        this.username = username;
        this.socket = socket;
        this.inp = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        this.handleThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        String msg = inp.readUTF();
                        System.out.printf("Message from user %s: %s", username, msg);
                        // TODO реализовать прием сообщений от клиента и пересылку адресату
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Client disconnected");
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        handleThread.start();
    }
}
