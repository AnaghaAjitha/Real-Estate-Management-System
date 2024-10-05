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


public class OwnerLogInFrame extends JFrame implements ActionListener{
	JTextField txtEnterOwneridHere;
	JButton back;
	JButton logIn;
	JLabel lblNewLabel;
	OwnerLogInFrame()
	{
	
		this.getContentPane().setForeground(Color.white);
        this.getContentPane().setBackground(Color.black);
        this.getContentPane().setLayout(null);
		//this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\abhinandan\\OneDrive\\Desktop\\Dbsms_project\\background6.png")));
		
		
		lblNewLabel = new JLabel("Welcome Owner");
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setBackground(Color.white);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 35));
		lblNewLabel.setBounds(0, 40, 805 , 50);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.getContentPane().add(lblNewLabel);
		
		logIn = new JButton("Log In");

		logIn.setForeground(new Color(0,0,0));
		logIn.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
		logIn.setBackground(Color.white);
		logIn.setBounds(316, 398, 180, 66);
		this.getContentPane().add(logIn);
		
		logIn.addActionListener(this);
		
		txtEnterOwneridHere = new JTextField("Enter Owner ID here..");
		txtEnterOwneridHere.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterOwneridHere.setBackground(Color.white);
		txtEnterOwneridHere.setFont(new Font("Calibri", Font.ITALIC, 26));
		txtEnterOwneridHere.setBounds(204, 166, 394, 56);
		this.getContentPane().add(txtEnterOwneridHere);
		txtEnterOwneridHere.setColumns(10);
		
		
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
			String id;
			boolean flag = false;
			
				id = txtEnterOwneridHere.getText();
				String name = null;
				try {
					GetConnection getConnection = new GetConnection();
					Statement st = getConnection.con.createStatement();
					ResultSet resultSet;
					
					
					
					resultSet = st.executeQuery("select owner_id, oname from owner");

					while(resultSet.next()) {
						if(resultSet.getString(1).equals(id))
						{
							flag = true;
							name = resultSet.getString(2);
							//System.out.println(name);
							break;
						}
					}

				} catch (SQLException e1) {
					System.out.println(e1.getStackTrace());
				}
			
			if(flag) {
				this.dispose();
				OwnerFrameAfterLogIn addText = new OwnerFrameAfterLogIn(id);
				//UpdateTransactionTable obj=new UpdateTransactionTable(id);
				addText.lblNewLabel.setText("Welcome " + name);;
			}
			else
				JOptionPane.showMessageDialog(this,"Invalid Owner-Id");
				
		}
		
	}

	private String getString(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}