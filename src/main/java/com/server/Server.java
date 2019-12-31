package com.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;

    public static void main(String[] args) {
        Server myServer = new Server(5000);
    }

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}