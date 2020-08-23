package Test.OOD.quiz0407;


import java.util.Scanner;

public class test040701 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please set the values of X and Y:");
        double X = input.nextDouble();
        double Y = input.nextDouble();
        System.out.println("X is " + X + " and Y is " + Y);

        Avatar example1 = new Avatar(X, Y);

        System.out.println("Enter the name:");
        example1.setName(input.next());

        System.out.println("Enter the gender:");
        example1.setGender(input.nextInt());

        System.out.println("Enter the profession:");
        example1.setProfession(input.nextInt());
        ///
        Avatar example2 = new Avatar(X, Y);

        System.out.println("Enter the name:");
        example2.setName(input.next());

        System.out.println("Enter the gender:");
        example2.setGender(input.nextInt());

        System.out.println("Enter the profession:");
        example2.setProfession(input.nextInt());
        ///
        Avatar example3 = new Avatar(X, Y);

        System.out.println("Enter the name:");
        example3.setName(input.next());

        System.out.println("Enter the gender:");
        example3.setGender(input.nextInt());

        System.out.println("Enter the profession:");
        example3.setProfession(input.nextInt());
        ///

        System.out.println(
                "Avatar name: " + example1.getName() + " Gender: " + example1.getGender()
                        + " Profession: "
                        + example1.getProfession() + " HP: " + example1.getHealthPoints() + " MP: " + example1
                        .getMagicPoints() +
                        " ST: " + example1.getStamina() + " Skill: " + example1.getSkill());

        System.out.println(
                "Avatar name: " + example2.getName() + " Gender: " + example2.getGender()
                        + " Profession: "
                        + example2.getProfession() + " HP: " + example2.getHealthPoints() + " MP: " + example2
                        .getMagicPoints() +
                        " ST: " + example2.getStamina() + " Skill: " + example2.getSkill());

        System.out.println(
                "Avatar name: " + example3.getName() + " Gender: " + example3.getGender()
                        + " Profession: "
                        + example3.getProfession() + " HP: " + example3.getHealthPoints() + " MP: " + example3
                        .getMagicPoints() +
                        " ST: " + example3.getStamina() + " Skill: " + example3.getSkill());


    }

    public static class Avatar {

        private String name;
        private String gender;
        private String profession;
        private double HealthPoints = 100;
        private double MagicPoints = 100;
        private double Stamina = 100;
        static double X;
        static double Y;
        private String Skill;

        Avatar(double X, double Y) {
            this.X = X;
            this.Y = Y;
        }


        public String getSkill() {
            if (profession == "Saber") {
                Skill = "Slash";
            } else if (profession == "Caster") {
                Skill = "Fire Ball";
            } else if (profession == "Assassin") {
                Skill = "Assassinate";
            }
            return Skill;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(int number) {
            if (number == 0) {
                gender = "Male";
            } else if (number == 1) {
                gender = "Female";
            } else if (number == 2) {
                gender = "Others";
            }
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(int number) {
            if (number == 0) {
                profession = "Saber";
            } else if (number == 1) {
                profession = "Caster";
            } else if (number == 2) {
                profession = "Assassin";
            }
        }

        public double getHealthPoints() {
            if (profession == "Saber") {
                HealthPoints = this.HealthPoints * X;
            } else if (profession == "Caster") {
                HealthPoints = this.HealthPoints * Y;
            } else if (profession == "Assassin") {
                HealthPoints = this.HealthPoints * Y;
            }
            return HealthPoints;
        }


        public double getMagicPoints() {
            if (profession == "Saber") {
                MagicPoints = this.MagicPoints * Y;
            } else if (profession == "Caster") {
                MagicPoints = this.MagicPoints * X;
            } else if (profession == "Assassin") {
                MagicPoints = this.MagicPoints * Y;
            }
            return MagicPoints;
        }


        public double getStamina() {
            if (profession == "Saber") {
                Stamina = this.Stamina * Y;
            } else if (profession == "Caster") {
                Stamina = this.Stamina * Y;
            } else if (profession == "Assassin") {
                Stamina = this.Stamina * X;
            }
            return Stamina;
        }


    }
}

