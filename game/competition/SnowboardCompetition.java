package game.competition;

import game.arena.IArena;
import game.entities.sportsman.Snowboarder;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;

public class SnowboardCompetition extends WinterCompetition {

    public SnowboardCompetition(IArena arena, int maxCompetitors, Discipline discipline, League league, Gender gender)
    {
        super(arena,  maxCompetitors,  discipline,  league,  gender);
    }

    @Override
    public boolean isValidCompetitor(Competitor competitor) {
        if(competitor instanceof Snowboarder)
        {
            if(((Snowboarder) competitor).getDiscipline()==this.getDiscipline() &&((Snowboarder) competitor).getGender()==this.getGender()&&checkAge(competitor)==true)
            {
                return true;
            }

        }
        return false;
    }
    public boolean checkAge(Competitor competitor)
    {
        if(league.isInLeague(((Snowboarder)competitor).getAge())==true)
        {
            return true;
        }
        return false;
    }
}
