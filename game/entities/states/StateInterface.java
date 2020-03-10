package game.entities.states;

import game.competition.Competition;
import game.competition.Competitor;

public interface StateInterface {
    public void move(double friction);
    public String toString();
    public void setCompetitor(Competitor competitor);
    public void setCompetition(Competition competition);
    public void updateState();
    public void infoState();
    public String getAdditionalInfo();

    public boolean isDisabled();
}
