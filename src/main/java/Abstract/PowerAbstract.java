package Abstract;

public abstract class PowerAbstract {

    private String color = "Yellow";
    private boolean filled;

    //constructor
    protected PowerAbstract() {  //構造方法用於創造類的實例，但抽象類的構造方法不能被new，只能被子類調用
        System.out.println("PowerAbstract's constructor!");
    }

    protected PowerAbstract(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    //method
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean getFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    //abstract method:抽象方法必須存於抽象class中，但是抽象class可以沒有抽象方法
    public abstract double getArea();

    public abstract double getPerimeter();

}
