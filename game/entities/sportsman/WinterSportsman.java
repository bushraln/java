package game.entities.sportsman;

import game.competition.Competition;
import game.entities.states.*;
import game.enums.Discipline;
import game.enums.Gender;
import utilities.Point;

public abstract class WinterSportsman extends Sportsman implements IWinterSportsman {
    private boolean isDisabled=false;
    private Discipline discipline;
    protected Competition comp;
    private StateInterface state;
    protected long timeFinished;

    public WinterSportsman(Competition comp, Point location, double acceleration, double maxSpeed , String name, double age, Gender gender, Discipline discipline, String color)
    {
        super( location,  maxSpeed,  acceleration,  name,  age,  gender, color);
        this.setDiscipline(discipline);
        this.comp = comp;
        //this.state = new Active(this);
        this.state=new CompetitorState() ;
        state.setCompetitor(this);
        state.setCompetition(this.comp);
//        double random=Math.random();
//        System.out.println(random);
//        if(random < 0.2){
//            System.out.println("inj");
//            goingToBeInjured = true;
//            distnaceToBeInjured = Math.random()*comp.getArena().getLength();
//            System.out.println("distance to be inj"+distnaceToBeInjured);
//        } else{
//            goingToBeInjured = false;
//        }
//        if(random>0.2&&random<0.5)
//        {
//            disabled=true;
//            distnaceToBedisabled=Math.random()*comp.getArena().getLength();
//
//        }

    }

    public void setState(StateInterface state){
        this.state = state;
    }

    public void run(){
        while(comp.getArena().isFinished(this) == false){
            //System.out.println("run");
            playTurn();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void playTurn(){
        //System.out.println("run1");
        this.state.move(comp.getArena().getFriction());
        comp.updateMove();
        if(state.isDisabled()==false) {
            comp.infoState(state);
        }

        /*
        if(goingToBeInjured == true){
            if(this.getLocation().getY() >= distnaceToBeInjured){
                this.state = new Injured(this);

            }
        }

        if(disabled == true){
            if(this.getLocation().getY() >= distnaceToBedisabled){
                this.state = new Disabled(this);

            }
        }
        */
        if(comp.getArena().isFinished(this) == true) {
           // this.state = new Completed(state);
            state.updateState();
            comp.updateFinished(this);
        }
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        if(discipline==null)
        {
            throw new IllegalArgumentException("discipline cant be null");
        }
        this.discipline = discipline;
    }
    public void initRace()
    {
        this.setLocation(new Point(0,0));
    }
    public String getName()
    {
        return super.getName();
    }
    public StateInterface getState()
    {
        return state;
    }

    public void setTimeFinished(long finishedTime) {
        this.timeFinished = finishedTime;
    }

    public long getTimeFinished() {
        return this.timeFinished;
    }
}
