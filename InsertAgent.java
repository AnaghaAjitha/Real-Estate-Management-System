package RealEstate;

import java.awt.Color;

import java.awt.Font;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

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



public class InsertAgent extends JFrame implements ActionListener {

	private JTextField aid;

	private JTextField anme;

	private JTextField apho;

	private JTextField amail;

	private JTextField deal_comp;

	private JTextField rent;

	private JTextField sell;

	

	

	private JLabel lblaid;

	private JLabel lblanme;

	private JLabel lblapho;

	private JLabel lblamail;

	private JLabel lbldeal_comp;

	private JLabel lblrent;

	private JLabel lblsell;

	private JLabel lbloid;

	private JButton add;

	private JButton back;

	

	InsertAgent() {

	

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

	
	
	
	
	JLabel lblNewLabel = new JLabel("ADD AGENT");

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

	

	aid = new JTextField();

	aid.setColumns(10);

	aid.setBounds(375, 61, 233, 30);

	panel_1.add(aid);

	

	anme = new JTextField();

	anme.setColumns(10);

	anme.setBounds(375, 101, 233, 30);

	panel_1.add(anme);

	

	apho = new JTextField();

	apho.setColumns(10);

	apho.setBounds(375, 141, 233, 30);

	panel_1.add(apho);

	

	amail = new JTextField();

	amail.setColumns(10);

	amail.setBounds(375, 181, 233, 30);

	panel_1.add(amail);

	

	

	

	
	

	lblaid = new JLabel("Agent-Id ");

	lblaid.setForeground(new Color(255, 255, 255));

	lblaid.setHorizontalAlignment(SwingConstants.RIGHT);

	lblaid.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

	lblaid.setBounds(149, 60, 189, 30);

	panel_1.add(lblaid);

	

	lblanme = new JLabel("Name ");

	lblanme.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

	lblanme.setHorizontalAlignment(SwingConstants.RIGHT);

	lblanme.setForeground(new Color(255, 255, 255));

	lblanme.setBounds(149, 101, 189, 30);

	panel_1.add(lblanme);

	

	lblapho = new JLabel("Phone No. ");

	lblapho.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

	lblapho.setForeground(new Color(255, 255, 255));

	lblapho.setHorizontalAlignment(SwingConstants.RIGHT);

	lblapho.setBounds(149, 141, 189, 30);

	panel_1.add(lblapho);

	

	lblamail = new JLabel("Email ");

	lblamail.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

	lblamail.setForeground(new Color(255, 255, 255));

	lblamail.setHorizontalAlignment(SwingConstants.RIGHT);

	lblamail.setBounds(149, 181, 189, 30);

	panel_1.add(lblamail);

	

	
	add = new JButton("ADD");
	add.setBackground(Color.white);
	add.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
	add.setForeground(new Color(0, 0, 0));
	add.setBounds(319, 363, 85, 38);
	panel_1.add(add);
	



	

	

	/*add = new JButton("ADD");

	add.setBackground(Color.white);

	add.setFont(new Font("Calibri", Font.PLAIN, 20));

	add.setForeground(Color.black);

	add.setBounds(319, 490, 85, 38);

	panel_1.add(add);*/

	

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

	String propid;

	boolean flag = false;

	GetConnection getConnection = null;

	try {

	getConnection = new GetConnection();

	} catch (SQLException e2) {

	e2.printStackTrace();

	}

	propid = aid.getText();

	try {

	Statement st = getConnection.con.createStatement();

	ResultSet resultSet;

	

	int size= 1; 

	

	resultSet = st.executeQuery("select prop_id from property");



	while(resultSet.next()) {

	if(resultSet.getString(1).equals(propid))

	{

	JOptionPane.showMessageDialog(this,"Property id already taken");

	flag = true;

	break;

	}

	}



	} catch (SQLException e1) {

	System.out.println(e1.getStackTrace());

	}

	

	if(flag == false){

	String a_id = aid.getText();

	String a_name = anme.getText();

	//String a_phone = apho.getText();

	String a_email = amail.getText();

	int a_deal_comp = 0;

	int a_rent = 0;

	int a_sell = 0;
	
	Statement st = null;

	try {

	st = getConnection.con.createStatement();
	int a_phone = Integer.parseInt(apho.getText());

	

	String s = String.format("INSERT INTO agent VALUES ('%s', '%s', '%s', '%s', %d, %d, %d)",
            a_id, a_name, a_phone, a_email, a_deal_comp, a_rent, a_sell);


	st.executeUpdate(s);

	

	JOptionPane.showMessageDialog(this,"New Agent sucessfully Inserted");

	

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