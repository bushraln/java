package game.arena;

import game.enums.SnowSurface;
import game.enums.WeatherCondition;

public class SummerArena extends Arena {
    //private SummerSurface surface;

    public SummerArena(double length, SnowSurface surface, WeatherCondition condition) {
        super(length, surface, condition);
    }

    public SummerArena(){
        super(700, SnowSurface.POWDER, WeatherCondition.SUNNY);
    }
}
