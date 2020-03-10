package game.competition;

import game.arena.IArena;
import game.entities.sportsman.Skier;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;

public class SkiCompetition extends WinterCompetition {

    public SkiCompetition(IArena arena, int maxCompetitors, Discipline discipline, League league, Gender gender)
    {
        super(arena,  maxCompetitors,  discipline,  league,  gender);
    }

    @Override
    public boolean isValidCompetitor(Competitor competitor) {
        if(competitor instanceof Skier)
        {
            if(((Skier) competitor).getDiscipline()==this.getDiscipline() &&((Skier) competitor).getGender()==this.getGender()&&checkAge(competitor)==true)
            {
                return true;
            }

        }
        return false;
    }
    public boolean checkAge(Competitor competitor)
    {
        if(league.isInLeague(((Skier)competitor).getAge())==true)
        {
            return true;
        }
        return false;
    }
}
