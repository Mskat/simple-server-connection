package com.zur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int portNumber = 5000;
        Server myServer = new Server(portNumber);
    }

    private Server(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted");
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String userInput;
            while(true) {
                userInput = input.readLine();
                if(userInput.equals("bye")) {
                    break;
                }
                output.println(userInput);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Client disconnected");
        }
    }

}