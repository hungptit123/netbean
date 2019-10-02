/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo_Server;

import static Demo_Server.Client.data_byte;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hunglv
 */
public class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8081);) {
            Socket socket = serverSocket.accept();
//            write data type
            DataOutputStream outs = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
             
            ByteArrayOutputStream byteouts = new ByteArrayOutputStream();
            byte[] buff = "Hellow world abcdfgbgg".getBytes();
            byteouts.write(buff);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void data_int(DataInputStream in, DataOutputStream outs) {
        try {
            outs.writeInt(5);
            outs.writeInt(8);
            System.out.println("Total: " + in.readInt());
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void data_byte(DataInputStream in, DataOutputStream outs) {
        byte[] b = new String("abcd").getBytes();
        try {
            int h = 100000;
            outs.writeInt(h*b.length);
            for (int i=1; i<=h; i++) {
                outs.write(b);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
