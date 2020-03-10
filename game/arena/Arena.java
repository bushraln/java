package game.arena;

import game.entities.IMobileEntity;
import game.enums.SnowSurface;
import game.enums.WeatherCondition;

public abstract class Arena implements  IArena{

    private double length;
    private SnowSurface surface;
    private WeatherCondition condition;

    public Arena(double length, SnowSurface surface, WeatherCondition condition) {
        this.setLength(length);
        this.setSurface(surface);
        this.setCondition(condition);
    }

    public double getFriction() {

        return surface.getFriction();
    }

    public boolean isFinished(IMobileEntity me) {
        return me.getLocation().getY()>=this.length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length < 700 || length>900) {
            throw new IllegalArgumentException("length must be positive");
        } else {
            this.length = length;
        }
    }

    public SnowSurface getSurface() {
        return surface;
    }

    public void setSurface(SnowSurface surface) {

        if(surface==null)
        {
            throw new IllegalArgumentException("surface cant be null");
        }
        this.surface = surface;
    }

    public WeatherCondition getCondition() {

        return condition;
    }

    public void setCondition(WeatherCondition condition) {
        if(condition==null)
        {
            throw new IllegalArgumentException("condition cant be null");
        }
        this.condition = condition;
    }
}
