package game.entities.states;

import game.competition.Competition;
import game.competition.Competitor;
/*
this is defult state, from this class you will activate the right state
 */
public class CompetitorState implements StateInterface {
    protected Competitor competitor;
    public StateInterface currentState;
    public Active active;
    public Injured injured;
    public Completed completed;
    public Disabled disabled;
    public Competition competition;
    public CompetitorState(){
        this.competitor = competitor;

        this.active = new Active(this);
        this.injured = new Injured(this);
        this.completed = new Completed(this);
        this.disabled = new Disabled(this);
        this.currentState=active;

    }

    public void setCompetitor(Competitor competitor)
    {
        this.competitor=competitor;

    }

    //public CompetitorState(Competitor competitor){
      //  this.competitor = competitor;
    //}

   public void move(double friction){
        currentState.move(friction);
   }
    public void setState(StateInterface state)
    {
        currentState=state;
    }

    public StateInterface getCurrentState() {
        return currentState;
    }

    public Active getActive() {
        return active;
    }

    public Injured getInjured() {
        return injured;
    }

    public Completed getCompleted() {
        return completed;
    }

    public Disabled getDisabled() {
        return disabled;
    }
    public String toString()
    {
       return currentState.toString();
    }

    public void setCompetition(Competition competition)
    {
        this.competition = competition;
    }
    public void updateState()
    {
        currentState.updateState();
    }

    @Override
    public void infoState() {
        currentState.infoState();
    }

    @Override
    public String getAdditionalInfo() {
        return  currentState.getAdditionalInfo();
    }

    @Override
    public boolean isDisabled() {
        return currentState.isDisabled();
    }
}
