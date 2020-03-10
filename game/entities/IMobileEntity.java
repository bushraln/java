package game.entities;

import utilities.Point;

public interface IMobileEntity extends Runnable {
    public void move(double friction);
    public Point getLocation();
    public void setLocation(Point l);
    public double getSpeed();
    public void setSpeed(double speed);
    public double getMaxSpeed();
    public double getAcceleration();
}
