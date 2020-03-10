package game.GUI;

import javax.swing.*;

public class FrameMessage extends JFrame {
    private JPanel panel;
    private JLabel label;
    private JButton button;
    public FrameMessage() {
        super("Message");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600, 200);
        panel = new JPanel();
        button=new JButton("OK");
        label=new JLabel("Please Build Arena, Create Competition and add comprtitors");
        panel.setLayout(new BoxLayout(panel,1));
        panel.add(label);
        panel.add(button);
        add(panel);
    }
}
