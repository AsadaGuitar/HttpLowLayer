package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;


public class Server {

    public static void main(String[] args) throws IOException {

        Logger log = Logger.getLogger("Server.main");
        log.info("Application Starts");

        try (
            ServerSocket serverSocket = new ServerSocket(80);
            Socket socket = serverSocket.accept();
            InputStream in = socket.getInputStream()
        ){
            log.info("CONNECTION STARTS");

            OutputStream out = socket.getOutputStream();

            int i;
            while((i = in.read()) != -1){

                System.out.println("\nByte Data Is " + i + " By \"Int\"");
                System.out.println("Byte Data Is " + (char)i + " By \"Char\"");

                out.write(i);
            }

            log.info("Server Sent The Data");

            in.close();
            out.close();
        }

        log.info("Quit The Application.");
    }
}
