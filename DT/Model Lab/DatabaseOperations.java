
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 205117066
 */
public class DatabaseOperations extends javax.swing.JFrame {

    /**
     * Creates new form DatabaseOperations
     */
    public DatabaseOperations() {
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
        table_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Create_btn = new javax.swing.JButton();
        data_field = new javax.swing.JTextField();
        insert_btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        username_field = new javax.swing.JTextField();
        delete_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        table_name3 = new javax.swing.JTextField();
        select_btn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Database Operation");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 120, 20));

        table_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table_nameActionPerformed(evt);
            }
        });
        getContentPane().add(table_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 270, 30));

        jLabel2.setText("Table name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 80, 20));

        Create_btn.setText("Create");
        Create_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Create_btnActionPerformed(evt);
            }
        });
        getContentPane().add(Create_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        data_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(data_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 270, 30));

        insert_btn.setText("Insert");
        insert_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_btnActionPerformed(evt);
            }
        });
        getContentPane().add(insert_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, -1, -1));

        jLabel3.setText("Table name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 80, 20));

        username_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_fieldActionPerformed(evt);
            }
        });
        getContentPane().add(username_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 270, 30));

        delete_btn.setText("Delete");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });
        getContentPane().add(delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, -1, -1));

        jLabel4.setText("Username");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 80, 20));

        table_name3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table_name3ActionPerformed(evt);
            }
        });
        getContentPane().add(table_name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 270, 30));

        select_btn.setText("Select");
        getContentPane().add(select_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, -1, -1));

        jLabel5.setText("Column name");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 80, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_table_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_table_nameActionPerformed

    private void data_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_data_fieldActionPerformed

    private void username_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_fieldActionPerformed

    private void table_name3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_table_name3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_table_name3ActionPerformed

    private void insert_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_btnActionPerformed
        // TODO add your handling code here:
        
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        String query=null;
        try
        {
            Class.forName("org.sqlite.JDBC");
            con=DriverManager.getConnection("jdbc:sqlite:Consumer.sqlite");//To create database if not exist
            String table=table_name.getText();
            String data=data_field.getText();
            int i=0;
            String col1[]=new String[4];
            int r=0;
            while(i<data.length())
            {
                String s1="";
                while(i<data.length()&&data.charAt(i)!=',')
                {
                    s1+=data.charAt(i);
                    i++;
                }
                col1[r++]=s1;
                i++;
            }
            
            query = "INSERT INTO "+table+" (username,password,cname,mobile) VALUES (?, ?, ?, ?)";
            PreparedStatement pst=con.prepareStatement(query);
            pst.setString(1, col1[0]);
            pst.setString(2, col1[1]);
            pst.setString(3, col1[2]);  
            pst.setString(4,col1[3]);
            pst.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_insert_btnActionPerformed

    private void Create_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Create_btnActionPerformed
        // TODO add your handling code here:
        
        
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        String query=null;
        try
        {
            Class.forName("org.sqlite.JDBC");
            con=DriverManager.getConnection("jdbc:sqlite:Consumer.sqlite");//To create database if not exist
            String table=table_name.getText();
              st = con.createStatement();
	      query = "CREATE TABLE "+table+"(username varchar(20) PRIMARY KEY," +" password VARCHAR(20)," +"cname VARCHAR(50)," +"mobile number(10))";
              st.executeUpdate(query);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_Create_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        // TODO add your handling code here:
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        String query=null;
        try
        {
            Class.forName("org.sqlite.JDBC");
            con=DriverManager.getConnection("jdbc:sqlite:Consumer.sqlite");//To create database if not exist
            String table=table_name.getText();
            st = con.createStatement();
            String username=username_field.getText();
	    query = "DELETE FROM "+table+" WHERE username="+username+"";
            st.executeUpdate(query);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
    }//GEN-LAST:event_delete_btnActionPerformed

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
            java.util.logging.Logger.getLogger(DatabaseOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatabaseOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatabaseOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatabaseOperations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatabaseOperations().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Create_btn;
    private javax.swing.JTextField data_field;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton insert_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton select_btn;
    private javax.swing.JTextField table_name;
    private javax.swing.JTextField table_name3;
    private javax.swing.JTextField username_field;
    // End of variables declaration//GEN-END:variables
}