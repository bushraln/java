package game.competition;

import game.entities.IMobileEntity;

public interface Competitor extends IMobileEntity {
   //public void initRace();

    public void setTimeFinished(long finishedTime);

    public long getTimeFinished();
}
