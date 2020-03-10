package game.entities.states;

import game.competition.Competition;
import game.competition.Competitor;

import javax.swing.*;

public class Disabled implements StateInterface {
    public int isDisable=0;
    private CompetitorState competitorState;
    public Disabled(CompetitorState competitorState1){
        //super(competitor);
        this.competitorState=competitorState1;

    }
    public void move(double friction)
    {
        //isDisable=true;
    }
    public String toString() {
        return "disabled";
    }

    @Override
    public void setCompetitor(Competitor competitor) {

    }
    public void setCompetition(Competition competition)
    {
        this.competitorState.setCompetition(competition);
    }
    public void updateState()
    {

    }
    @Override
    public String getAdditionalInfo() {
        return "FAILED";
    }

    @Override
    public boolean isDisabled() {
        if (isDisable == 0) {
            isDisable++;
            return false;

        }
        return true;
    }
    @Override
    public void infoState() {
        JOptionPane.showMessageDialog(null, "player"+competitorState.competitor.toString()+" disable");

    }
}
