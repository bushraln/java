package game.entities.sportsman;

public class ColoredSportsman extends WSDecorator {

    public ColoredSportsman(IWinterSportsman winterMan, String color){
        super(winterMan);
        this.winterMan.setColor(color);
    }

}
