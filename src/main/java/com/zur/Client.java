package com.zur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        int portNumber = 5000;
        String address = "127.0.0.1";
        Client myClient = new Client(address, portNumber);
    }

    private Client(String address, int port) {
        try {
            Socket socket = new Socket(address, port);
            System.out.println("Connected");
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            String userInput;
            while((userInput = in.readLine()) != null) {
                output.println(userInput);
                System.out.println("Server received message: " + input.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
