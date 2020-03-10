package game.entities.sportsman;

public class SpeedySportsman extends WSDecorator {

    public SpeedySportsman(IWinterSportsman winterMan, double accelaration){
        super(winterMan);
        this.winterMan.setAcceleration(winterMan.getAcceleration()+accelaration);
    }

    public String toString()
    {
        return "speedy "+winterMan.getName();
    }
}
