import java.rmi.*; 
import java.rmi.server.*; 
public class ImplementInterfaceRMI extends UnicastRemoteObject 
                         implements InterfaceRMI
{ 
    ImplementInterfaceRMI() throws RemoteException 
    { 
        super(); 
    } 
    
    public String [][] getbill(String item[][]) throws RemoteException 
    { 
    
            double total=0;
            double tdis=0;
            int i=0;
            int n=item.length;
            String bill[][]=new String[n+1][5];
           while(i<n)
           {
                   String pid =item[i][0];
                   String pname=item[i][1];
                   double price=Double.parseDouble(item[i][2]);
                   double dis=5*price/100;
                   double netp=price-dis;
                   
                   total+=price;
                   tdis+=dis;
                   bill[i][0]=pid;
                   bill[i][1]=pname;
                   bill[i][2]=String.valueOf(price);
                   bill[i][3]=String.valueOf(dis);
                   bill[i][4]=String.valueOf(netp);
                   i++;
                   
           }
           bill[i][0]="Total";
           bill[i][1]=String.valueOf(n);
           bill[i][2]=String.valueOf(total);
           bill[i][3]=String.valueOf(tdis);
           bill[i][4]=String.valueOf(total-tdis);
           return bill;
        
    }
}
