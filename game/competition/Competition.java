
package game.competition;

import game.GUI.CompPan;
import game.arena.IArena;
import game.entities.sportsman.Skier;
import game.entities.sportsman.Snowboarder;
import game.entities.sportsman.WinterSportsman;
import game.entities.states.StateInterface;

import java.util.ArrayList;

public abstract class Competition {
    protected StateInterface stateInterface;
    private IArena arena;
    private int maxCompetitors;
    private ArrayList<Competitor>activeCompetitors;
    private ArrayList<Competitor>finishedCompetitors;
    protected long startTime;

    private CompPan compPanel;

    public Competition(IArena arena, int maxCompetitors) {
        this.setArena(arena);
        this.setMaxCompetitors(maxCompetitors);
        this.finishedCompetitors=new ArrayList<>();
        this.activeCompetitors=new ArrayList<>();
    }

    public void setStartTime(long startTime){
        this.startTime = startTime;
    }
    public void addCompetitor(Competitor competitor){
    if(this.activeCompetitors.size()==maxCompetitors)
        throw new IllegalStateException("Competition is full");

    if(isValidCompetitor(competitor) == false) {
        if (competitor instanceof Skier)
            throw new IllegalArgumentException("Not valid competitor " + (Skier) competitor);
        else{
            throw new IllegalArgumentException("Not valid competitor " + (Snowboarder) competitor);
        }
    }

        //competitor.initRace();
        this.activeCompetitors.add(competitor);

    }

    public void updateMove(){
        this.compPanel.repaint();
        this.compPanel.revalidate();
    }

    public void startCompetitors(){
        for(Competitor c : activeCompetitors){
            Thread t = new Thread(c);
            t.start();
        }
    }

    public void setCompPanel(CompPan compPanel){
        this.compPanel = compPanel;
    }
/*
this func copy the array of the active competitors and make a move with evrey one in the list
if one of the is finish he move to an array of finish competitors and he is deleted from active array
 */
//    public void playTurn(){
//        ArrayList<Competitor> temp = new ArrayList<>(this.activeCompetitors);
//
//        for(Competitor c : temp){
//            c.move(arena.getFriction());
//            if(arena.isFinished(c) == true){
//                this.finishedCompetitors.add(c);
//                this.activeCompetitors.remove(c);
//            }
//        }
//
//    }

    public boolean hasActiveCompetitors(){
        if(this.activeCompetitors.size() > 0)
            return true;
        else
            return false;
    }
/*
abstract method that will be implemented in skicompetition and snowboard competition
 */
    public abstract boolean isValidCompetitor(Competitor competitor);

    public IArena getArena() {
        return arena;
    }

    public void setArena(IArena arena) {
        if(arena==null)
        {
            throw new IllegalArgumentException("arena cant be null");
        }
        this.arena = arena;
    }

    public int getMaxCompetitors() {
        return maxCompetitors;
    }

    public void setMaxCompetitors(int maxCompetitors) {
        if(maxCompetitors<1)
        {
            throw new IllegalArgumentException("max competitors must be positive");
        }
        this.maxCompetitors = maxCompetitors;
    }

    public ArrayList<Competitor> getActiveCompetitors() {
        return activeCompetitors;
    }

    public void setActiveCompetitors(ArrayList<Competitor> activeCompetitors) {
        this.activeCompetitors = new ArrayList<>(activeCompetitors);
    }

    public ArrayList<Competitor> getFinishedCompetitors() {
        return finishedCompetitors;
    }

    public void setFinishedCompetitors(ArrayList<Competitor> finishedCompetitors) {
        this.finishedCompetitors = new ArrayList<>(finishedCompetitors);
    }

    public void updateFinished(WinterSportsman c) {
        this.finishedCompetitors.add(c);
        this.activeCompetitors.remove(c);
        long finishedTime = System.currentTimeMillis() - startTime;
        c.setTimeFinished(finishedTime);
    }

    public long getStartTime() {
        return this.startTime;
    }
    public void infoState(StateInterface stateInterface)
    {
        this.stateInterface=stateInterface;
        stateInterface.infoState();

    }
}
