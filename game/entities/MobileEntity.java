package game.entities;

import utilities.Point;
/**
 * this class is of all moving entity in the program
 * its not an abstract class because thre is an option of a moving entity that is not a sportsman.
 * this class implements Imobileentity
 *
 */


public abstract class MobileEntity extends Entity implements IMobileEntity {
    private double maxSpeed;
    private double acceleration;
    private double speed;

    public MobileEntity(Point location, double maxSpeed,double acceleration)
    {
        super(location);
        setMaxSpeed(maxSpeed);
        setAcceleration(acceleration);
        setSpeed(0);
    }


    public void move(double friction)
    {

        if(this.speed<this.maxSpeed) {
            this.setSpeed(this.speed + (1 - friction) * (this.acceleration));
        }
        if(this.speed > maxSpeed)
            this.speed = maxSpeed;

        Point location2=new Point(this.getLocation().getX(), this.getLocation().getY()+this.getSpeed());

        this.setLocation(location2);


    }


    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
