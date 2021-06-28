package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class Client {

    public static void main(String[] args) throws IOException {

        Logger log = Logger.getLogger("Client.main");
        log.info("Application Starts");

        Socket socket = new Socket("localhost", 80);
        log.info("CONNECTION STARTS");
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        writer.println("Hello World");
        log.info("Send \"Hello World\"");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        String line = reader.readLine();
        log.info("Received Data Is ..." + line);

        socket.close();
        log.info("Socket Is Closed");
    }
}
