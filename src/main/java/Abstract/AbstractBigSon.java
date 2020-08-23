package Abstract;

public class AbstractBigSon extends PowerAbstract {

    //非抽象子類繼承抽象父類：(1)如果不能實現所有父類抽象方法，子類也必須定義為抽象 (2)不然就是要實現父類的抽象方法
    //抽象子類可繼承自非抽象父類
    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return 0;
    }
}
