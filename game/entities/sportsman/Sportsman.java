package game.entities.sportsman;

import game.entities.MobileEntity;
import game.enums.Gender;
import game.enums.League;
import utilities.Point;

/**
 * this class extend mobileentity
 * its also abstract class for evrey kind of sportsman in the competition
 */
public abstract class Sportsman extends MobileEntity implements  Cloneable{
    private String name;
    private double age;
    private Gender gender;
    private static int globalID = 0;
    private int id;
    private String color;

    public Sportsman(Point location, double maxSpeed, double acceleration, String name, double age, Gender gender, String color) {
        super(location, maxSpeed, League.calcAccelerationBonus(age)+acceleration);
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
        this.setId(globalID);
        globalID++;
        this.setColor(color);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }
//throw an exception if name is null or empty string
    public void setName(String name) {
        if(name==null)
        {
            throw new IllegalArgumentException("name cant be null");
        }
        else if(name.isEmpty()==true)
        {
            throw new IllegalArgumentException("name cant be null");
        }
        else {
            this.name=name;
        }
    }

    public double getAge() {
        return age;
    }
    // throw exception if age is not positive
    public void setAge(double age) {
        if(age<=0)
        {
            throw new IllegalArgumentException("invalid age");
        }
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }
    // throw exception if gender is null
    public void setGender(Gender gender) {
        if(gender==null)
        {
            throw new IllegalArgumentException("gender cant be null");
        }
        this.gender = gender;
    }
}
