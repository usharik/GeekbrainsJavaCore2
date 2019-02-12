package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private Socket socket;
    private Thread handleThread;
    private DataInputStream inp;
    private DataOutputStream out;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.inp = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        this.handleThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        String msg = inp.readUTF();
                        System.out.println("Message: " + msg);
                        out.writeUTF(msg);
                        out.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        handleThread.start();
    }

    public void sendMessage(String message) throws IOException {
        out.writeUTF(message);
        out.flush();
    }
}
