package com.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) throws IOException {
        Server myServer = new Server(5000);
        myServer.startServer();
    }

}
