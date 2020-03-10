package game.entities.states;

import game.competition.Competition;
import game.competition.Competitor;
import utilities.Point;

public class Active implements StateInterface {
    public CompetitorState competitorState;
/*
this is active state. the only state that moves.
 */
    public Active(CompetitorState competitorState1){
        //super(competitor);
        competitorState=competitorState1;


    }
    public void setCompetitor(Competitor competitor)
    {
        this.competitorState.setCompetitor(competitor);
    }
    public void setCompetition(Competition competition)
    {
        this.competitorState.setCompetition(competition);
    }
/*
to get to all the relevant fields you need to pass competition and competitor
 */

    public void move(double friction)
    {
        double random=Math.random();
        /*
        random will decide if a state wiil change and tp what state.
         */
        if(random<=0.02)
        {
            long timeInjured = System.currentTimeMillis() - competitorState.competition.getStartTime();
            //JOptionPane.showMessageDialog(null, "player"+competitorState.competitor.toString()+" injurd at " + timeInjured + " ms from start time");

            competitorState.setState(competitorState.getInjured());
        }
        else if(random>0.02 &&random<0.03)
        {
            //JOptionPane.showMessageDialog(null, "player"+competitorState.competitor.toString()+" DIsable");

            competitorState.setState(competitorState.getDisabled());
        }
        else {
            double speed = this.competitorState.competitor.getSpeed();
            double maxSpeed = this.competitorState.competitor.getMaxSpeed();
            if (speed < maxSpeed) {
                this.competitorState.competitor.setSpeed(speed + (1 - friction) * (this.competitorState.competitor.getAcceleration()));
            }
            if (speed > maxSpeed)
                this.competitorState.competitor.setSpeed(maxSpeed);

            Point location2 = new Point(this.competitorState.competitor.getLocation().getX(), this.competitorState.competitor.getLocation().getY() + speed);
            if(location2.getY()>this.competitorState.competition.getArena().getLength())
            {
                location2=new Point(this.competitorState.competitor.getLocation().getX(),this.competitorState.competition.getArena().getLength());
            }
            this.competitorState.competitor.setLocation(location2);


        }
    }
    public void updateState()
    {
        if(competitorState.competition.getArena().isFinished(competitorState.competitor)==true)
        {
            competitorState.setState(competitorState.getCompleted());
        }
    }

    @Override
    public void infoState() {
    }

    @Override
    public String getAdditionalInfo() {
        return "RANK";
    }

    @Override
    public boolean isDisabled() {
        return false;
    }

    @Override
    public String toString() {
        return "active";
    }
}
