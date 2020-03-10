package game.competition;

import game.arena.Arena;
import game.arena.ArenaFactory;
import game.entities.sportsman.Skier;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;
import utilities.Point;

public class SkiCompetitionBuilder {

    public SkiCompetition createSkiCompetition(int N){
        ArenaFactory af = new ArenaFactory();
        Arena arena = af.makeArena("Winter");
        SkiCompetition skiCompetition = new SkiCompetition(arena, N, Discipline.SLALOM  , League.ADULT, Gender.MALE);
        Skier skier = new Skier(skiCompetition, new Point(), "Dani", 25, Gender.MALE, 2, 15, Discipline.SLALOM, "Blue");

        for(int i = 0; i < N; i++){
            Skier s = (Skier)skier.clone();
            s.setLocation(new Point(i*110, 0));
            skiCompetition.addCompetitor(s);
        }

        return skiCompetition;
    }
}
