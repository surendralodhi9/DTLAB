/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Naming;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Administrator
 */
public class Product extends javax.swing.JFrame {

    /**
     * Creates new form Product
     */
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    String query=null;
    Set<String> cart = new HashSet<String>(); 
    static String username="205117066";
   static  String cname="Surendra";
    int SN=1001;
        
    public Product() {
        initComponents();
        try
        {
            DefaultTableModel model=(DefaultTableModel)product_table.getModel();
            Object [] row=new Object[4];
            RmiInterface access = (RmiInterface)Naming.lookup("rmi://localhost:33066"+ "/database"); 
           String list[][]=access.GetRs("productlist");
           //System.out.println(list.length);
            for(int i=0;i<list.length;i++)
            {
                row[0]=list[i][0];
                row[1]=list[i][1];
                row[2]=list[i][2];
                row[3]=list[i][3];
                model.addRow(row);
            }
        }
        catch(Exception e)
        {
            System.out.println("Pr");
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dis_label = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        product_table = new javax.swing.JTable();
        dis_label1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        display_table = new javax.swing.JTable();
        dis_label2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bill_field = new javax.swing.JTextArea();
        bill_label = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dis_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dis_label.setForeground(new java.awt.Color(0, 153, 153));
        dis_label.setText("To delete item from cart click on product id");
        getContentPane().add(dis_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 250, 20));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 102));
        jButton1.setText("Generate Bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 310, -1, -1));

        product_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        product_table.setForeground(new java.awt.Color(0, 102, 102));
        product_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "product id", "Product name", "Company", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        product_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(product_table);
                                                                                            //l-r,t-b,
        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 270));

        dis_label1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dis_label1.setForeground(new java.awt.Color(0, 153, 153));
        dis_label1.setText("Click on item id to add into cart");                         //l-r,t-b,len,wid
        getContentPane().add(dis_label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 210, 20));

        display_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        display_table.setForeground(new java.awt.Color(0, 102, 102));
        display_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product id", "Product", "Company", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        display_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                display_tableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(display_table);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 390, 180));

        dis_label2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dis_label2.setForeground(new java.awt.Color(0, 153, 153));
        dis_label2.setText("Items in Cart");
        getContentPane().add(dis_label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 210, 20));

        bill_field.setEditable(false);
        bill_field.setColumns(20);
        bill_field.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        bill_field.setForeground(new java.awt.Color(0, 153, 51));
        bill_field.setRows(5);
        jScrollPane2.setViewportView(bill_field);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 590, 300));

        bill_label.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bill_label.setForeground(new java.awt.Color(0, 153, 153));
        getContentPane().add(bill_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 380, 110, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void product_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_tableMouseClicked
        // TODO add your handling code here:
        int i=product_table.getSelectedRow();
        int j=product_table.getSelectedColumn();
				
	TableModel ml=product_table.getModel();
	String value=ml.getValueAt(i,j).toString();
        
        if(!cart.contains(value))
            cart.add(value);
	//System.out.println(cart.size());
        Display_items();
        
    }//GEN-LAST:event_product_tableMouseClicked
    
    private void display_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_display_tableMouseClicked
        // TODO add your handling code here:
        
        int i=display_table.getSelectedRow();
        int j=display_table.getSelectedColumn();
				
	TableModel ml=display_table.getModel();
	String value=ml.getValueAt(i,j).toString();
        cart.remove(value);
        Display_items();
      
    }//GEN-LAST:event_display_tableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
          try
          {
            RmiInterface access = (RmiInterface)Naming.lookup("rmi://localhost:33066"+ "/bill"); 
            String Bill[][] = access.query(cart); 
            String tab="\t\t";
            String st="";
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
                //System.out.println(Bill[i][0]+" "+Bill[i][1]+" "+Bill[i][2]+" "+Bill[i][3]+" "+Bill[i][4]);
            }
           SN++;
           cart.removeAll(cart);
           Display_items();
           //st=st+"<html/>";
           bill_field.setText("");
          
           bill_field.setText(st);
          }
          catch(Exception e)
          {
              System.out.println(e);
          }
        
    }//GEN-LAST:event_jButton1ActionPerformed
    public void Display_items()
    {
        try
        {
           Class.forName("org.sqlite.JDBC");
           con=DriverManager.getConnection("jdbc:sqlite:product.sqlite");
           st=con.createStatement();
           
           DefaultTableModel model1=(DefaultTableModel)display_table.getModel();
           
           Object [] row1=new Object[4];
           model1.setRowCount(0);
           
           for(String val:cart)
           {
                query="SELECT *from productlist where product_id='"+val+"'";
                rs=st.executeQuery(query);
                
                while(rs.next())
                {
                    row1[0]=rs.getString(1);
                    row1[1]=rs.getString(2);
                    row1[2]=rs.getString(3);
                    row1[3]=rs.getString(4);
                    model1.addRow(row1);
               }
                   
           }
            
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String usern,String name) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        username=usern;
        cname=name;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bill_field;
    private javax.swing.JLabel bill_label;
    private javax.swing.JLabel dis_label;
    private javax.swing.JLabel dis_label1;
    private javax.swing.JLabel dis_label2;
    private javax.swing.JTable display_table;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable product_table;
    // End of variables declaration//GEN-END:variables
}
