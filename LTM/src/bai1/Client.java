/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hunglv
 */
public class Client {
    public static void main(String[] args) throws ClassNotFoundException {
        Socket socket;
        try {
            socket = new Socket("localhost", 8090);
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            Student st = (Student) ois.readObject();
            System.out.println(st);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
