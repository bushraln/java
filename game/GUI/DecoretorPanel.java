package game.GUI;

import game.competition.Competition;
import game.competition.Competitor;
import game.entities.sportsman.ColoredSportsman;
import game.entities.sportsman.SpeedySportsman;
import game.entities.sportsman.WinterSportsman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecoretorPanel extends JPanel {
    private Competition competition;

    public DecoretorPanel(CompPan compPan) {
        super();
        setLayout(new GridLayout(4, 2));
        competition = compPan.getCompetition();
        JButton changeColorbutton = new JButton("change color");
        JButton accelerationbutton = new JButton("add acceleration");
        JComboBox competitorColorBox = new JComboBox();
        JComboBox competitorSpeedybox = new JComboBox();

        JLabel addaccelerationlable = new JLabel("add acceleration");
        JLabel colorlable = new JLabel("change color");

        String[] colors = {"RED", "BLUE", "GREEN", "YELLOW", "BLACK"};
        JComboBox colorBox = new JComboBox(colors);

        JTextField addaccelerationtext = new JTextField();


        competitorColorBox.setModel(new DefaultComboBoxModel(competition.getActiveCompetitors().toArray()));
        competitorSpeedybox.setModel(new DefaultComboBoxModel(competition.getActiveCompetitors().toArray()));

        add(competitorColorBox);
        add(competitorSpeedybox);
        add(colorlable);
        add(addaccelerationlable);
        add(colorBox);
        add(addaccelerationtext);
        add(changeColorbutton);
        add(accelerationbutton);


        accelerationbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WinterSportsman winterSportsman = (WinterSportsman) competitorSpeedybox.getSelectedItem();
                String acceleration = addaccelerationtext.getText();
                double accelerationnum = Double.parseDouble(acceleration);
                SpeedySportsman speedySportsman = new SpeedySportsman(winterSportsman, accelerationnum);

                for (Competitor c : competition.getActiveCompetitors()) {
                    if (c == winterSportsman) {
                        c = speedySportsman;
                        System.out.println(c.toString() + "acceleration= " + c.getAcceleration());
                        compPan.repaint();
                        compPan.revalidate();
                    }


                }


            }
        });
        changeColorbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                WinterSportsman winterSportsman = (WinterSportsman) competitorColorBox.getSelectedItem();
                String color = (String) colorBox.getSelectedItem();
                ColoredSportsman coloredSportsman = new ColoredSportsman(winterSportsman, color);
                for (Competitor c : competition.getActiveCompetitors()) {
                    if (c == winterSportsman) {
                        c = coloredSportsman;
                        System.out.println(c.toString() + "color= ");
                        compPan.repaint();
                        compPan.revalidate();
                    }


                }


            }
        });

    }
}


