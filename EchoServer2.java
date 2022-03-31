/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce309;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 2019-e-edlund
 */
public class EchoServer2 implements Closeable {

    public static void main(String[] args) throws IOException {
        try (EchoServer2 ec = new EchoServer2(10000)) {
            while (true) {
                System.out.println("Waiting for mesage..");
                String line = ec.read();
                System.out.println("got" +line);
                ec.write(line);
                System.out.println("sent" + line);
                
                
            }

          
          
            

        }
    }
    private final ServerSocket server;
    private final Socket socket;
    private final BufferedReader input;
    private final BufferedWriter output;

    public EchoServer2( int port) throws IOException {
        System.out.println("create server socket");
        server = new ServerSocket(port);
        System.out.println("listening");
        socket = server.accept();
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

    }

    public String read() throws IOException {
        return input.readLine();
    }

    public void write(String line) throws IOException {
        System.out.println("write");
        output.write(line);
        output.newLine();
        output.flush();// aby to naplnilo packet 

    }

    @Override
    public void close() throws IOException {
        if (socket != null) {
            socket.close();
        }
    }

}
