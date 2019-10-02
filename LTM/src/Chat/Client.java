/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hunglv
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8111);
            DataInputStream inps = new DataInputStream(socket.getInputStream());
            DataOutputStream outs = new DataOutputStream(socket.getOutputStream());
            boolean status = true;
            while (true) {
                outs.writeUTF("hellow" + socket.getLocalPort());
                String message = inps.readUTF();
                System.out.println("message: " + message);
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
