import java.rmi.Naming;
import java.sql.Timestamp;
import java.util.Scanner;
class Productlist
{
    int id;
    String pname;
    double price;
    Productlist(int id,String pname,double price)
    {
        this.id=id;
        this.pname=pname;
        this.price=price;
    }
    public void Display()
    {
        System.out.println("Product id: "+id);
        System.out.println("Product name: "+pname);
        System.out.println("Product price: "+price);
    }
}
public class ClientRMI {
    
    
    public static void main(String []args)
    {
        Productlist object[]=new Productlist[10];
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of products purchased by the client:");
        int n=Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the id for product "+(i+1));
            int id=Integer.parseInt(sc.nextLine());
            System.out.println("Enter the product name");
            String pname=sc.nextLine();
            
            System.out.println("Enter the price: ");
            double price=Double.parseDouble(sc.nextLine());
            object[i]=new Productlist(id,pname,price);
            
        }
        String item[][]=new String[n][3];
        System.out.println("Items purchased by client are: ");
        for(int i=0;i<n;i++)
        {
        object[i].Display();
        item[i][0]=String.valueOf(object[i].id);
        item[i][1]=String.valueOf(object[i].pname);
        item[i][2]=String.valueOf(object[i].price);
        System.out.println("******************************************");
        }
          try
           {
               
           
            InterfaceRMI access = (InterfaceRMI)Naming.lookup("rmi://localhost:33066"+ "/bill"); 
            String Bill[][] = access.getbill(item); 
            String tab="\t\t";
            String st="";
            int SN=1001;
            String cname="Client";
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            st=st+"S.N.: "+String.valueOf(SN)+tab+"Name: "+cname+"\t"+"Date: "+String.valueOf(timestamp)+"\n";
            st=st+"*************************************************************************\n";
            
            st=st+"Id\t\tProduct\t\tPrice\t\tDiscount\tNetPrice\n";
            st=st+"-------------------------------------------------------------------------\n";
               
           
           for(int i=0;i<Bill.length;i++)
            {
                st=st+Bill[i][0]+tab+Bill[i][1]+tab+Bill[i][2]+tab+Bill[i][3]+tab+Bill[i][4]+"\n";
                
                if(i==(Bill.length-2))
                st=st+"-------------------------------------------------------------------------\n";
                
            }
            SN++;
            System.out.println("Bill generated!!!");
            System.out.println(st);            
           }
           catch(Exception e)
           {
               System.out.println("Client"+e);
           }
    }
}
