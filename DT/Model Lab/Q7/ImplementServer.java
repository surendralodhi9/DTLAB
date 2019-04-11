import java.rmi.*; 
import java.rmi.registry.*; 
public class ImplementServer 
{ 
    public static void main(String args[]) 
    { 
        try
        { 
             RmiInterface obj = new RmiImplement(); 
  
             LocateRegistry.createRegistry(33066); 
  
             Naming.rebind("rmi://localhost:33066"+ 
                          "/bill",obj); 
             RmiInterface obj1 = new RmiImplement();
             Naming.rebind("rmi://localhost:33066"+ 
                          "/database",obj1); 
                   
        } 
        catch(Exception ae) 
        { 
            //System.out.println("sr");
            System.out.println(ae); 
        } 
    } 
} 