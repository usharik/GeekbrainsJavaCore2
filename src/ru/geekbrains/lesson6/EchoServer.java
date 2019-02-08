package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            System.out.println("Server started!");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try (DataInputStream inp = new DataInputStream(socket.getInputStream());
                             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

                            while (true) {
                                String msg = inp.readUTF();
                                System.out.println("Message: " + msg);
                                out.writeUTF(msg);
                                out.flush();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
