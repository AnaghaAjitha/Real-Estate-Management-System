package RealEstate;


import java.awt.event.ActionListener;

import java.awt.Color;

import java.awt.Font;

import java.awt.event.ActionEvent;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JPanel;

import javax.swing.JTextField;

import javax.swing.SwingConstants;



public class InsertOwner extends JFrame implements ActionListener {

	private JTextField oid;

	private JTextField oname;

	private JTextField ophone;

	private JTextField oemail;

	

	private JLabel lbloid;

	private JLabel lbloname;

	private JLabel lblophone;

	private JLabel lbloemail;

	

	private JButton add;

	private JButton back;

	

	InsertOwner() {

		

		//setExtendedState(MAXIMIZED_BOTH);
		this.getContentPane().setFont(new Font("Calibri", Font.BOLD, 25));
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


		

		

		

		JLabel lblNewLabel = new JLabel("ADD OWNER");

		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel.setForeground(Color.white);

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		lblNewLabel.setBounds(264, 10, 268, 51);

		panel.add(lblNewLabel);

		
		back = new JButton("Back");

		back.setHorizontalAlignment(SwingConstants.LEFT);

		back.setBackground(Color.black);

		back.setFont(new Font("Calibri", Font.PLAIN, 15));

		back.setForeground(Color.white);
		back.setBounds(0, 0, 68, 30);

		panel.add(back);


		
		

		back.addActionListener(this);

		

		JPanel panel_1 = new JPanel();

		panel_1.setBackground(Color.black);

		panel_1.setBounds(0, 74, 805, 600);

		panel_1.setLayout(null);

		this.getContentPane().add(panel_1);
		

		oid = new JTextField();

		oid.setColumns(10);

		oid.setBounds(375, 141, 233, 30);

		panel_1.add(oid);

		

		oname = new JTextField();

		oname.setColumns(10);

		oname.setBounds(375, 181, 233, 30);

		panel_1.add(oname);

		

		ophone = new JTextField();

		ophone.setColumns(10);

		ophone.setBounds(375, 221, 233, 30);

		panel_1.add(ophone);

		

		oemail = new JTextField();

		oemail.setColumns(10);

		oemail.setBounds(375, 261, 233, 30);

		panel_1.add(oemail);

		

		lbloid = new JLabel("Owner-ID ");

		lbloid.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

		lbloid.setForeground(new Color(255, 255, 255));

		lbloid.setHorizontalAlignment(SwingConstants.RIGHT);

		lbloid.setBounds(149, 141, 189, 30);

		panel_1.add(lbloid);

		

		lbloname = new JLabel("Owner Name ");

		lbloname.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

		lbloname.setForeground(new Color(255, 255, 255));

		lbloname.setHorizontalAlignment(SwingConstants.RIGHT);

		lbloname.setBounds(149, 181, 189, 30);

		panel_1.add(lbloname);

		

		lblophone = new JLabel("Phone No ");

		lblophone.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

		lblophone.setHorizontalAlignment(SwingConstants.RIGHT);

		lblophone.setForeground(new Color(255, 255, 255));

		lblophone.setBounds(149, 221, 189, 30);

		panel_1.add(lblophone);

		

		lbloemail = new JLabel("Email-ID ");

		lbloemail.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

		lbloemail.setForeground(new Color(255, 255, 255));

		lbloemail.setHorizontalAlignment(SwingConstants.RIGHT);

		lbloemail.setBounds(133, 261, 205, 30);

		panel_1.add(lbloemail);

		
		add = new JButton("ADD");
		add.setBackground(Color.white);
		add.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		add.setForeground(new Color(0, 0, 0));
		add.setBounds(319, 363, 85, 38);
		panel_1.add(add);
		
		add.addActionListener(this);

		

	

	}

	

	@Override

	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == back)

		{

			this.dispose();

			new RealEstateOfficeFrame();

		}

		

		if(e.getSource() == add)

		{

			String ownerid;

			boolean flag = false;

			GetConnection getConnection = null;

			try {

				getConnection = new GetConnection();

			} catch (SQLException e2) {

				e2.printStackTrace();

			}

				ownerid = oid.getText();

				try {

					Statement st = getConnection.con.createStatement();

					ResultSet resultSet;

					

					int size= 1; 

					

					resultSet = st.executeQuery("select owner_id from owner");



					while(resultSet.next()) {

						if(resultSet.getString(1).equals(ownerid))

						{

							JOptionPane.showMessageDialog(this,"Owner id already taken");

							flag = true;

							break;

						}

					}



				} catch (SQLException e1) {

					System.out.println(e1.getStackTrace());

				}

				

				if(flag == false){

					String o_oid = oid.getText();

					String o_oname = oname.getText();

					String o_ophone = ophone.getText();

					String o_oemail = oemail.getText();

					

					Statement st = null;

					try {

						st = getConnection.con.createStatement();

						

						String s = String.format("insert into owner values('%s', '%s', '%s', '%s')", o_oid, o_oname, o_ophone, o_oemail );

					    st.executeUpdate(s);

						

					    JOptionPane.showMessageDialog(this,"Owner sucessfully Inserted");

					    

					} catch (SQLException e1) {

						// TODO Auto-generated catch block

						JOptionPane.showMessageDialog(this,"Invalid insertion, please insert again");

						System.out.println(e1.getMessage());

						e1.printStackTrace();

						

					}

					

				}else

					JOptionPane.showMessageDialog(this,"Error");

				

		}

		

	}



}

