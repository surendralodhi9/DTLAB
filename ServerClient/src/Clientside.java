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

public class Clientside extends JFrame {

	private JPanel contentPane;
	private JTextField  port_field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientside frame = new Clientside();
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
	public Clientside() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton send_btn = new JButton("Send");
		send_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		send_btn.setBounds(457, 304, 89, 23);
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
		lblEnterTheMessage.setBounds(193, 192, 171, 41);
		contentPane.add(lblEnterTheMessage);
		
		final JTextArea message_field = new JTextArea();
		message_field.setBounds(378, 202, 262, 78);
		contentPane.add(message_field);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Client");
		lblWelcomeToThe.setForeground(new Color(0, 102, 51));
		lblWelcomeToThe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWelcomeToThe.setBounds(343, 11, 171, 29);
		contentPane.add(lblWelcomeToThe);
		
		JButton button = new JButton("Connect");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				 try {
                     int Port;
                     BufferedReader Buf =new BufferedReader(new InputStreamReader(System.in));
                     System.out.print(" Enter the Port Address : " );
                     Port=Integer.parseInt(port_field.getText().toString());
                     Socket sok=new Socket("localhost",Port);
                     if(sok.isConnected()==true)
                              System.out.println(" Server Socket is Connected Succecfully. ");
                     InputStream in=sok.getInputStream();
                     OutputStream ou=sok.getOutputStream();
                     PrintWriter pr=new PrintWriter(ou);
                     BufferedReader buf1=new BufferedReader(new InputStreamReader(System.in));
                     BufferedReader buf2=new BufferedReader(new InputStreamReader(in));
                     String str1,str2;
                     System.out.print(" Enter the Message : ");
                     str1=message_field.getText().toString();
                     pr.println(str1);
                     pr.flush();
                     System.out.println(" Message Send Successfully. ");
                     str2=buf2.readLine();
                     message_field.setText(str2);
                     System.out.println(" Message From Server : " + str2);
                  }
                 catch(Exception e)
                     {
                       System.out.println(" Error : " + e.getMessage());
                     }

				
			}
		});
		button.setBounds(457, 124, 89, 23);
		contentPane.add(button);
	}

}
