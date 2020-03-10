package game.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class JPanelWithBackground extends JPanel {

    private Image img;

    // Some code to initialize the background image.
    // Here, we use the constructor to load the image. This
    // can vary depending on the use case of the panel.
    public JPanelWithBackground(JPanel parent, String fileName) throws IOException {
        this.setSize(parent.getWidth(), parent.getHeight());
        img = ImageIO.read(new File(fileName));

        Dimension size = parent.getSize();
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image.
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}

