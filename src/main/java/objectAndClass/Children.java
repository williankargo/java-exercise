package objectAndClass;

///////////////////////////////
public class Children extends Father { //繼承從Father

    //------------------------------------------
    public static void main(String[] args) {
        new Children(); //new a object without sorting it to reference
        //聲明類型：決定使用何種方法  //實際類型：決定物件在哪
        GrandFather people = new Father();
        people.Ball(); //***儘管people是GrandFather類型，會印出Father的override method

        polymorphism(new Children());//polymorphism概念

        GrandFather people2 = new Father(); //想隱性轉換，想成在Father和GrandFather都有創造實例
        System.out.println(people2 instanceof Father); //是父輩的對象，不會是子輩的對象
        ((Father) people2).Penis(33);//(告訴編譯器GrandFather類的people2(變量,對象)也是Father類的對象)#>
        people.testObject();//直接使用聲明類型的方法

        Father people3 = new Father();
        System.out.println(people3 instanceof GrandFather);//是子輩的對象，就會是父輩的對象
        people3.testObject();//所以可以用父輩方法

        //#<
//  GrandFather people4 = new GrandFather();
//  ((Father)people4).Penis(33);  無法運行！

    }
//------------------------------------------

    public Children() {           //會先執行父輩的constructor, 以此類推
        System.out.println("(4) Children's constructor is invoked.");
        super.Penis();   //super調用父輩方法(上一級優先，如果找不到就再往上找一級)
    }

    //method
    public static void polymorphism(GrandFather object) {  //測試polymorphism, 我放入children object一樣可以執行
        System.out.println("test");
    }

}

/////////////////////////////////
class Father extends GrandFather {

    public Father() {
        this("(2) Father's 有參constructor is invoked.");
        System.out.println("(3) Father's 無參constructor is invoked.");
    }

    public Father(String s) {
        System.out.println(s);
    }

    public void Penis() {
        System.out.println("Father's Penis");
    }

    public void Penis(int a) {  //(2)overload(同class、不同class都可):方法簽名不同
        if (a > 30) {
            System.out.println("liar!");
        }
    }

    @Override
    public void Ball() {   //(1) override from GrandFather(不同class) v.s super()>>不改變
        System.out.println("Father's ball!");
    }
}
////////////////////////////////

class GrandFather {

    public GrandFather() {
        System.out.println("(1) GrandFather's constructor is invoked.");
    }

    public void Penis() {
        System.out.println("GrandFather's Penis");
    }

    public void Ball() {
        System.out.println("grandFather's ball!");
    }

    public void testObject() {
        System.out.println("testObject!");
    }


}
