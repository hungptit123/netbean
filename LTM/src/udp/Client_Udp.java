/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hunglv
 */
public class Client_Udp {
    public static void main(String[] args) throws UnknownHostException, IOException {
        try {
            DatagramSocket client_Socket = new DatagramSocket();
            int port = 8999;
            InetAddress inet = InetAddress.getByName("localhost");
            Student st_send = new Student("hung", 22);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(st_send);
            byte[] send_data = outputStream.toByteArray();
            DatagramPacket send_packe = new DatagramPacket(send_data, send_data.length, inet, port);
            client_Socket.send(send_packe);
            
//            String message = "hellow world";
//            byte[] send_mess = message.getBytes();
//            byte[] rece_mess = new byte[2024];
//            InetAddress inet = InetAddress.getByName("localhost");
//            DatagramPacket send_packe = new DatagramPacket(send_mess, send_mess.length, inet, 8999);
//            client_Socket.send(send_packe);
//            
//            DatagramPacket receive_packe = new DatagramPacket(rece_mess, rece_mess.length);
//            client_Socket.receive(receive_packe);
//            String mess_re = new String(receive_packe.getData());
//            System.out.println("mess: "+ mess_re);
            send_packe = new DatagramPacket(send_data, send_data.length, inet, port)
                    
//            String message = "hellow world";
//            byte[] send_mess = message.getBytes();
//            byte[] rece_mess = new byte[2024];
//            InetAddress inet = InetAddress.getByName("localhost");
//            DatagramPacket send_packe = new DatagramPacket(send_mess, send_mess.length, inet, 8999);
//            client_Socket.send(send_packe);
//
//            DatagramPacket receive_packe = new DatagramPacket(rece_mess, rece_mess.length);
//            client_Socket.receive(receive_packe);
//            String mess_re = new String(receive_packe.getData());
//            System.out.println("mess: "+ mess_re);
;
            
        } catch (SocketException ex) {
            Logger.getLogger(Client_Udp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
