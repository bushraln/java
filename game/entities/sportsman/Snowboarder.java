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
public class Snowboarder extends WinterSportsman {
        public Snowboarder(Competition comp, Point location, String name, double age, Gender gender, double acceleration, double maxSpeed, Discipline d, String color) {
            super(comp, location, acceleration,  maxSpeed,  name,  age,  gender,  d, color);
        }

    public Snowboarder clone(){
        Snowboarder snowClone = null;
        try {
            snowClone =(Snowboarder)super.clone();
            StateInterface competitorState = new CompetitorState();
            snowClone.setState(competitorState);
            competitorState.setCompetition(this.comp);
            competitorState.setCompetitor(snowClone);
            competitorState.setCompetitor(snowClone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return snowClone ;
    }
    public String toString() {
        return "Snowboarder "+this.getName();
    }
    }

