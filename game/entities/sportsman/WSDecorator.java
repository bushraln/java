package game.entities.sportsman;

import game.competition.Competitor;
import utilities.Point;

public abstract class WSDecorator implements Competitor {
    protected IWinterSportsman winterMan;

    public WSDecorator(IWinterSportsman winterMan){
        this.winterMan = winterMan;
    }
    @Override
    public void setTimeFinished(long finishedTime) {
         winterMan.setTimeFinished(finishedTime);
    }

    @Override
    public long getTimeFinished() {
        return winterMan.getTimeFinished();
    }

    @Override
    public void move(double friction) {
        winterMan.move(friction);
    }

    @Override
    public Point getLocation() {
       return winterMan.getLocation();
    }

    @Override
    public void setLocation(Point l) {
        winterMan.setLocation(l);
    }

    @Override
    public double getSpeed() {
        return winterMan.getSpeed();
    }

    @Override
    public void setSpeed(double speed) {
        winterMan.setSpeed(speed);
    }

    @Override
    public double getMaxSpeed() {
        return winterMan.getMaxSpeed();
    }

    @Override
    public double getAcceleration() {
        return winterMan.getAcceleration();
    }

    @Override
    public void run() {
        winterMan.run();
    }

}
