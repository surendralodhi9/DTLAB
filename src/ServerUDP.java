import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.net.SocketException; 
import java.util.Scanner;
  
public class ServerUDP 
{ 
    public static void main(String[] args) throws IOException 
    { 
        // Step 1 : Create a socket to listen at port 1234 
        DatagramSocket ds = new DatagramSocket(33066); 
        byte[] receive = new byte[65535]; 
        System.out.println("Server");
        DatagramPacket DpReceive = null; 
        while (true) 
        { 
  
            // Step 2 : create a DatgramPacket to receive the data. 
        	
            DpReceive = new DatagramPacket(receive, receive.length); 
            
            // Step 3 : revieve the data in byte buffer. 
            ds.receive(DpReceive); 
            
            //from here code will execute only when client responds
            System.out.println("Server");
            InetAddress ip = DpReceive.getAddress(); 
            int clientport=DpReceive.getPort();
            byte buf[] = null; 
            System.out.println("Client:-" + data(receive)); 
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the message:");
            String inp = sc.nextLine(); 
  
            // convert the String input into the byte array. 
            buf = inp.getBytes(); 
  
            // Step 2 : Create the datagramPacket for sending 
            // the data. 
            DatagramPacket DpSend = 
                  new DatagramPacket(buf, buf.length, ip, clientport); 
  
            // Step 3 : invoke the send call to actually send 
            // the data. 
            ds.send(DpSend); 
            // Exit the server if the client sends "bye" 
            if (data(receive).toString().equals("bye")) 
            { 
                System.out.println("Client sent bye.....EXITING"); 
                break; 
            } 
  
            // Clear the buffer after every message. 
            receive = new byte[65535]; 
            
        } 
    } 
  
    // A utility method to convert the byte array 
    // data into a string representation. 
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