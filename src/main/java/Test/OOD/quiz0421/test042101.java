package Test.OOD.quiz0421;

import java.util.Scanner;

public class test042101 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please set the values of X and Y:");
        double X = input.nextDouble();
        double Y = input.nextDouble();
        System.out.println("X is " + X + " and Y is " + Y);

        //1
        System.out.println("Create the first Avatar");
        Avatarr example1 = new Avatarr(X, Y);
        System.out.println(); //newline

        ///2
        System.out.println("Create the second Avatar");

        System.out.println("Enter the name:");
        String name2 = input.next();

        System.out.println("Enter the gender:");
        int gender2 = input.nextInt();

        Avatarr example2 = new Avatarr(name2, gender2, X, Y);

        ///3
        System.out.println("Create the third Avatar");

        System.out.println("Enter the name:");
        String name = input.next();

        System.out.println("Enter the gender:");
        int gender = input.nextInt();

        System.out.println("Enter the profession:");
        int profession = input.nextInt();

        Avatarr example3 = new Avatarr(name, gender, profession, X, Y);


        ///print
        example1.printAvatar();
        example2.printAvatar();
        example3.printAvatar();


    }

    public static class Avatarr {

        private String name = "null";
        private String gender = "Others";
        private String profession = "Saber";
        private double HealthPoints = 100;
        private double MagicPoints = 100;
        private double Stamina = 100;
        static double X;
        static double Y;
        private String Skill;

        //0
        Avatarr() {
        }

        //2
        Avatarr(double X, double Y) {
            this.X = X;
            this.Y = Y;
        }

        //4
        Avatarr(String name, int gender, double X, double Y) {
            this.name = name;

            this.gender = setGender(gender);

            this.X = X;
            this.Y = Y;
        }

        //5
        Avatarr(String name, int gender, int profession, double X, double Y) {

            this.name = name;

            this.gender = setGender(gender);
            this.profession = setProfession(profession);

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


        ///
        public String setGender(int number) {
            if (number == 0) {
                return "Male";
            } else if (number == 1) {
                return "Female";
            } else if (number == 2) {
                return "Others";
            }
            return null; //?
        }

        public String getProfession() {
            return profession;
        }


        ///
        public String setProfession(int number) {
            if (number == 0) {
                return "Saber";
            } else if (number == 1) {
                return "Caster";
            } else if (number == 2) {
                return "Assassin";
            }
            return null;  //?
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

        public void printAvatar() {
            System.out.println(
                    "Avatarr name: " + this.getName() + " Gender: " + this.getGender()
                            + " Profession: "
                            + this.getProfession() + " HP: " + this.getHealthPoints() + " MP: " + this
                            .getMagicPoints() +
                            " ST: " + this.getStamina() + " Skill: " + this.getSkill());
        }
    }
}