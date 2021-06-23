package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("start");

        try (
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8))
        ){
            String line = reader.readLine();
            StringBuilder header = new StringBuilder();

            while(line != null && !line.isEmpty()){
                header.append(line).append("\n");
                line = reader.readLine();
            }

            System.out.println(header);
        }

        System.out.println("finish");
    }
}
