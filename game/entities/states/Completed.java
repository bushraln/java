package game.entities.states;

import game.competition.Competition;
import game.competition.Competitor;

public class Completed implements StateInterface {
    private CompetitorState competitorState;
    public Completed(CompetitorState competitorState1){
        //super(competitor);
        this.competitorState=competitorState1;

    }

    @Override
    public void move(double friction) {

    }
    public void setCompetition(Competition competition)
    {
        this.competitorState.setCompetition(competition);
    }

    @Override
    public void updateState() {

    }

    @Override
    public void infoState() {

    }

    @Override
    public String getAdditionalInfo() {
        return competitorState.competitor.getTimeFinished()+"";
    }

    @Override
    public boolean isDisabled() {
        return false;
    }

    public String toString() {
        return "completed";
    }

    @Override
    public void setCompetitor(Competitor competitor) {

    }

}
