package game.enums;

/**
 * Created by itzhak on 09-Mar-19.
 */
public enum SummerSurface {
    POWDER(0.7),
    CRUD(0.5),
    SAND(0.3);

    public final double friction;

    SummerSurface(double friction){
        this.friction = friction;
    }

    public double getFriction(){
        return friction;
    }
}
