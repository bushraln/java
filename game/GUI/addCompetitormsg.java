package game.GUI;

import javax.swing.*;

public class addCompetitormsg extends JFrame {
    private JPanel panel;
    private JButton button;
    private JLabel label;
    public addCompetitormsg()
    {
        super("message");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(700, 200);
        panel = new JPanel();
        button=new JButton("OK");
        label=new JLabel("competitor does not fit competition! choose another competitor");
        panel.setLayout(new BoxLayout(panel,1));
        panel.add(label);
        panel.add(button);
        add(panel);
    }
}
