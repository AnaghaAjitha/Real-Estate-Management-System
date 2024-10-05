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


public class GuestInterfaceLogIn extends JFrame implements ActionListener{
	JTextField txtEnterUsernameHere;
	JTextField txtEnterPasswordHere;
	JButton back;
	JButton createAccnt;
	JButton logIn;
	JLabel lblNewLabel;
	
	
	GuestInterfaceLogIn()
	{
	
		this.getContentPane().setForeground(Color.black);
		this.getContentPane().setBackground(new Color(0, 0, 0));
		this.getContentPane().setLayout(null);
		//this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\abhinandan\\OneDrive\\Desktop\\Dbsms_project\\background6.png")));
		
		
		lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setBackground(Color.white);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 44));
		lblNewLabel.setBounds(0, 40, 805 , 50);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.getContentPane().add(lblNewLabel);
		
		logIn = new JButton("Log In");

		logIn.setForeground(Color.black);
		logIn.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
		logIn.setBackground(Color.white);
		logIn.setBounds(316, 398, 180, 66);
		this.getContentPane().add(logIn);
		
		logIn.addActionListener(this);
		
		createAccnt = new JButton("Create Account");

		createAccnt.setForeground(new Color(240, 255, 240));
		createAccnt.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
		createAccnt.setBackground(new Color(0, 0, 0));
		createAccnt.setBounds(316, 398, 180, 66);
		this.getContentPane().add(logIn);
		
		createAccnt.addActionListener(this);
		
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
		
		
		back = new JButton("Back");
		back.setFont(new Font("Calibri", Font.ITALIC, 12));
		back.setForeground(Color.WHITE);
		back.setBackground(Color.black);
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
		if(e.getSource() == logIn)
		{
			//check the validity (is agent agent_id and password true or false)
			String username,passwd;
			boolean flag = false;
			
				username = txtEnterUsernameHere.getText();
				passwd = txtEnterPasswordHere.getText();
				String name = null;

				try {

					GetConnection getConnection = new GetConnection();
					Statement st = getConnection.con.createStatement();
					ResultSet resultSet;
					int size= 1; 
					resultSet = st.executeQuery("select username,password from guest");
					while(resultSet.next()) {
						if(resultSet.getString(1).equals(username) && resultSet.getString(2).equals(passwd))
						{
							flag = true;
							name = resultSet.getString(1);
							break;
						}
					}
					if (flag==false) {
						String[] options = {"Ok", "Create Account"};
						int choice = JOptionPane.showOptionDialog(null, "Invalid Username or Password", "Error",
						        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
						if (choice == JOptionPane.YES_OPTION) {
						    new GuestInterfaceLogIn();
						} else if (choice == JOptionPane.NO_OPTION) {
						    new GuestCreateAccount();
						}
					}
				} catch (SQLException e1) {
					System.out.println(e1.getStackTrace());
				}
			if(flag == true) {
				this.dispose();
				GuestInterfaceAfterLogIn addText = new GuestInterfaceAfterLogIn(name);
				addText.lblNewLabel.setText("Welcome " + name);
			}}
		}
	private String getString(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}