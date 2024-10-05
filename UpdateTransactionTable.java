package RealEstate;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class UpdateTransactionTable extends JFrame implements ActionListener{
	private JTextField TransType;
	private JTextField Trans_Id;
	private JTextField Prop_Id;
	private JTextField price;
	private JTextField date;
	private JTextField own_id;
	private JTextField client_id;
	private JTextField Agent_Id;
	private JLabel lblNewLabel_2;
	private JLabel lblPropertyId;
	private JLabel lblPrice;
	private JLabel lblDate;
	private JLabel lblOwnerId;
	private JLabel lblClientid;
	private JLabel lblAgentid;
	private JButton add;
	private JButton back;
	String id;
	UpdateTransactionTable(String id)
	{
		this.id=id;
		this.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 25));
		this.setBounds(100, 100, 819, 535);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.black);
		panel.setBounds(0, 0, 805, 73);
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("ADD TRANSACTION");
		lblNewLabel.setBackground(Color.white);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 25));
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(264, 10, 268, 51);
		panel.add(lblNewLabel);
		
		back = new JButton("Back");
		back.setHorizontalAlignment(SwingConstants.LEFT);
		back.setBackground(new Color(0,0, 0));
		back.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		back.setForeground(Color.white);
		back.setBounds(0, 0, 68, 30);
		panel.add(back);
		
		back.addActionListener(this);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.black);
		panel_1.setBounds(0, 74, 805, 424);
		panel_1.setLayout(null);
		this.getContentPane().add(panel_1);
		
	
		Trans_Id = new JTextField();
		Trans_Id.setColumns(10);
		Trans_Id.setBounds(375, 61, 233, 30);
		panel_1.add(Trans_Id);
		
		Prop_Id = new JTextField();
		Prop_Id.setColumns(10);
		Prop_Id.setBounds(375, 101, 233, 30);
		panel_1.add(Prop_Id);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(375, 141, 233, 30);
		panel_1.add(price);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(375, 181, 233, 30);
		panel_1.add(date);
		
		own_id = new JTextField();
		own_id.setColumns(10);
		own_id.setBounds(375, 221, 233, 30);
		panel_1.add(own_id);
		
		client_id = new JTextField();
		client_id.setColumns(10);
		client_id.setBounds(375, 261, 233, 30);
		panel_1.add(client_id);
		
		Agent_Id = new JTextField();
		Agent_Id.setColumns(10);
		Agent_Id.setBounds(375, 301, 233, 30);
		panel_1.add(Agent_Id);
		
		/*JLabel lblNewLabel_1 = new JLabel("Transaction-Type ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(105, 21, 233, 30);
		panel_1.add(lblNewLabel_1);*/
		
		lblNewLabel_2 = new JLabel("Transaction-Id ");
		lblNewLabel_2.setForeground(Color.white);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(149, 60, 189, 30);
		panel_1.add(lblNewLabel_2);
		
		lblPropertyId = new JLabel("Property-Id ");
		lblPropertyId.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblPropertyId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPropertyId.setForeground(Color.white);
		lblPropertyId.setBounds(149, 101, 189, 30);
		panel_1.add(lblPropertyId);
		
		lblPrice = new JLabel("Price ");
		lblPrice.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblPrice.setForeground(Color.white);
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setBounds(149, 141, 189, 30);
		panel_1.add(lblPrice);
		
		lblDate = new JLabel("Date ");
		lblDate.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblDate.setForeground(Color.white);
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setBounds(149, 181, 189, 30);
		panel_1.add(lblDate);
		
		lblOwnerId = new JLabel("Owner-Id ");
		lblOwnerId.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblOwnerId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOwnerId.setForeground(Color.white);
		lblOwnerId.setBounds(149, 221, 189, 30);
		panel_1.add(lblOwnerId);
		
		lblClientid = new JLabel("Buyer-Id ");
		lblClientid.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblClientid.setForeground(Color.white);
		lblClientid.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClientid.setBounds(133, 261, 205, 30);
		panel_1.add(lblClientid);
		
		lblAgentid = new JLabel("Agent-Id ");
		lblAgentid.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblAgentid.setForeground(Color.white);
		lblAgentid.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAgentid.setBounds(149, 301, 189, 30);
		panel_1.add(lblAgentid);
		
		add = new JButton("ADD");
		add.setBackground(Color.white);
		add.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		add.setForeground(new Color(0, 0, 0));
		add.setBounds(319, 363, 85, 38);
		panel_1.add(add);
		
		add.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		if(e.getSource() == back)
		{
			this.dispose();
			new AgentFrameAfterLogIn(id);
			//UpdateTransactionTable obj=new UpdateTransactionTable(id);
		}
		
		if(e.getSource() == add)
		{
			String pid;
			boolean flag = false;
			GetConnection getConnection = null;
			try {
				getConnection = new GetConnection();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
				pid =Prop_Id.getText();
				try {
					Statement st = getConnection.con.createStatement();
					ResultSet resultSet;
					
					int size= 1; 
					
					resultSet = st.executeQuery("select prop_id from property where sold = 0");

					while(resultSet.next()) {
						if(resultSet.getString(1).equals(pid))
						{
							flag = true;
							break;
						}
					}

				} catch (SQLException e1) {
					System.out.println(e1.getStackTrace());
				}
				
				if(flag == true){
					//System.out.println(date.getText());
					//String trans_tp = TransType.getText();
					String Date = date.getText();
					String trans_id = Trans_Id.getText();
					String owner_id = own_id.getText();
					String cli_id = client_id.getText();
					String agent_id = Agent_Id.getText();
					String prop_id = Prop_Id.getText();
					int price1 = Integer.parseInt(price.getText());
					Statement st = null;
					try {
						st = getConnection.con.createStatement();
						
						
					    String s = String.format("insert into transaction values('%s', '%s', '%s', '%s', '%s', '%s', '%d')", trans_id, owner_id,
					    		prop_id,agent_id, cli_id,Date, price1);
					    st.executeUpdate(s);
							String sql = "update property set sold=1 where prop_id = '"+ prop_id+"'";
					    	st.executeUpdate(sql);
						
					    
					    JOptionPane.showMessageDialog(this,"Sucessfully Inserted");
					    
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(this,"Invalid insertion, please insert again");
						System.out.println(e1.getMessage());
						e1.printStackTrace();
						
					}
					
				}else
					JOptionPane.showMessageDialog(this,"Either property_id is Wrong or Property is not available to sale or rent");
				
		}
		
		
	}
	
}