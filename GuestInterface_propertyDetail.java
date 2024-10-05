package RealEstate;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GuestInterface_propertyDetail extends JFrame implements ActionListener{
	JTextField textField;
	JButton back;
	JButton show;
	String name;
	GuestInterface_propertyDetail()
	{
		this.getContentPane().setForeground(new Color(64, 224, 208));
		this.getContentPane().setBackground(new Color(175, 238, 238));
		this.getContentPane().setLayout(null);
		this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\abhinandan\\OneDrive\\Desktop\\Dbsms_project\\background6.png")));
		
		
		JLabel lblNewLabel = new JLabel("Welcome Guest");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(266, 39, 273, 52);
		this.getContentPane().add(lblNewLabel);
		
		show = new JButton("Show");
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		show.setForeground(new Color(240, 255, 240));
		show.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 24));
		show.setBackground(new Color(0, 0, 0));
		show.setBounds(296, 400, 180, 66);
		this.getContentPane().add(show);
		
		show.addActionListener(this);
		
		textField = new JTextField("Enter Property_id here..");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Cambria", Font.ITALIC, 26));
		textField.setBounds(186, 262, 394, 66);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Enter the Property_id to see the property details.<br>&nbsp &nbsp &nbsp &nbsp &nbsp Click On show After you are Done.</html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Cambria", Font.ITALIC, 26));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(62, 116, 682, 73);
		
		back = new JButton("Back");
		back.setFont(new Font("Yu Gothic", Font.ITALIC, 21));
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(0, 0, 95, 32);
		this.getContentPane().add(back);
		
		back.addActionListener(this);
		
		this.getContentPane().add(lblNewLabel_1);
		this.setBounds(100, 100, 819, 535);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setResizable(false);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == show)
		{
			String id;
			boolean flag = false;
			
				id = textField.getText();
				try {
					GetConnection getConnection = new GetConnection();
					Statement st = getConnection.con.createStatement();
					ResultSet resultSet;
					
					int size= 1; 
					
					resultSet = st.executeQuery("select prop_id from property");

					while(resultSet.next()) {
						if(resultSet.getString(1).equals(id))
						{
							flag = true;
							break;
						}
					}

				} catch (SQLException e1) {
					System.out.println(e1.getStackTrace());
				}
			if(flag == true)
			{
				try {
					GetConnection getConnection = new GetConnection();
					Statement st = getConnection.con.createStatement();
					ResultSet resultSet;
					
					int size= 1;  
					resultSet = st.executeQuery("select prop_id, type, category, locality, city, state, features, price,owner_id,agent_id from property where prop_id='"+id+"'");
					
					String data[][] = new String[size][];
					String columnName[] = {"Property_ID","Type", "Category", "Locality","City", "State","Features", "Price","Owner_ID","Agent_ID"};
					String title = "property detail corrosponding to given property_id";
					
					int i = 0;
					while(resultSet.next()) {
						
						String str = String.format("%s_%s_%s_%s_%s_%s_%s_%d_%s_%s",resultSet.getString(1),
								resultSet.getString(2),resultSet.getString(3), resultSet.getString(4),
								resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8),resultSet.getString(9),resultSet.getString(10));
						
						data[i] = str.split("_");
						i++;
					       
					}
					
					new JTableClass(data, columnName, title);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}else {
				JOptionPane.showMessageDialog(this,"No detail exist for the given Property_id");
			}
			
			
		}
		if(e.getSource() == back)
		{
			this.dispose();
			new GuestInterfaceAfterLogIn(name);
		}
		
	}
}