import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.*;

public class Client1 extends JFrame {

	private JPanel contentPane;
	private static JTextField  port_field;
	private static JTextArea messageR;
	private static JLabel message_dis;
	private static Socket sok;
	private static DataInputStream in;
    private static DataOutputStream pr;
 
    private JTextArea message_field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client1 frame = new Client1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		String str="Connected";
		 try {
			 
			 
			 int Port=33064;
            
            sok=new Socket("localhost",Port);
            if(sok.isConnected()==true)
                     System.out.println(" Server Socket is Connected Succecfully. ");
            
            
            in=new DataInputStream(sok.getInputStream());
            pr=new DataOutputStream(sok.getOutputStream());
           
	
            while(!str.equals("exit"))
            {
           	   str=in.readUTF();
           	   System.out.println(str);
           	   messageR.setText(messageR.getText()+"\n"+str);
            }
            
           
         }
        catch(Exception e)
            {
        	  System.out.println("Clinet R");
              System.out.println(" Error : " + e.getMessage());
            }


	}

	/**
	 * Create the frame.
	 */
	public Client1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 600, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton send_btn = new JButton("Send");
		send_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					
				        
                    String str1="";
                   // System.out.print(" Enter the Message : ");
                   // message_dis.setText("Enter the message");
                    str1=message_field.getText().trim();
                    System.out.println("jjffkgkfd"+ str1);
                    pr.writeUTF(str1);
                       
				}
				catch(Exception e)
				{
					System.out.println("Clinet S");
					System.out.println(e+" "+e.getMessage());
				}
			}
		});
		send_btn.setBounds(457, 335, 89, 23);
		contentPane.add(send_btn);
		
		port_field = new JTextField();
		port_field.setBounds(378, 84, 262, 29);
		contentPane.add(port_field);
		port_field.setColumns(10);
		
		JLabel lblEnterThePort = new JLabel("Enter the port number");
		lblEnterThePort.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterThePort.setForeground(new Color(0, 102, 51));
		lblEnterThePort.setBounds(193, 84, 171, 29);
		contentPane.add(lblEnterThePort);
		
		JLabel lblEnterTheMessage = new JLabel("Enter the message");
		lblEnterTheMessage.setForeground(new Color(0, 102, 51));
		lblEnterTheMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterTheMessage.setBounds(193, 236, 171, 41);
		contentPane.add(lblEnterTheMessage);
		
		message_field = new JTextArea();
		message_field.setBounds(378, 246, 262, 78);
		contentPane.add(message_field);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Client1");
		lblWelcomeToThe.setForeground(new Color(0, 102, 51));
		lblWelcomeToThe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWelcomeToThe.setBounds(343, 11, 171, 29);
		contentPane.add(lblWelcomeToThe);
		
		JButton button = new JButton("Connect");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
							}
		});
		button.setBounds(457, 124, 89, 23);
		contentPane.add(button);
		
		messageR = new JTextArea();
		messageR.setBounds(650, 246, 262, 78);
		contentPane.add(messageR);
		
	    message_dis = new JLabel("");
		message_dis.setForeground(new Color(0, 102, 51));
		message_dis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		message_dis.setBounds(374, 190, 262, 29);
		contentPane.add(message_dis);
	}

}
