package game.entities.sportsman;

import game.competition.Competition;
import game.entities.states.CompetitorState;
import game.entities.states.StateInterface;
import game.enums.Discipline;
import game.enums.Gender;
import utilities.Point;

/**
 * class of a regular class that extend wintersportsman
 * uses all the above classes constructor
 */
public class Skier extends WinterSportsman {
    public Skier(Competition comp, Point location, String name, double age, Gender gender, double acceleration, double maxSpeed, Discipline d, String color) {
        super(comp, location, acceleration,  maxSpeed,  name,  age,  gender,  d, color);
    }

    public Skier clone(){
        Skier skierClone = null;
        try {
            skierClone =(Skier)super.clone();
            StateInterface competitorState = new CompetitorState();
            skierClone.setState(competitorState);
            competitorState.setCompetition(this.comp);
            competitorState.setCompetitor(skierClone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return skierClone ;
    }
    @Override
    public String toString() {
        return "Skier "+this.getName();
    }
}
