package Test.OOD.quiz0428;

public class test2 {

}

class Pokemon {

    private int HP;
    private int AT;
    private int DE;
    private int SA;
    private int SD;
    private int SP;
    private String ability;
    private Skill skill;


    public Pokemon(int HP, int AT, int DE,
                   int SA, int SD, int SP, String ability) {
        this.HP = 3;
        this.AT = 4;
        this.DE = 5;
        this.SA = 6;
        this.SD = 7;
        this.SP = 8;
        this.ability = "QQ";

        skill.Skill1 = "Tackle";
        skill.Skill2 = null;
        skill.Skill3 = null;
        skill.Skill4 = null;
    }

    class Skill {

        String Skill1;
        String Skill2;
        String Skill3;
        String Skill4;
    }

    public void show() {
        System.out.println(HP + AT + DE + SA + SD + SP + ability);
        System.out
                .println(skill.Skill1 + skill.Skill2 + skill.Skill3 + skill.Skill4);
    }
}
