import java.rmi.*; 
import java.rmi.registry.*; 
public class ServerRMI 
{ 
    public static void main(String args[]) 
    { 
        System.out.println("Server started");
        try
        { 
             InterfaceRMI obj = new ImplementInterfaceRMI(); 
  
             LocateRegistry.createRegistry(33066); 
  
             Naming.rebind("rmi://localhost:33066"+ 
                          "/bill",obj);             
        } 
        catch(Exception ae) 
        { 
            //System.out.println("sr");
            System.out.println("Server"+ae); 
        } 
    } 
} 