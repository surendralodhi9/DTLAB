import java.rmi.*;
public interface InterfaceRMI extends Remote 
{ 
    public  String [][] getbill(String item[][]) throws RemoteException;  
} 