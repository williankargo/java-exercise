package Abstract;

public class TestAbstract {

    public static void main(String[] args) {
        //PowerAbstract ins = new PowerAbstract(); 抽象類不能使用new來初始化
        AbstractBigSon ins = new AbstractBigSon();  //通過非抽象子類，來調用該 子類繼承的抽象父類 的構造方法

        PowerAbstract[] fb = new PowerAbstract[2]; //抽象類無法new來創造object, 但可以作為一種數據類型，這裡創造兩個類型空間
        fb[1] = new AbstractBigSon(); //並指向抽象父類的子類
        fb[0] = new test();//並指向非抽象父類的子類


    }
}
