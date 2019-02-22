import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.*;


public class Serverside extends JFrame {

	private JPanel contentPane;
	private static JTextField port_field;
	private static JTextArea messageR;
	private static JLabel message_dis;
	private static Socket so;
	private static ServerSocket sok;
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
					Serverside frame = new Serverside();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		String str="Connect";
		try
        {
               int Port=33064;
               
               
               sok =new ServerSocket(Port);
               System.out.println(" Server is Ready To Receive a Message. ");
               System.out.println(" Waiting ..... ");
               so=sok.accept();
               if(so.isConnected()==true)
               {
                  System.out.println(" Client Socket is Connected Succecfully. ");
                  message_dis.setText("Client Socket is Connected Succecfully.");
               }
               in=new DataInputStream(so.getInputStream());
               pr=new DataOutputStream(so.getOutputStream());
               
               while(!str.equals("exit"))
               {
				   str=in.readUTF();
                  System.out.println(" Message Received From Client : " + str);
                  messageR.setText(messageR.getText()+"\n"+str);
               }
               
                     
        }
       catch(Exception e)
          {
    	   System.out.println("Server R");
              System.out.println(" Error : " + e.getMessage());
            }

	}

	/**
	 * Create the frame.
	 */
	public Serverside() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 
				try
				{
					
					
					                 String msend="";
	                             msend=message_field.getText().toString();
	                                 System.out.println(" Message send to dsfffgh Client : " + msend);

                                       pr.writeUTF(msend);
                   
              
				}
				catch(Exception e)
				{
					System.out.println("Server S");
					System.out.println(e+" "+e.getMessage());
				}
			}
		});
		btnSend.setBounds(402, 345, 89, 23);
		contentPane.add(btnSend);
		
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
		lblEnterTheMessage.setBounds(197, 233, 171, 41);
		contentPane.add(lblEnterTheMessage);
		
		message_field = new JTextArea();
		message_field.setBounds(378, 243, 262, 78);
		contentPane.add(message_field);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Server");
		lblWelcomeToThe.setForeground(new Color(0, 102, 51));
		lblWelcomeToThe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWelcomeToThe.setBounds(341, 21, 171, 29);
		contentPane.add(lblWelcomeToThe);
		
		JButton connect_btn = new JButton("Connect");
		connect_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
							}
		});
		connect_btn.setBounds(452, 132, 89, 23);
		contentPane.add(connect_btn);
		
	    messageR = new JTextArea();
		messageR.setBounds(656, 243, 262, 78);
		contentPane.add(messageR);
		
	    message_dis = new JLabel("");
		message_dis.setForeground(new Color(0, 102, 51));
		message_dis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		message_dis.setBounds(378, 191, 262, 29);
		contentPane.add(message_dis);
	}
}
