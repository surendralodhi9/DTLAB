/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 205117066
 */
import java.io.*;
import java.util.Scanner;
class Employee implements Serializable
{
    
    static int id;
    String fname;
    String lname;
    transient String gender;
    double salary;
    Employee(int id,String fname,String lname,String gender,double salary)
    {
        
        this.id=id;
        this.lname=lname;
        this.fname=fname;
        this.gender=gender;
        this.salary=salary;
    }
    void Display(Employee obj)
    {
        System.out.println("Id: "+obj.id);
        System.out.println("Name: "+obj.fname+" "+obj.lname);
        System.out.println("Gender: "+obj.gender);
        System.out.println("Salary: "+obj.salary);
    }
    
}
public class SeriDese {
    
    //static
    public static void main(String []args)
    {
        
        Employee object[]=new Employee[10];
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of records you want to serialize: ");
        int n=Integer.parseInt(sc.nextLine());
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the id for employee "+(i+1));
            int id=Integer.parseInt(sc.nextLine());
            System.out.println("Enter the first name");
            String fname=sc.nextLine();
            System.out.println("Enter the last name");
            String lname=sc.nextLine();
            System.out.println("Enter the gender: ");
            String gender=sc.nextLine();
            System.out.println("Enter the salary: ");
            double salary=Double.parseDouble(sc.nextLine());
            object[i]=new Employee(id,fname,lname,gender,salary);
            
        }
        for(int i=0;i<n;i++)
        {
        object[i].Display(object[i]);
        System.out.println("******************************************");
        }
        String filename="records.txt";
        try
        {
             FileOutputStream filestream=null;
             ObjectOutputStream ops=null;
             filestream=new FileOutputStream(filename);
         for(int i=0;i<n;i++)
         {
         
          ops=new ObjectOutputStream(filestream);
          ops.writeObject(object[i]);  
         }
          ops.close();
          filestream.close();
        System.out.println("Serialization finished!!");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        Employee object1[]=new Employee[10];
        
        object[0].id=34;
        try
        {
            FileInputStream inps;
            ObjectInputStream ois;
            inps=new FileInputStream(filename);
            for(int i=0;i<n;i++)
            {
              
              ois=new ObjectInputStream(inps);
              object1[i]=(Employee)ois.readObject();
              
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        for(int i=0;i<n;i++)
        {
             object1[i].Display(object1[i]);
             System.out.println("******************************************");
      
        }
    }
        
    
}
