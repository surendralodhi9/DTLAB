/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

/**
 *
 * @author 205117066
 */
import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.net.MulticastSocket;
import java.util.Scanner;
public class Multiclient1 {
    
    
    
    public static void main(String args[]) throws IOException 
    {
        
        System.out.println("Client2");
        
        DatagramPacket DpReceive = null; 
        MulticastSocket ms=new MulticastSocket(12345);
        InetAddress groupip = InetAddress.getByName("230.1.1.1");//224.0.0.1 to 239.255.255.255
        ms.joinGroup(groupip);
        byte [] receive=new byte[65535];
         while(true)
            {
               
                 DpReceive = new DatagramPacket(receive, receive.length); 
                 ms.receive(DpReceive); 
               System.out.println("New Quotes is: " + data(receive)); 
  
                 //System.out.println("New Quotes is: " + DpReceive.getData().toString());
                 receive = new byte[65535]; 
  
            
            }
       
    }
    public static StringBuilder data(byte[] a) 
    { 
        if (a == null) 
            return null; 
        StringBuilder ret = new StringBuilder(); 
        int i = 0; 
        while (a[i] != 0) 
        { 
            ret.append((char) a[i]); 
            i++; 
        } 
        return ret; 
    }
}
