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



public class InsertProp extends JFrame implements ActionListener {

	private JTextField pid;

	private JTextField type;

	private JTextField cat;

	private JTextField loc;

	private JTextField city;

	private JTextField state;

	private JTextField feat;

	private JTextField oid;

	private JTextField aid;

	private JTextField price;

	

	private JLabel lblpid;

	private JLabel lbltype;

	private JLabel lblcat;

	private JLabel lblloc;

	private JLabel lblcity;

	private JLabel lblstate;

	private JLabel lblfeat;

	private JLabel lbloid;

	private JLabel lblaid;

	private JLabel lblprice;

	

	private JButton add;

	private JButton back;

	

	InsertProp() {

	

	//setExtendedState(MAXIMIZED_BOTH);

		this.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 25));
		this.setBounds(200, 200, 900, 900);
		this.setSize(700,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setResizable(false);
		this.setVisible(true);
		

		JPanel panel = new JPanel();
		panel.setBackground(Color.black);
		panel.setBounds(0, 0, 805, 73);
		panel.setLayout(null);
		this.getContentPane().add(panel);

	

	/*JPanel panel = new JPanel();

	panel.setBackground(new Color(220, 208, 225));

	panel.setBounds(0, 0, 805, 73);

	panel.setLayout(null);

	this.getContentPane().add(panel);*/
		
		
		

	

	JLabel lblNewLabel = new JLabel("ADD PROPERTY");
	lblNewLabel.setBackground(Color.white);
	lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
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
	panel_1.setBounds(0, 74, 900, 900);
	panel_1.setLayout(null);
	this.getContentPane().add(panel_1);

	
	

	pid = new JTextField();

	pid.setColumns(10);

	pid.setBounds(375, 61, 233, 30);

	panel_1.add(pid);

	

	type = new JTextField();

	type.setColumns(10);

	type.setBounds(375, 101, 233, 30);

	panel_1.add(type);

	

	cat = new JTextField();

	cat.setColumns(10);

	cat.setBounds(375, 141, 233, 30);

	panel_1.add(cat);

	

	loc = new JTextField();

	loc.setColumns(10);

	loc.setBounds(375, 181, 233, 30);

	panel_1.add(loc);

	

	city = new JTextField();

	city.setColumns(10);

	city.setBounds(375, 221, 233, 30);

	panel_1.add(city);

	

	state = new JTextField();

	state.setColumns(10);

	state.setBounds(375, 261, 233, 30);

	panel_1.add(state);

	

	feat = new JTextField();

	feat.setColumns(10);

	feat.setBounds(375, 301, 233, 30);

	panel_1.add(feat);

	

	oid = new JTextField();

	oid.setColumns(10);

	oid.setBounds(375, 341, 233, 30);

	panel_1.add(oid);

	

	aid = new JTextField();

	aid.setColumns(10);

	aid.setBounds(375, 381, 233, 30);

	panel_1.add(aid);

	

	price = new JTextField();

	price.setColumns(10);

	price.setBounds(375, 421, 233, 30);

	panel_1.add(price);

	

	lblpid = new JLabel("Property-Id ");
	
	lblpid.setForeground(Color.white);

	lblpid.setHorizontalAlignment(SwingConstants.RIGHT);

	lblpid.setFont(new Font("Calibri", Font.PLAIN, 20));

	lblpid.setBounds(149, 60, 189, 30);

	panel_1.add(lblpid);

	

	lbltype = new JLabel("Type ");

	lbltype.setFont(new Font("Calibri", Font.PLAIN, 20));

	lbltype.setHorizontalAlignment(SwingConstants.RIGHT);

	lbltype.setForeground(Color.white);

	lbltype.setBounds(149, 101, 189, 30);

	panel_1.add(lbltype);

	

	lblcat = new JLabel("Category ");

	lblcat.setFont(new Font("Calibri", Font.PLAIN, 20));

	lblcat.setForeground(Color.white);

	lblcat.setHorizontalAlignment(SwingConstants.RIGHT);

	lblcat.setBounds(149, 141, 189, 30);

	panel_1.add(lblcat);

	

	lblloc = new JLabel("Locality ");

	lblloc.setFont(new Font("Calibri", Font.PLAIN, 20));

	lblloc.setForeground(Color.white);

	lblloc.setHorizontalAlignment(SwingConstants.RIGHT);

	lblloc.setBounds(149, 181, 189, 30);

	panel_1.add(lblloc);

	

	lblcity = new JLabel("City ");

	lblcity.setFont(new Font("Calibri", Font.PLAIN, 20));

	lblcity.setHorizontalAlignment(SwingConstants.RIGHT);

	lblcity.setForeground(Color.white);

	lblcity.setBounds(149, 221, 189, 30);

	panel_1.add(lblcity);

	

	lblstate = new JLabel("State ");

	lblstate.setFont(new Font("Calibri", Font.PLAIN, 20));

	lblstate.setForeground(Color.white);

	lblstate.setHorizontalAlignment(SwingConstants.RIGHT);

	lblstate.setBounds(133, 261, 205, 30);

	panel_1.add(lblstate);

	

	lblfeat = new JLabel("Features ");

	lblfeat.setFont(new Font("Calibri", Font.PLAIN, 20));

	lblfeat.setForeground(Color.white);

	lblfeat.setHorizontalAlignment(SwingConstants.RIGHT);

	lblfeat.setBounds(149, 301, 189, 30);

	panel_1.add(lblfeat);

	

	lbloid = new JLabel("Owner-ID ");

	lbloid.setFont(new Font("Calibri", Font.PLAIN, 20));

	lbloid.setForeground(Color.white);

	lbloid.setHorizontalAlignment(SwingConstants.RIGHT);

	lbloid.setBounds(149, 341, 189, 30);

	panel_1.add(lbloid);

	

	lblaid = new JLabel("Agent-ID ");

	lblaid.setFont(new Font("Calibri", Font.PLAIN, 20));

	lblaid.setForeground(Color.white);

	lblaid.setHorizontalAlignment(SwingConstants.RIGHT);

	lblaid.setBounds(149, 381, 189, 30);

	panel_1.add(lblaid);

	

	lblprice = new JLabel("Price ");

	lblprice.setFont(new Font("Calibri", Font.PLAIN, 20));

	lblprice.setForeground(Color.white);

	lblprice.setHorizontalAlignment(SwingConstants.RIGHT);

	lblprice.setBounds(149, 421, 189, 30);

	panel_1.add(lblprice);

	

	

	add = new JButton("ADD");
	add.setBackground(Color.white);
	add.setFont(new Font("Calibri", Font.PLAIN, 20));
	add.setForeground(new Color(0, 0, 0));
	add.setBounds(319, 490, 85, 38);
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

	String propid;

	boolean flag = false;

	GetConnection getConnection = null;

	try {

	getConnection = new GetConnection();

	} catch (SQLException e2) {

	e2.printStackTrace();

	}

	propid = pid.getText();

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

	String ptype = type.getText();

	String pcat = cat.getText();

	String ploc = loc.getText();

	String pcity = city.getText();

	String pstate = state.getText();

	String pfeat = feat.getText();

	String poid = oid.getText();

	String paid = aid.getText();

	

	int psold = 0;

	int pprice = Integer.parseInt(price.getText());

	Statement st = null;

	try {

	st = getConnection.con.createStatement();

	

	String s = String.format("insert into property values('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d, %d)", propid, ptype,pcat,

	ploc, pcity, pstate, pfeat, poid, paid, pprice, psold );

	st.executeUpdate(s);

	

	JOptionPane.showMessageDialog(this,"Property sucessfully Inserted");

	

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