package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            System.out.println("Сервер запущен!");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Новое подключение " + socket.getInetAddress());

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            DataInputStream in = new DataInputStream(socket.getInputStream());
                            String str = in.readUTF();
                            System.out.println("Новое сообщение : " + str);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
