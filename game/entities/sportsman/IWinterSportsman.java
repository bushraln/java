package game.entities.sportsman;

import game.competition.Competitor;
import game.entities.states.StateInterface;

public interface IWinterSportsman extends Competitor {
    public void setColor(String color);

    public void setAcceleration(double acceleration);

    public double getAcceleration();

    public String getName();

    public StateInterface getState();

    public void setTimeFinished(long finishedTime);

    public long getTimeFinished();

}
