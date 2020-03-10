package game.entities.states;

import game.competition.Competition;
import game.competition.Competitor;

import javax.swing.*;

public class Injured implements StateInterface {
    private CompetitorState competitorState;
    public Injured(CompetitorState competitorState1){
        //super(competitor);
        this.competitorState=competitorState1;

    }

    @Override
    public void setCompetitor(Competitor competitor) {

    }
    public void setCompetition(Competition competition)
    {
        this.competitorState.setCompetition(competition);
    }

    public void move(double friction)
    {
        double random=Math.random();
        if(random>0.1)
        {
            competitorState.setState(this.competitorState.getActive());

        }
        else if(random<=0.1 && random >0.09999)
        {
            //JOptionPane.showMessageDialog(null, "player"+competitorState.competitor.toString()+" DIsable");

            competitorState.setState(this.competitorState.getDisabled());

        }
    }
    public String toString() {
        return "injured";
    }
    public void updateState()
    {

    }

    @Override
    public void infoState() {
        JOptionPane.showMessageDialog(null, "player"+competitorState.competitor.toString()+" injurd");

    }

    @Override
    public String getAdditionalInfo() {
        return null;
    }

    @Override
    public boolean isDisabled() {
        return false;
    }
}
