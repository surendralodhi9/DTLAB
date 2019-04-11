import java.rmi.*; 
import java.rmi.server.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public class RmiImplement extends UnicastRemoteObject 
                         implements RmiInterface 
{ 
    RmiImplement() throws RemoteException 
    { 
        super(); 
    } 
  
    
    public String [][] query(Set<String> cart) throws RemoteException 
    { 
        
        int n=cart.size();
        String bill[][]=new String[n+1][5];    
        try
        {
            Connection con=null;
            Statement st=null;
            ResultSet rs=null;
            String query=null;
            Class.forName("org.sqlite.JDBC");
            con=DriverManager.getConnection("jdbc:sqlite:product.sqlite");
            st=con.createStatement();
            double total=0;
            double tdis=0;
            int i=0;
           for(String val:cart)
           {
                query="SELECT *from productlist where product_id='"+val+"'";
                rs=st.executeQuery(query);
                while(rs.next())
                {
                   String pid =rs.getString(1);
                   String pname=rs.getString(2);
                   double price=rs.getDouble(4);
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
                   
           }
           bill[i][0]="Total";
           bill[i][1]=String.valueOf(n);
           bill[i][2]=String.valueOf(total);
           bill[i][3]=String.valueOf(tdis);
           bill[i][4]=String.valueOf(total-tdis);
           return bill;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    return bill;
    } 
    public String [][] GetRs(String table) throws RemoteException 
    { 
        String[][] lis1=new String[0][4];
        try{
            
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:product.sqlite"); //To create database if not exist
            String query = "select  *from "+table;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            int n=0;
             while(rs.next())
             {
                 n++;
             }
            
            //System.out.println(n);
            String[][] list=new String[n][4];
            int i=0;
            rs=st.executeQuery(query);
            while(rs.next())
            {
                list[i][0]=rs.getString(1);
                list[i][1]=rs.getString(2);
                list[i][2]=rs.getString(3);
                list[i][3]=rs.getString(4);
                 i++;
            }
            //System.out.println("try");
            return list;
        }
        catch(Exception e)
        {
            System.out.println("IS");
            System.out.println(e);
        }
        System.out.println("out try");
          return lis1;
    }
} 