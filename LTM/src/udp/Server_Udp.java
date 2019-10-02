/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hunglv
 */
public class Server_Udp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (DatagramSocket myServer = new DatagramSocket(8999);){
            
            byte[] rece = new byte[1024];
            DatagramPacket rece_packe = new DatagramPacket(rece, rece.length);
            myServer.receive(rece_packe);
            byte[] data_receive = rece_packe.getData();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data_receive);  
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            Student st_receive = (Student) ois.readObject();
            System.out.println("inform receive: " + st_receive.toString());
            
//            byte[] receive_data = new byte[1024];
//            byte[] send_data = null;
//            DatagramPacket rePacket = new DatagramPacket(receive_data, receive_data.length);
//            myServer.receive(rePacket);
//            String message = new String(rePacket.getData()).trim();
//            System.out.println("server receive: " + message);
//            message += "abc";
//            send_data = message.getBytes();
//            System.out.println("server send: " + new String(send_data));
//            InetAddress IPAdd = rePacket.getAddress();
//            int port = rePacket.getPort();
//            DatagramPacket send_packe = new DatagramPacket(send_data, send_data.length, IPAdd, port);
//            myServer.send(send_packe);
             
        } catch (SocketException ex) {
            Logger.getLogger(Server_Udp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
