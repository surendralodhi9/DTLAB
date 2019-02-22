import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.Scanner; 
  
public class ClientUDP 
{ 
    public static void main(String args[]) throws IOException 
    { 
        Scanner sc = new Scanner(System.in); 
         System.out.println("CLient");
        // Step 1:Create the socket object for 
        // carrying the data. 
        DatagramSocket ds = new DatagramSocket(); 
  
        InetAddress ip = InetAddress.getLocalHost(); 
        byte buf[] = null; 
  
        // loop while user not enters "bye" 
        byte[] receive = new byte[65535]; 
        System.out.println("Server");
        DatagramPacket DpReceive = null; 
        while (true) 
        { 
        	System.out.println("Enter the message:");
            String inp = sc.nextLine(); 
  
            // convert the String input into the byte array. 
            buf = inp.getBytes(); 
  
            // Step 2 : Create the datagramPacket for sending 
            // the data. 
            DatagramPacket DpSend = 
                  new DatagramPacket(buf, buf.length, ip, 33066); 
  
            // Step 3 : invoke the send call to actually send 
            // the data. 
            ds.send(DpSend); 
           
            DpReceive = new DatagramPacket(receive, receive.length); 
            
            // Step 3 : revieve the data in byte buffer. 
            ds.receive(DpReceive); 
            
            
            System.out.println("From Server to Client:-" + data(receive)); 
  
            // break the loop if user enters "bye" 
            if (inp.equals("bye")) 
                break; 
            
      
  
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
