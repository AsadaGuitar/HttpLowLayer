package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {

    public static void main(String[] args) throws IOException {

        System.out.println("start");

        try (
            ServerSocket serverSocket = new ServerSocket(80);
            Socket socket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8))
        ){
            System.out.println("Connect Socket");

            String line = reader.readLine();
//            StringBuilder header = new StringBuilder();

//            System.out.println("header : " + header);
            System.out.println("line : " + line);

//            while(line != null && !line.isEmpty()){
//                header.append(line).append("\n");
//                line = reader.readLine();
//            }

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
//            writer.println(header);
            writer.println(line);
        }

        System.out.println("finish");
    }
}
