package game.arena;

public class ArenaFactory {
    public Arena makeArena(String type)
    {
        Arena arena = null;
        if(type.equals("Winter"))
        {
            arena=new WinterArena();
        }
        else if(type.equals("Summer"))
        {
            arena=new SummerArena();
        }
        return arena;

    }
}
