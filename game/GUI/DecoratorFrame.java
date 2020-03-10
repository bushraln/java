package game.GUI;

import javax.swing.*;
import java.awt.*;

public class DecoratorFrame extends JFrame {
    public DecoratorFrame(CompPan compPan)
    {
        super("competition");

        setSize(new Dimension(100, 200));
        setBounds(500, 100, 250, 200);

        DecoretorPanel decoretorPanel=new DecoretorPanel(compPan);
        add(decoretorPanel);
        setVisible(true);



    }
}
