package Test.OOD.quiz0526;

abstract class Avatar {

    String name;
    String gender;
    double HealthPoints;
    double MagicPoints;
    double Stamina;
    String skill;

    abstract public void show();

    public void attack() {
        System.out.println("Test: " + this.skill + " !!!!");
    }
}

interface Avatar2D {

    /**
     * interface必須初始化資料
     */
    String name = "NoName";
    String gender = "NoGender";
    double HealthPoints = 100.0;
    double MagicPoints = 100.0;
    double Stamina = 100.0;
    String skill = "NoSkill";

    abstract public void show();
}

class Saber extends Avatar {

    public Saber(String name, String gender, double HP, double MP, double ST, String skill) {
        this.name = name;
        this.gender = gender;
        this.HealthPoints = HP;
        this.MagicPoints = MP;
        this.Stamina = ST;
        this.skill = skill;
    }

    public void show() {
        System.out.println(
                "Name: " + this.name + " Gender: " + this.gender + " HP: " + this.HealthPoints + " MP: "
                        + this.MagicPoints + " ST: " + this.Stamina + " Skill: " + this.skill);
    }
}

class Caster implements Avatar2D {

    public void show() {
        System.out.println(
                "Name: " + this.name + " Gender: " + this.gender + " HP: " + this.HealthPoints + " MP: "
                        + this.MagicPoints + " ST: " + this.Stamina + " Skill: " + this.skill);
    }
}


public class MyClass {

    public static void main(String[] args) {

        Saber saber = new Saber("Test", "Male", 150, 150, 150, "Starburst Stream");
        saber.show();
        saber.attack();

        Caster caster = new Caster();
        caster.show();

    }
}
