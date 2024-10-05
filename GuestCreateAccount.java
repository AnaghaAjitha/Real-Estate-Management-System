package RealEstate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;

public class GuestCreateAccount extends JFrame implements ActionListener{
	JTextField txtEnterUsernameHere;
	JTextField txtEnterPasswordHere;
	JButton back;
	JButton createaccnt;
	JLabel create;
	JLabel lblNewLabel;
	GuestCreateAccount()
	{
		this.getContentPane().setForeground(new Color(64, 224, 208));
		this.getContentPane().setBackground(new Color(0, 0, 0));
		this.getContentPane().setLayout(null);
		//this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\abhinandan\\OneDrive\\Desktop\\Dbsms_project\\background6.png")));
		
		createaccnt= new JButton("Create Account");
		createaccnt.setForeground(Color.black);
		createaccnt.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
		createaccnt.setBackground(Color.white);
		createaccnt.setBounds(300, 398, 220, 66);
		this.getContentPane().add(createaccnt);
		createaccnt.addActionListener(this);
		
		txtEnterUsernameHere = new JTextField("Enter Username here..");
		txtEnterUsernameHere.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterUsernameHere.setBackground(Color.WHITE);
		txtEnterUsernameHere.setFont(new Font("Calibri", Font.ITALIC, 26));
		txtEnterUsernameHere.setBounds(204, 166, 394, 56);
		this.getContentPane().add(txtEnterUsernameHere);
		txtEnterUsernameHere.setColumns(10);
		
		txtEnterPasswordHere = new JTextField("Enter Password here..");
		txtEnterPasswordHere.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterPasswordHere.setBackground(Color.WHITE);
		txtEnterPasswordHere.setFont(new Font("Calibri", Font.ITALIC, 26));
		txtEnterPasswordHere.setBounds(204, 280, 394, 56);
		this.getContentPane().add(txtEnterPasswordHere);
		txtEnterPasswordHere.setColumns(10);

		create = new JLabel("Create Account");
		create.setForeground(Color.white);
		create.setBackground(Color.black);
		create.setFont(new Font("Calibri", Font.BOLD, 44));
		create.setBounds(0, 40, 805 , 50);
		create.setHorizontalAlignment(SwingConstants.CENTER);
		this.getContentPane().add(create);
		
		
		back = new JButton("Back");
		back.setFont(new Font("Calibri", Font.ITALIC, 20));
		back.setForeground(Color.WHITE);
		back.setBackground(Color.DARK_GRAY);
		back.setBounds(0, 0, 79, 33);
		this.getContentPane().add(back);
		this.setBounds(100, 100, 819, 535);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		back.addActionListener(this);
		this.setResizable(false);
		this.setVisible(true);

	}



	@Override

	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub
		if(e.getSource() == back)
		{
			this.dispose();
			new RealEstatePortal();
		}

		if(e.getSource() == createaccnt)
		{
			String username;
			String passwd;
			boolean flag = false;
			
			username = txtEnterUsernameHere.getText();
			passwd = txtEnterPasswordHere.getText();
			String name = null;
			
			try {
				GetConnection getConnection = new GetConnection();
				Statement st = getConnection.con.createStatement();
				ResultSet resultSet;
				
				int size= 1; 
				
				
				String s = String.format("insert into guest values('%s', '%s')", username, passwd);
				st.executeUpdate(s);
				JOptionPane.showMessageDialog(this,"Account created successfully");
				flag = true;

			} catch (SQLException e1) {
				System.out.println(e1.getStackTrace());
			}
			

			

			if(flag == true) {
				this.dispose();
				new GuestInterfaceLogIn();
			}
		}
	}



	private String getString(int i) {

		// TODO Auto-generated method stub

		return null;

	}}