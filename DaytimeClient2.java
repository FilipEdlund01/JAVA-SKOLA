/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce309;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author 2019-e-edlund
 */
public class DaytimeClient2 implements Closeable {

    public static void main(String[] args) throws IOException {
        try (DaytimeClient2 dc = new DaytimeClient2("vyuka.gyarab.cz", 13)) {

     
                System.out.println(dc.read());
                System.out.println(dc.read());
            

        }
    }

    private final Socket socket;
    private final BufferedReader input;

    public DaytimeClient2(String name, int port) throws IOException {
        socket = new Socket(name, port);
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }

    public String read() throws IOException {
        return input.readLine();
    }

    @Override
    public void close() throws IOException {
        if (socket != null) {
            socket.close();
        }
    }

}
