package game.GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public CompPan compPan;
    public MenuPanel menuPanel;
    public MainFrame()
    {
        super("competition");

        setSize(new Dimension(1100,800));

        setLayout(new BorderLayout());
        compPan=new CompPan();
        //compPan.setBackground(new Color(0));
        menuPanel=new MenuPanel(compPan,this);
        //menuPanel.setBackground(new Color(255));
        add(compPan, BorderLayout.CENTER);
        add(menuPanel,BorderLayout.EAST);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }


}
