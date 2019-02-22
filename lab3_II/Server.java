//Surendra Lodhi
import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.Scanner; 

public class Server  
{ 
   
        public static void main(String[] args) throws IOException  
         { 
       DatagramSocket ds = new DatagramSocket(33066); 
        System.out.println("Server");
       
        while (true)  
        { 
                DatagramPacket DpReceive = null; 
                byte[] receive = new byte[65535]; 
                DpReceive = new DatagramPacket(receive, receive.length);     
                ds.receive(DpReceive);
                ClientHandler obj = new ClientHandler(ds,DpReceive,receive); 
                obj.start(); 
               
            }      
    } 
} 

class ClientHandler extends Thread  
{ 
  
        final DatagramSocket ds;
       DatagramPacket DpReceive;
       byte []receive;
      public ClientHandler( DatagramSocket ds,DatagramPacket DpReceive,byte []receive)  
      { 
             this.ds = ds; 
             this.DpReceive=DpReceive;
             this.receive=receive;
        } 
  
     public void run()  
       {
                    System.out.println("A new client is connected : "); 
    	  try
    	  {
                          InetAddress ip = DpReceive.getAddress(); 
                          int clientport=DpReceive.getPort();
                          byte buf[] = null; 
                          System.out.println("Client: " + data(receive)); 
                         String inp = data1(receive);
  
                         buf = inp.getBytes(); 
                         DatagramPacket DpSend =  new DatagramPacket(buf, buf.length, ip, clientport); 
             
                         ds.send(DpSend); 
                         receive = new byte[65535]; 
    	  }
    	  catch (Exception e)
    	  {
                            System.out.println(e.getLocalizedMessage());
    	  }
       }

       public static String data1(byte[] a) 
        { 
                   if (a == null) 
                     return null; 
                  StringBuilder ret = new StringBuilder(); 
                 int i = 0;
                 int num=0;
                 String inval="Invalid number";
                if(a[i]=='-')
                 return inval; 

               while (a[i] != 0) 
                 { 
                    num=num*10+(a[i]-'0');
                     i++; 
                    } 
               double num1=Math.sqrt(num);
               System.out.println(num1);
               String res=String.valueOf(num1);
                return res;
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