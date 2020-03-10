package game.GUI;

import game.competition.Competition;
import game.competition.Competitor;
import game.entities.sportsman.Skier;
import game.entities.sportsman.Snowboarder;
import game.entities.sportsman.WinterSportsman;
import game.enums.Gender;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import java.util.Map;

/*this is the panel that we see the competitors and the background image*/
public class CompPan extends JPanel {
    private Competition competition;
    private Image image;
    private Map<String,Color>colors;


    public CompPan()
    {
        super();
        setBounds(0,0,900,800);
        colors=new LinkedHashMap<>();
        colors.put("RED",Color.red);
        colors.put("BLUE", Color.BLUE);
        colors.put("GREEN",Color.GREEN);
        colors.put("YELLOW",Color.YELLOW);
        colors.put("BLACK",Color.BLACK);
    }

    public void setCompetition(Competition competition){
        this.competition = competition;
    }

    public void setImage(String fileName){
        //this.setSize(parent.getWidth(), parent.getHeight());
        Image img = null;
        try {
            img = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.image = img;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.removeAll();
        g.drawImage(this.image, 0, 0, getWidth(), getHeight(), this);


        if(competition != null)
            drawCompetitors(g);
    }

    private void drawCompetitors(Graphics g) {
        ArrayList<Competitor> competitors = new ArrayList<Competitor>();
        competitors.addAll(competition.getActiveCompetitors());
        competitors.addAll(competition.getFinishedCompetitors());
        for(Competitor c : competitors){
            String filename = null;
            if(c instanceof Skier){
                if(((Skier) c).getGender() == Gender.MALE){
                    filename = "SkiMale";
                } else{
                    filename = "SkiFemale";
                }
            } else{
                if(((Snowboarder)c).getGender() == Gender.MALE){
                    filename = "SnowboardMale";
                } else{
                    filename = "SnowboardFemale";
                }
            }


            Image img = null;
            try {
                img = ImageIO.read(new File("./icons/"+filename+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //System.out.println("name"+c.toString()+"location"+c.getLocation());
            g.drawImage(img, (int)Math.round(c.getLocation().getX()), (int)Math.round(c.getLocation().getY()), 50, 50, this);
            g.setColor(colors.get(((WinterSportsman) c).getColor()));
            g.drawRect((int)Math.round(c.getLocation().getX()), (int)Math.round(c.getLocation().getY()), 50, 50);
        }
    }


    public Competition getCompetition(){
        return competition;
    }
}
