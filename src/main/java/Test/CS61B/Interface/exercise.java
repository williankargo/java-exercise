package Test.CS61B.Interface;


public class exercise {

    public static void main(String[] args) {
        Animal a = new Animal("Pluto", 10);
        Cat c = new Cat("Garfield", 6);
        Dog d = new Dog("Fido", 4);

        a.greet(); // (A) Animal Pluto says: Huh?
        c.greet(); // (B) Cat Garfield says: Meow!
        d.greet(); // (C) Dog Fido says: WOOF!

        a = c;
        ((Cat) a).greet(); // (D) Cat Garfield says: Meow!
        a.greet(); // (E) Cat Garfield says: Meow!


        a = new Dog("Spot", 10);

        /**
         * d = a;   這是錯的，因為a的static type is Animal & d的static type is Dog，無法子納父，需要cast
         * */

        d = (Dog) a;

    }
}


class Animal {

    protected String name, noise;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.noise = "Huh?";
    }

    public String makeNoise() {
        if (age < 5) {
            return noise.toUpperCase();
        } else {
            return noise;
        }
    }

    public void greet() {
        System.out.println("Animal " + name + " says: " + makeNoise());
    }
}

class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age); // Call superclass' constructor.
        this.noise = "Meow!"; // Change the value of the field.
    }

    @Override
    public void greet() {
        System.out.println("Cat " + name + " says: " + makeNoise());
    }
}

class Dog extends Animal {

    public Dog(String name, int age) {
        super(name, age);
        noise = "Woof!";
    }

    @Override
    public void greet() {
        System.out.println("Dog " + name + " says: " + makeNoise());
    }

    public void playFetch() {
        System.out.println("Fetch, " + name + "!");
    }
}
