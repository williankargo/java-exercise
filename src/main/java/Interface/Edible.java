package Interface;

public interface Edible {
    //final number = ...  如果有資料成員，必須先初始化
    public abstract String howToEat();//只要定義抽象名稱就好
}

//和abstract class不同點在於：介面裡的method都必須是abstract，介面的資料成員必須初始化
