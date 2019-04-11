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
import java.util.Scanner; 
import java.io.*;

public class Multiserver
{ 
   
     public static void main(String[] args) throws IOException  
      { 
           DatagramSocket ds = new DatagramSocket(33066); 
           
           String arr[]=new String[10];
           Scanner sc=new Scanner(System.in);
           System.out.println("Enter the message 10");
           for(int i=0;i<10;i++)
           {
               String st=sc.nextLine();
               arr[i]=st;
           }
               
           System.out.println("Server");
      
         int i=0;
        while (true)  
        { 
               
            
                      try{
                           
                          byte buf[] = null; 
                          InetAddress groupip =InetAddress.getByName("230.1.1.1");
                          
                          //System.out.println("Enter the quotes");
                          //String inp = sc.nextLine();
                          if(i>=10)
                              break;
                          buf = arr[i].getBytes();
                          DatagramPacket DpSend =  new DatagramPacket(buf, buf.length, groupip, 12345); 
                          ds.send(DpSend); 
                          
                          Thread.sleep(5000); 
                          i++;
                        }
                      catch(Exception e)
                      {
                          System.out.println(e);
                      }
         }      
    } 
}
