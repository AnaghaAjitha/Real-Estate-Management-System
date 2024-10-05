package RealEstate;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;

public class OwnerFrameAfterLogIn extends JFrame implements ActionListener{
	JButton propertyDetail;
	JButton buyerDetails;
	JButton ownerDetails;
	JButton agentDetail;
	JButton back;
	JLabel lblNewLabel;
	String id;
	
	OwnerFrameAfterLogIn(String id)
	{
		this.id=id;
		this.getContentPane().setForeground(new Color(0,0,0));
		this.getContentPane().setBackground(new Color(0,0,0));
		this.getContentPane().setLayout(null);
		//this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\abhinandan\\OneDrive\\Desktop\\Dbsms_project\\background6.png")));
		
		
		lblNewLabel = new JLabel("Welcome Owner");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setBackground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 35));
		lblNewLabel.setBounds(0, 40, 805 , 50);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.getContentPane().add(lblNewLabel);
			
		propertyDetail = new JButton("Property Details");
		propertyDetail.setForeground(new Color(0, 0, 0));
		propertyDetail.setBackground(Color.white);
		propertyDetail.setFont(new Font("Calibri", Font.BOLD, 24));
		propertyDetail.setBounds(98, 133, 273, 141);
		this.getContentPane().add(propertyDetail);
		
		propertyDetail.addActionListener(this);
		
		
		buyerDetails = new JButton("Buyer Details");
		buyerDetails.setBackground(Color.white);
		buyerDetails.setFont(new Font("Calibri", Font.BOLD, 24));
		buyerDetails.setBounds(98, 314, 273, 141);
		this.getContentPane().add(buyerDetails);
		
		buyerDetails.addActionListener(this);
		agentDetail = new JButton("Agent Details");
		agentDetail.setBackground(Color.white);
		agentDetail.setFont(new Font("Calibri", Font.BOLD, 24));
		agentDetail.setBounds(436, 133, 273, 138);
		this.getContentPane().add(agentDetail);
		
		agentDetail.addActionListener(this);
		
	
		
		back = new JButton("Back");
		back.setFont(new Font("Calibri", Font.ITALIC, 12));
		back.setBackground(Color.BLACK);
		back.setForeground(Color.white);
		back.setBounds(0, 0, 77, 30);
		this.getContentPane().add(back);
		
		back.addActionListener(this);
		
		this.setBounds(100, 100, 819, 535);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(false);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == back)
		{
			this.dispose();
			new OwnerLogInFrame();
		}
		
		if(e.getSource() == buyerDetails)
		{
			try {
				GetConnection getConnection = new GetConnection();
				Statement st = getConnection.con.createStatement();
				ResultSet resultSet = st.executeQuery("select count(*) from buyer join property on buyer.prop_id=property.prop_id WHERE owner_id = '" + id + "'");
				
				int size= 0;  
				resultSet.next();
				//System.out.println(resultSet.getInt(1));
				size = resultSet.getInt(1);  
				resultSet = st.executeQuery("select buyer_id, bname, bemail,bphone from buyer join property on buyer.prop_id=property.prop_id WHERE owner_id = '" + id + "'");
				
				String data[][] = new String[size][];
				String columnName[] = {"Buyer_ID","Name", "Email_id","Phone"};
				String title = "buyer details";
				
				int i = 0;
				while(resultSet.next()) {
					
					String str = String.format("%s,%s,%s,%d",resultSet.getString(1),
							resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
					
					data[i] = str.split(",");
					i++;
				       
				}
				
				new JTableClass(data, columnName, title);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		
		
		if(e.getSource() == propertyDetail)
		{
			try {
				GetConnection getConnection = new GetConnection();
				Statement st = getConnection.con.createStatement();
				//ResultSet resultSet = st.executeQuery("select count(*) from property");
				ResultSet resultSet = st.executeQuery("SELECT count(*) FROM property WHERE owner_id = '" + id + "'");
				int size= 0;  
				resultSet.next();
				
				size = resultSet.getInt(1); 
				
				resultSet = st.executeQuery("select prop_id, type, category, locality, city, state, features, price, owner_id from property where owner_id='"+id+"'");
				
				String data[][] = new String[size][];
				String columnName[] = {"Property_ID","Type", "Category", "Locality",
						"City", "State","Features", "Price"};
				String title = "property details";
				
				int i = 0;
				while(resultSet.next()) {
					
					String str = String.format("%s_%s_%s_%s_%s_%s_%s_%d_%s",resultSet.getString(1),
							resultSet.getString(2),resultSet.getString(3), resultSet.getString(4),
							resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),resultSet.getString(9));
					
					data[i] = str.split("_");
					i++;
				       
				}
				
				new JTableClass(data, columnName, title);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == agentDetail)
		{
			try {
				GetConnection getConnection = new GetConnection();
				Statement st = getConnection.con.createStatement();
				//ResultSet resultSet = st.executeQuery("select count(*) from property");
				ResultSet resultSet = st.executeQuery("SELECT COUNT(*) FROM agent JOIN property ON agent.agent_id = property.agent_id WHERE owner_id = '" + id + "'");
				int size= 0;  
				resultSet.next();
				
				size = resultSet.getInt(1); 
				
				resultSet = st.executeQuery("select agent.agent_id,prop_id, aname, aphone, aemail from agent join property on agent.agent_id=property.agent_id WHERE owner_id = '" + id + "'");
				
				String data[][] = new String[size][];
				String columnName[] = {"Agent_ID","Property ID","Name", "Phone", "Email"};
				String title = "agent details";
				
				int i = 0;
				while(resultSet.next()) {
					
					String str = String.format("%s,%s,%s,%d,%s",resultSet.getString(1),resultSet.getString(2)
							,resultSet.getString(3),resultSet.getInt(4), resultSet.getString(5));
					
					data[i] = str.split(",");
					i++;
				       
				}
				
				new JTableClass(data, columnName, title);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}

