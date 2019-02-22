//Surendra Lodhi
import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.Scanner; 

public class CalculatorServer
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
                Calculator obj = new Calculator(ds,DpReceive,receive); 
                obj.start(); 
               
         }      
    } 
} 

class Calculator extends Thread  
{ 
  
       final DatagramSocket ds;
       DatagramPacket DpReceive;
       byte []receive;
      public Calculator( DatagramSocket ds,DatagramPacket DpReceive,byte []receive)  
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
                         String inp = Calculate(receive);
  
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

       public static String Calculate(byte[] a) 
        { 
                 if (a == null) 
                   return null; 
                 int i = 0;
                int num=0;
                String inval="Invalid number";
                int num1=0;
                int num2=0;
                int s1=1;
                int s2=1;
                String nums1="";
                String nums2="";
                char op;
                if(a[i]=='-')
                {
                	s1*=-1;
                	i++;
                }
                while(a[i]!=0 &&(a[i]>='0'&&a[i]<='9'))
                {
                	nums1+=a[i];
                	i++;
                }
                if(nums1.length()==0)
                	return inval;
                if(a[i]=='-'||a[i]=='+'||a[i]=='*'||a[i]=='/')
                {
                	op=(char)a[i];
                	i++;
                }
                else
                	return inval;
                if(a[i]=='-')
                {
                	s2*=-1;
                	i++;
                }
                
                while(a[i]!=0&&(a[i]>='0'&&a[i]<='9'))
                {
                	nums2+=a[i];
                	i++;
                }
                if(nums2.length()==0)
                	return inval;
                if(a[i]!=0)
                	return inval;
                
                num1=Integer.parseInt(nums1);
                num2=Integer.parseInt(nums2);
                num1=num1*s1;
                num2=num2*s2;
                switch(op)
                {
                     case '+':
                    	 num=num1+num2;
                    	 break;
                     case '-':
                    	 num=num1-num2;
                    	 break;
                     case '*':
                    	 num=num1*num2;
                    	 break;
                     case '/':
                         {
                        	 
                           if(num2==0)
                        	   return "Division by 0 is not possible";
                    	   num=num1/num2;
                         }
                }
                
                
               
               System.out.println(num);
               String res=String.valueOf(num);
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