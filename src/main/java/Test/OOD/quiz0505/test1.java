package Test.OOD.quiz0505;

import java.util.Scanner;

public class test1 {

    public static void main(String[] args) {
        double X, Y;

        Scanner scn = new Scanner(System.in);
        System.out.println("Please set the values of X and Y");
        X = scn.nextDouble();
        Y = scn.nextDouble();
        System.out.println("X is " + X + " and Y is " + Y + "\n\n");

        Avatar avatar = new Avatar();
        avatar.show();

        Saber saber = new Saber(X, Y);
        saber.show();

        Caster caster = new Caster(X, Y);
        caster.show();

        Assassin assassin = new Assassin(X, Y);
        assassin.show();

    }
}

class Avatar {

    private String name;
    private String gender;
    private double HealthPoints;
    private double MagicPoints;
    private double Stamina;
    private String skill;

    public Avatar() {
        this("None", "Others", 100, 100, 100, "Punch");
    }

    public Avatar(String name, String gender, double HealthPoints, double MagicPoints,
                  double Stamina, String skill) {
        this.name = name;
        this.gender = gender;
        this.HealthPoints = HealthPoints;
        this.MagicPoints = MagicPoints;
        this.Stamina = Stamina;
        this.skill = skill;
    }

    public void show() {
        System.out.println(" Name: " + "[" + this.name + "]" + " Gender: " + "[" + this.gender + "]" +
                " HP: " + "[" + this.HealthPoints + "]" + " MP: " + "[" + this.MagicPoints + "]" +
                " ST: " + "[" + this.Stamina + "]" + " Skill: " + "[" + this.skill + "]");
    }
}

class Saber extends Avatar {


    public Saber(double x, double y) {

        super("Peter", "Male", 100 * x, 100 * y,
                100 * y, "Slash");
    }
}

class Caster extends Avatar {

    public Caster(double x, double y) {

        super("Mike", "Male", 100 * y, 100 * x,
                100 * y, "Fire Ball");
    }
}

class Assassin extends Avatar {

    public Assassin(double x, double y) {
        super("Derek", "Male", 100 * y, 100 * y,
                100 * x, "Assassinate");
    }
}


















