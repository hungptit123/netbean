/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import Demo_Server.Server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hunglv
 */
public class Server_Demo {
    public static void main(String[] args) throws InterruptedException {
        try {
            ServerSocket server_socket = new ServerSocket(8111);
            boolean status = true;
            DataInputStream inps = null;
            DataOutputStream outs = null;    
            ArrayList<Socket> socket_list = new ArrayList<>();
            Extension ex = new Extension(server_socket, socket_list);
            Message mes = new Message(socket_list);
            while (true) {   
                ex.run();
                mes.run();
                socket_list = ex.list_socket;
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Server_Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
