/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hunglv
 */
public class Extension implements Runnable{
    ServerSocket serverSocket;
    ArrayList<Socket> list_socket;
    public Extension(ServerSocket serverSocket, ArrayList<Socket> list_socket) {
        this.serverSocket = serverSocket;
        this.list_socket = list_socket;
    }
    
    @Override
    public void run() {
        try {
            Socket socket = serverSocket.accept();
            System.out.println("id: "+ socket.getPort());
            list_socket.add(socket);
        } catch (IOException ex) {
            Logger.getLogger(Server_Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
