package RealEstate;
import javax.swing.JFrame;



import javax.swing.JButton;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import java.awt.Color;

import javax.swing.SwingConstants;

import javax.swing.JTable;

import javax.swing.JLabel;

import javax.swing.JMenu;

import javax.swing.JMenuBar;

import javax.swing.*;

import java.awt.Font;

import javax.swing.JScrollPane;

  

class JTableClass implements ActionListener{

    // frame

    JFrame f;

    // Table

    JTable j;

    JMenuBar mb;

    JMenu x;

  

    // Constructor

    JTableClass(String[][] data, String[] columnNames, String title)

    {

        // Frame initialization

        f = new JFrame();

  

        // Frame Title

        f.setTitle(title);

  

        // Initializing the JTable

        j = new JTable(data, columnNames);

        j.setBounds(0, 0, 1000, 1000);

  

        // adding it to JScrollPane

        JScrollPane sp = new JScrollPane(j);

        f.add(sp);

        // Frame Size

        



        // create a menu bar

        mb = new JMenuBar();

  

        // create a menu

        x = new JMenu("Back");

        

        x.addActionListener(this);



  

        // add menu to menu bar

        mb.add(x);

  

        // add menu bar to frame

        f.setJMenuBar(mb);

        

        f.setBounds(100, 100, 819, 535);

        // Frame Visible = true

        

        f.setVisible(true);

    }



	@Override

	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub

		if(e.getSource() == x)

		{

			f.dispose();

		}

		

	}

}



public class RealEstateOfficeFrame extends JFrame implements ActionListener{

		JButton insertProp;

		JButton insertAgent;

		JButton insertOwner;

		JButton back;

		RealEstateOfficeFrame()

		{

			setExtendedState(MAXIMIZED_BOTH);

			

			this.getContentPane().setForeground(new Color(64, 224, 208));

			this.getContentPane().setBackground(Color.black);

			this.getContentPane().setLayout(null);

			//this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\abhinandan\\OneDrive\\Desktop\\Dbsms_project\\background6.png")));

			

			

			JLabel lblNewLabel = new JLabel("Welcome to Real Estate Office");

			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

			lblNewLabel.setForeground(Color.white);

			lblNewLabel.setBackground(Color.white);

			lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 40));

			lblNewLabel.setBounds(390, 44, 805 , 50);

			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

			this.getContentPane().add(lblNewLabel);

		

			

			insertProp = new JButton("Add Property");

			insertProp.setBackground(Color.white);

			insertProp.setFont(new Font("Calibri", Font.BOLD, 24));

			insertProp.setBounds(630, 330, 273, 141);

			this.getContentPane().add(insertProp);

			

			insertProp.addActionListener(this);

			

			insertAgent = new JButton("Add Agent");

			insertAgent.setBackground(Color.white);

			insertAgent.setFont(new Font("Calibri", Font.BOLD, 24));

			insertAgent.setBounds(305, 330, 273, 141);

			this.getContentPane().add(insertAgent);

			

			insertAgent.addActionListener(this);

			

			insertOwner = new JButton("Add Owner");

			insertOwner.setBackground(Color.white);

			insertOwner.setFont(new Font("Calibri", Font.BOLD, 24));

			insertOwner.setBounds(955, 330, 273, 141);

			this.getContentPane().add(insertOwner);

			

			insertOwner.addActionListener(this);

			

			back = new JButton("Back");

			back.setFont(new Font("Calibri", Font.ITALIC, 12));

			back.setForeground(Color.WHITE);

			back.setBackground(Color.BLACK);

			back.setBounds(0, 0, 76, 31);

			

			back.addActionListener(this);

			

			this.getContentPane().add(back);

			this.setBounds(100, 100, 819, 535);

			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			

			this.setResizable(false);

			this.setVisible(true);

		}



		@Override

		public void actionPerformed(ActionEvent e) {

			// TODO Auto-generated method stub

			

			if(e.getSource() == insertProp)

			{

				this.dispose();

				new InsertProp();

			}

			

			if(e.getSource() == insertAgent)

			{

				this.dispose();

				new InsertAgent();

			}

			

			if(e.getSource() == insertOwner)

			{

				this.dispose();

				new InsertOwner();

			}

			

			if(e.getSource() == back)

			{

				this.dispose();

				new RealEstatePortal();

			}

			

		}







}