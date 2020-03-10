package game.GUI;

import javax.swing.*;

public class buildArenaFrame extends JFrame {
    private JPanel panel;
    private JLabel label;
    private JButton button;
    public buildArenaFrame()
    {
        super("Message");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400,200);
        panel=new JPanel();
        setBounds(200,200,300,100);
        button=new JButton("OK");
        label=new JLabel("invalid input values! please try again");
        panel.setLayout(new BoxLayout(panel,1));
        panel.add(label);
        panel.add(button);
        add(panel);


    }

}
