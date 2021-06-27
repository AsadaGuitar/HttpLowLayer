package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",80);
        System.out.println("START SOCKET");
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        writer.println("Hello World");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        String line = reader.readLine();
        System.out.println("line : " + line);

//        try (
//                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
//                BufferedReader reader = new BufferedReader(
//                        new InputStreamReader(socket.getInputStream()))
////                BufferedReader keyboard = new BufferedReader(
////                        new InputStreamReader(System.in)))
//            {

//                while (true) {
//                    System.out.print("Input＞");
//                    String input = keyboard.readLine();
//                    writer.println(input);
//                    if (input.equals("¥¥q")) {
//                        break;
//                    }
//                    System.out.println("［Server］" + reader.readLine());
//                }
            }
//        catch (Exception e){
//            e.printStackTrace();
//        }


//    }
}
