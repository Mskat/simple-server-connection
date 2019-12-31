package com.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        Server myServer = new Server(5000);
    }

    public Server(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted");
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String userInput;
            while((userInput = input.readLine()) != null) {
                output.println("Server received message: " + userInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}