import java.rmi.*;
import java.util.Set;
public interface RmiInterface extends Remote 
{ 
    public  String [][] query(Set<String> cart) throws RemoteException; 
    public  String[][] GetRs(String table) throws RemoteException;
} 