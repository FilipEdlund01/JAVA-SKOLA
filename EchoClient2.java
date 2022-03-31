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
import java.net.Socket;

/**
 *
 * @author 2019-e-edlund
 */
public class EchoClient2 implements Closeable {

    public static void main(String[] args) throws IOException {
        try (EchoClient2 ec = new EchoClient2("localhost",10000)) {

          
                ec.write("Hello There!");
                ec.write("Fuck You!");
                System.out.println(ec.read());
            

        }
    }

    private final Socket socket;
    private final BufferedReader input;
    private final BufferedWriter output;

    public EchoClient2(String name, int port) throws IOException {
        socket = new Socket(name, port);
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
