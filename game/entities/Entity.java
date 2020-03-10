package game.entities;

import utilities.Point;
/**
 * this class is abstract, of an entity in the program. its only filed is location
 */

public abstract class Entity  {
    private Point location;

    public Entity()
    {
        setLocation(new Point(0,0));
    }
    public Entity(Point location) {
        if(location == null)
            throw new IllegalArgumentException("location cant be null");
        setLocation(location);
    }

    public Point getLocation() {
        return location;
    }

    public  void setLocation(Point location)
    {
        this.location=new Point(location);
    }
}
