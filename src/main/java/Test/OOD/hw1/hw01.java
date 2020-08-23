package Test.OOD.hw1;


import java.util.Scanner;

public class hw01 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //1
        System.out.println("請輸入使用者名稱：");
        card example = new card(input.next());
        //2
        System.out.println("請輸入儲值金額：");
        int storemoney = input.nextInt();
        while (storemoney == 0 || storemoney < 0) {
            System.out.println("請輸入正數，error");
            System.out.println("請輸入儲值金額：");
            storemoney = input.nextInt();
        }
        example.store(storemoney);
        System.out.print("目前餘額：");
        example.getRemain();
        //3
        System.out.println("請輸入扣款金額：");
        int chargemoney = input.nextInt();
        while (chargemoney == 0 || chargemoney < 0) {
            System.out.println("請輸入正數，error!");
            System.out.println("請輸入扣款金額：");
            chargemoney = input.nextInt();
        }
        example.charge(chargemoney);
        System.out.print("目前餘額：");
        example.getRemain();
    }
}

class card {

    int remain = 100;
    String number;

    card(String number) {
        this.number = number;
    }

    void store(int money) {
        remain = remain + money;
    }

    void charge(int money) {
        remain = remain - money;
        if (remain < 0) {
            System.out.println("餘額不足,error!");
        }
    }

    void getRemain() {
        System.out.println(remain);
    }
}