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
	private JTextField port_field;

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
	}

	/**
	 * Create the frame.
	 */
	public Serverside() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSend.setBounds(452, 289, 89, 23);
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
		lblEnterTheMessage.setBounds(193, 179, 171, 41);
		contentPane.add(lblEnterTheMessage);
		
		final JTextArea message_field = new JTextArea();
		message_field.setBounds(378, 189, 262, 78);
		contentPane.add(message_field);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Server");
		lblWelcomeToThe.setForeground(new Color(0, 102, 51));
		lblWelcomeToThe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWelcomeToThe.setBounds(341, 21, 171, 29);
		contentPane.add(lblWelcomeToThe);
		
		JButton connect_btn = new JButton("Connect");
		connect_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
                {
                       int Port;
                       BufferedReader Buf =new BufferedReader(new InputStreamReader(System.in));
                       
                       System.out.print(" Enter the Port Address : " );
                       
                       Port=Integer.parseInt(port_field.getText().toString());
                       ServerSocket sok =new ServerSocket(Port);
                       System.out.println(" Server is Ready To Receive a Message. ");
                       System.out.println(" Waiting ..... ");
                       Socket so=sok.accept();
                       if(so.isConnected()==true)
                          System.out.println(" Client Socket is Connected Succecfully. ");
                       InputStream in=so.getInputStream();
                       OutputStream ou=so.getOutputStream();
                       PrintWriter pr=new PrintWriter(ou);
                       BufferedReader buf=new BufferedReader(new InputStreamReader(in));
                       String str=buf.readLine();
                       System.out.println(" Message Received From Client : " + str);
                       
                       System.out.print(" Enter message to Forwarded To Client: ");
                       
                       String msend=message_field.getText().toString();
                       pr.println(msend);
                       pr.flush();
                }
               catch(Exception e)
                  {
                      System.out.println(" Error : " + e.getMessage());
                    }

			}
		});
		connect_btn.setBounds(452, 132, 89, 23);
		contentPane.add(connect_btn);
	}
}
