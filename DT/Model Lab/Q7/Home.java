/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    Connection con=null;
    Statement st=null;
    ResultSet rs=null;
    String query=null;
       
    public Home() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        username_field = new javax.swing.JTextField();
        password_field = new javax.swing.JPasswordField();
        login_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Enjoy Online Shopping...");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 260, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 80, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Username");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 80, 30));

        username_field.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        username_field.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 220, 30));

        password_field.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password_field.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(password_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 220, 30));

        login_btn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        login_btn.setForeground(new java.awt.Color(0, 102, 102));
        login_btn.setText("Login");
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });
        getContentPane().add(login_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 70, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        // TODO add your handling code here:
        String user_name=username_field.getText().toString();
        String pass_word=password_field.getText().toString();
        try
        {
            Class.forName("org.sqlite.JDBC");
            con=DriverManager.getConnection("jdbc:sqlite:Consumer.sqlite");//To create database if not exist
            String query = "select  *from CUSTOMER where username='"+user_name+"' and password='"+pass_word+"'";
            st = con.createStatement();
	    rs = st.executeQuery(query);
           if(!rs.next())
             {
	       JOptionPane.showMessageDialog(null,"your username or password is incorrect","Error Message",JOptionPane.WARNING_MESSAGE);
	       System.out.println("Wrong password");
	     }
             else
             {
                 rs=st.executeQuery(query);
                 
               //JOptionPane.showMessageDialog(null,"Login sucessfull","Message",JOptionPane.INFORMATION_MESSAGE);
               Product obj=new Product();
               if(rs.next())
               obj.main(rs.getString(1),rs.getString(3));
               dispose();
             }
           
            
        }
        catch(Exception e)
        {
             System.out.println(e);
        }
         
        
        
        
    }//GEN-LAST:event_login_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton login_btn;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JTextField username_field;
    // End of variables declaration//GEN-END:variables
}
