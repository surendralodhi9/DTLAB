//Surendra Lodhi
import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.Scanner; 
  
public class Client2
{ 
    public static void main(String args[]) throws IOException 
    { 
        Scanner sc = new Scanner(System.in); 
         System.out.println("CLient2:");
        
        DatagramSocket ds = new DatagramSocket(); 
  
        InetAddress ip = InetAddress.getLocalHost(); 
        byte buf[] = null; 
  
        
        byte[] receive = new byte[65535]; 
        DatagramPacket DpReceive = null; 
        while (true) 
        { 
        	System.out.println("Enter the number:");
            String inp = sc.nextLine(); 
  
            
            buf = inp.getBytes(); 
  
           
            DatagramPacket DpSend = 
                  new DatagramPacket(buf, buf.length, ip, 33066); 
  
            
            ds.send(DpSend); 
           
            DpReceive = new DatagramPacket(receive, receive.length); 
            
            
            ds.receive(DpReceive); 
            
            
            System.out.println("From Server to Client: " + data(receive)); 
  
            
            if (inp.equals("stop")) 
                break; 
            
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
