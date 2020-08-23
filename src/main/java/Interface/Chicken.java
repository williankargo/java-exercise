package Interface;

public class Chicken extends Animal implements Edible { //interface可以理解成一種abstract class, 所以適用繼承概念

    @Override
    public String sound() {
        return "Chicken singer";
    }

    @Override
    public String howToEat() {
        return "Chicken eater";
    }
}
