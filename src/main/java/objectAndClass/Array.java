package objectAndClass;

public class Array {

    public static void main(String[] args) {
        //Declare circleArray //初始化0.5 > Int[] circleArray
        CircleWithStaticMembers[] circleArray;   //宣告circeArray[] 套用class CircleWithStaticMembers

        //Create circleArray  //初始化0.5 > = {61,30,35...}
        circleArray = createCircleArray();

        printCircleArray(circleArray);

    }

    //存回array
    public static CircleWithStaticMembers[] createCircleArray() {
        CircleWithStaticMembers[] circleArray = new CircleWithStaticMembers[5]; //circleArray > circleArray[0]... > value

        for (int i = 0; i < circleArray.length; i++) {
            circleArray[i] = new CircleWithStaticMembers(Math.random() * 100);  //把circleArray[i]指定給某類並進行初始化方法
        }
        return circleArray;  //生成{61,30,35...}
    }

    //代入資料型態為array的資料
    public static void printCircleArray(CircleWithStaticMembers[] circleArray) {
        System.out.printf("%-30s%-15s\n", "Radius", "Area"); //printf列印格式化字串//%-30s:長度沒有到30就補空格
        for (int i = 0; i < circleArray.length; i++) {
            System.out.printf("%-30f%-15f", circleArray[i].getRadius(),  //***取用class內方法：.method()
                    circleArray[i].getArea());
            System.out.println();  //換行
        }
        System.out.println("============================");

        System.out.printf("%-30s%-15f\n", "The total areas of circle is",
                sum(circleArray));  //***調用本地method: method()
    }

    public static double sum(CircleWithStaticMembers[] circleArray) {
        double sum = 0;
        for (int i = 0; i < circleArray.length; i++) {
            sum += circleArray[i].getArea();
        }
        return sum;
    }

}
