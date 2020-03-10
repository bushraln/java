/**
 *
 *//*


package utilities;

import game.GameEngine;
import game.arena.IArena;
import game.arena.WinterArena;
import game.competition.Competition;
import game.competition.Competitor;
import game.competition.SkiCompetition;
import game.entities.Entity;
import game.entities.IMobileEntity;
import game.entities.sportsman.Skier;
import game.entities.sportsman.Snowboarder;
import game.enums.*;

*/
/**
 * @author Itzhak Eretz Kdosha
 * Main class(run demo)
 * IMPORTANT: getting the same results as published does not mean u have correctly implemented all aspects of this home work!
 * I am avilable for any question via my mail iekdosha@gmail.com
 *//*

public class Program {

	//region Demo competition classes - NOT PART OF THE HW THIS IS JUST FOR TEST!

	*/
/**
	 * Demo competitor class for tests only
	 *//*

	static class DemoCompetitor extends Entity implements Competitor {
		private final int id;
		private final double speed;

		public DemoCompetitor(double speed, int id) {
			this.speed = speed;
			this.id = id;
		}

		public void initRace() {
			this.setLocation(new Point(0, 0));
		}

		public String toString() {
			return "Demo competitor id:" + id;
		}

		public void move(double friction) {
			this.setLocation(this.getLocation().offset(this.speed, 0)); // constant speed
		}
	}

	*/
/**
	 * Demo Arena class for tests only
	 *//*

	static class DemoArena implements IArena {
		public double getFriction() {
			return 0;
		}

		public boolean isFinished(IMobileEntity mobileEntity) {
			return mobileEntity.getLocation().getX() > 3000d;
		}
	}

	*/
/**
	 * Demo Competition class for tests only
	 *//*

	static class DemoCompetition extends Competition {
		public DemoCompetition(IArena arena, int maxCompetitors) {
			super(arena, maxCompetitors);
		}

		public boolean isValidCompetitor(Competitor competitor) {
			return true; // accept all competitors :)
		}
	}
	//endregion

	public static void main(String[] args) {

		System.out.println("================= Test 1 =================");
		Skier skier1 = new Skier("sk1", 23, Gender.MALE, 4.5, 60.0, Discipline.DOWNHILL);
		Skier skier2 = new Skier("sk2", 25, Gender.MALE, 5.0, 50.0, Discipline.DOWNHILL);
		Skier skier3 = new Skier("sk3", 23, Gender.FEMALE, 3.5, 45.0, Discipline.GIANT_SLALOM);
		Snowboarder jonsnowboarder = new Snowboarder("jon", 25, Gender.FEMALE, 8d, 100.0, Discipline.DOWNHILL);
		Skier skier4 = new Skier("sk4", 29, Gender.MALE, 4.6, 75.0, Discipline.DOWNHILL);
		Skier skier5 = new Skier("sk5", 50, Gender.MALE, 3.3, 80.0, Discipline.DOWNHILL);

		WinterArena arena = new WinterArena(1000, SnowSurface.CRUD, WeatherCondition.SUNNY);

		SkiCompetition competition = new SkiCompetition(arena, 3, Discipline.DOWNHILL, League.ADULT, Gender.MALE);
		competition.addCompetitor(skier1);
		competition.addCompetitor(skier2);
		System.out.println("--------------- Exception example 1 ---------------");
		try {
			competition.addCompetitor(skier3);
		} catch (IllegalArgumentException e) {
			e.printStackTrace(System.out);
		}
		System.out.println("--------------- Exception example 2 ---------------");
		try {
			competition.addCompetitor(jonsnowboarder);
		} catch (IllegalArgumentException e) {
			e.printStackTrace(System.out);
		}
		System.out.println("--------------- Exception example 3 ---------------");
		try {
			new Skier("sk4", 23, null, 4.5, 60.0, Discipline.DOWNHILL);
		} catch (IllegalArgumentException e) {
			e.printStackTrace(System.out);
		}
		System.out.println("--------------- Exception example 4 ---------------");
		try {
			competition.addCompetitor(null);
		} catch (IllegalArgumentException e) {
			e.printStackTrace(System.out);
		}
		System.out.println("--------------- Exception example 5 ---------------");
		competition.addCompetitor(skier4);
		try {
			competition.addCompetitor(skier5);
		} catch (IllegalStateException e) {
			e.printStackTrace(System.out);
		}
		System.out.println("--------------- COMPETE ---------------");
		GameEngine.getInstance().startRace(competition);
		System.out.println("================= Test 2 =================");
		Competitor dc1 = new DemoCompetitor(50d, 1);
		Competitor dc2 = new DemoCompetitor(90d, 2);
		Competitor dc3 = new DemoCompetitor(65d, 3);
		IArena dArena = new DemoArena();
		Competition comp = new DemoCompetition(dArena, 5);
		comp.addCompetitor(skier1);
		comp.addCompetitor(jonsnowboarder);
		comp.addCompetitor(dc1);
		comp.addCompetitor(dc2);
		comp.addCompetitor(dc3);
		System.out.println("--------------- COMPETE ---------------");
		GameEngine.getInstance().startRace(comp);
	}
}*/