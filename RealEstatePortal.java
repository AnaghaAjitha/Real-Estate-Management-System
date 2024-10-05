package RealEstate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RealEstatePortal extends JFrame implements ActionListener {
    JLabel lblNewLabel;

    RealEstatePortal() {
        this.getContentPane().setBackground(new Color(0, 0, 0));
        this.getContentPane().setLayout(new BorderLayout());

        lblNewLabel = new JLabel("Welcome to Real Estate Portal");
        lblNewLabel.setForeground(Color.white);
        lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 56));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding
        this.getContentPane().add(lblNewLabel, BorderLayout.CENTER);


        // Create sidebar panel
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setBackground(Color.white); // Different background color
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS)); // Vertical arrangement

        // Create buttons with the same background color as the panel
        JButton btnNewButton_1 = createButton("Log In As Guest", sidebarPanel.getBackground());
        btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 20));
        JButton btnNewButton_2 = createButton("Log In As Agent", sidebarPanel.getBackground());
        btnNewButton_2.setFont(new Font("Calibri", Font.BOLD, 20));
        JButton btnNewButton_3 = createButton("Real Estate Office", sidebarPanel.getBackground());
        btnNewButton_3.setFont(new Font("Calibri", Font.BOLD, 20));
        JButton btnNewButton_4 = createButton("Log In As Owner", sidebarPanel.getBackground());
        btnNewButton_4.setFont(new Font("Calibri", Font.BOLD, 20));

        // Add action listeners to buttons
        btnNewButton_1.addActionListener(this);
        btnNewButton_2.addActionListener(this);
        btnNewButton_3.addActionListener(this);
        btnNewButton_4.addActionListener(this);

        // Add buttons to sidebar panel with vertical glue for centering
        sidebarPanel.add(Box.createVerticalGlue());
        sidebarPanel.add(btnNewButton_1);
        sidebarPanel.add(btnNewButton_2);
        sidebarPanel.add(btnNewButton_3);
        sidebarPanel.add(btnNewButton_4);
        sidebarPanel.add(Box.createVerticalGlue());

        // Add sidebar panel to the west of the content pane
        this.getContentPane().add(sidebarPanel, BorderLayout.WEST);

        this.setBounds(155, 100, 819, 535);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);

        // Set preferred size after the frame is visible
        sidebarPanel.setPreferredSize(new Dimension(this.getWidth() / 3, this.getHeight()));
    }

    private JButton createButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setBackground(Color.white);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding to buttons
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Log In As Guest")) {
            dispose();
            new GuestInterfaceLogIn().setVisible(true);
        } else if (command.equals("Log In As Agent")) {
            dispose();
            new AgentLogInFrame().setVisible(true);
        } else if (command.equals("Real Estate Office")) {
            dispose();
            new RealEstateOfficeFrame().setVisible(true);
        } else if (command.equals("Log In As Owner")) {
            dispose();
            new OwnerLogInFrame().setVisible(true);
        }
    }

}