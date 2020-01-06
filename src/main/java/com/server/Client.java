package com.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        Client myClient = new Client("127.0.0.1", 5000);
    }

    public Client(String address, int port) {
        try {
            Socket socket = new Socket(address, port);
            System.out.println("Connected");
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            String userInput;
            while((userInput = in.readLine()) != null) {
                output.println(userInput);
                System.out.println(input.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
