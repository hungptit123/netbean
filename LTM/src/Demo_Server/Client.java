/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo_Server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hunglv
 */
public class Client {
    public static void main(String[] args) throws ClassNotFoundException {
        try(Socket socket = new Socket("localhost", 8081);) {
//            write data type
            DataOutputStream outs = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
//            ObjectInputStream ois = new ObjectInputStream(in);
//            Message message = (Message) ois.readObject();
//            System.out.println(message.toString());
            
//            data_int(in, outs);
//            ObjectInputStream ois = new ObjectInputStream(in);
//            ArrayList<Message> mes = (ArrayList<Message>) ois.readObject();
//            System.out.println("message: " + mes.size());
//            for (Message m: mes) {
//                System.out.println("message: " + m.toString());
//            }
              data_byte(in, outs);
//              BufferedInputStream buff = new BufferedInputStream(in);
////            write and read data follow byte
//            BufferedOutputStream outs = new BufferedOutputStream(socket.getOutputStream());
//            BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
//            data_byte(in, outs);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void data_int(DataInputStream in, DataOutputStream outs) {
        try {
            int a = in.readInt();
            int b = in.readInt();
            System.out.println(""+a);
            System.out.println(""+b);
            outs.writeInt(a+b);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void data_byte(DataInputStream in, DataOutputStream outs) {
        byte[] b = new byte[10];
        String message=  "";
        try {
            for (int i=1; i<=10000; i++) {
                in.read(b);
                message += new String(b).trim();
            }
//            int lenght = in.readInt();
//            int count = 0;
//            b = new byte[lenght];
//            in.read(b);
//            System.out.println("len: " + lenght);
//            while (count <= lenght) {
//                in.read(b);
//                count += b.length;
//                message += new String(b).trim();
////                System.out.println("count: "+ count);
//            }
//            message = new String(b);
            System.out.println(message.length());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
