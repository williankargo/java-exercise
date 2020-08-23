package Interface;

public class Apple extends Fruit {
    //Apple為具體非抽象類，所以必須把上面的class, interface的抽象方法具體化
    @Override
    public String howToEat() {
        return "apple eater";
    }
}
