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


public class AgentLogInFrame extends JFrame implements ActionListener{
    JTextField txtEnterAgentidHere;

    JButton back;
    JButton logIn;
    JLabel lblNewLabel;
    AgentLogInFrame()
    {

        this.getContentPane().setForeground(Color.white);
        this.getContentPane().setBackground(Color.black);
        this.getContentPane().setLayout(null);
        //this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\abhinandan\\OneDrive\\Desktop\\Dbsms_project\\background6.png")));


        lblNewLabel = new JLabel("Welcome Agent");
        lblNewLabel.setForeground(Color.white);
        lblNewLabel.setBackground(new Color(30, 144, 255));
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 35));
        lblNewLabel.setBounds(0, 40, 805 , 50);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.getContentPane().add(lblNewLabel);

        logIn = new JButton("LogIn");

        logIn.setForeground(Color.black);
        logIn.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
        logIn.setBackground(Color.white);
        logIn.setBounds(316, 398, 180, 66);
        this.getContentPane().add(logIn);

        logIn.addActionListener(this);

        txtEnterAgentidHere = new JTextField("Enter Agent ID");
        txtEnterAgentidHere.setHorizontalAlignment(SwingConstants.CENTER);
        txtEnterAgentidHere.setBackground(Color.WHITE);
        txtEnterAgentidHere.setFont(new Font("Calibri", Font.ITALIC, 26));
        txtEnterAgentidHere.setBounds(204, 166, 394, 56);
        this.getContentPane().add(txtEnterAgentidHere);
        txtEnterAgentidHere.setColumns(10);


        back = new JButton("Back");
        back.setFont(new Font("Calibri", Font.ITALIC, 12));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.black);
        back.setBounds(0, 0, 79, 33);
        this.getContentPane().add(back);
        this.setBounds(100, 100, 819, 535);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        back.addActionListener(this);

        // Maximize the window
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);

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

            id = txtEnterAgentidHere.getText();
            String name = null;
            try {
                GetConnection getConnection = new GetConnection();
                Statement st = getConnection.con.createStatement();
                ResultSet resultSet;



                resultSet = st.executeQuery("select agent_id, aname from agent");

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
                AgentFrameAfterLogIn addText = new AgentFrameAfterLogIn(id);
                //UpdateTransactionTable obj=new UpdateTransactionTable(id);
                addText.lblNewLabel.setText("Welcome " + name);;
            }
            else
                JOptionPane.showMessageDialog(this,"Invalid Agent-Id");

        }

    }

    private String getString(int i) {
        // TODO Auto-generated method stub
        return null;
    }

}