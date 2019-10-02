/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hunglv
 */
public class Message implements Runnable{
    ArrayList<Socket> list_socket;
    public Message(ArrayList<Socket> list_socket) {
        this.list_socket = list_socket;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("size socket: " + list_socket.size());
            for (Socket socket_tmp: list_socket) {
                DataInputStream inps = new DataInputStream(socket_tmp.getInputStream());
                DataOutputStream outs = new DataOutputStream(socket_tmp.getOutputStream());
                String message = inps.readUTF();
                outs.writeUTF(message);
            } 
        } catch (IOException ex) {
            Logger.getLogger(Server_Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
