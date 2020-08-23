package Test.OOD.hw2;

import java.text.DecimalFormat;
import java.util.Random;

class Player {


    private static double totalDamage = 0;
    private double playerDamage = 0;

    //如果沒有傳參數，則隨機分配9個點數
    private int attackAbility;  //攻擊
    private double critChance; //爆擊
    private double critMagn; //爆傷


    //如果沒有傳參數，則隨機分配9個點數(int)
    Player() {

        //method1(slow)
        int one = 0;
        int two = 0;
        int three = 0;
        while (one + two + three != 9) {
            one = (int) (Math.random() * 10);
            two = (int) (Math.random() * 10);
            three = (int) (Math.random() * 10);
        }

//    //method2(fast,但機率可能不平均)
//    Random rand = new Random();
//    int one = rand.nextInt(10);//0-9
//    int two = 0;  //初始化用
//    int three = 0;  //初始化用
//    if (one == 9) {  //因為nextInt(裡面必須是正數)，所以有這個防呆條件
//      two = 0;
//      three = 0;
//    } else {
//      two = rand.nextInt(9 - one);
//      three = 9 - one - two;
//    }

//    if (!(one + two + three == 9)) {
//      System.out.println("幹你超過9了啦");
//    }

        this.attackAbility = 1 + one * 1;  //初始值是1
        this.critChance = 0.25 + two * 0.05;  //初始值是0.25
        //System.out.println("機率是： " + this.critChance);
        this.critMagn = 1.5 + three * 0.01;  //初始值為1.5
    }


    //如果有傳參數，則分配9個點數，加總必須等於9
    Player(int attackAbility, int critChance, int critMagn) {
        int number = attackAbility + critChance + critMagn;
        if (number != 9) {
            System.out.println("請重新輸入！");
        } else {
            this.attackAbility = 1 + attackAbility * 1;  //初始值是1
            this.critChance = 0.25 + critChance * 0.05;  //初始值是0.25
            //System.out.println("機率是： " + this.critChance);
            this.critMagn = 1.5 + critMagn * 0.01;  //初始值為1.5
        }

    }


    //用來攻擊，會有critChance的機率產生 攻擊=attackAbility*critMagn
    public void attack() {

        //機率的作法>>>
        Random rand = new Random();  //Random放的seed一樣，隨機結果會一樣
        //int test = rand.nextInt(100);//nextInt()隨機生成bound內的int, ex:0-100(no 100)
        double test = rand.nextDouble();  //均勻產生0-1
        boolean chance = test <= critChance;
        //<<<

        if (chance) {
            double attack = attackAbility * critMagn;
            System.out.print(attack);  //印出攻擊數據

            this.playerDamage = this.playerDamage + attack;  //加到個別的
            totalDamage = totalDamage + attack;  //加到整體的
        } else {
            System.out.print(0);
        }
    }

    //print出該物件至今造成的總傷害
    public void showDamage() {
        System.out.println("此player目前造成的傷害是： " + this.playerDamage);
    }

    //print出該物件的傷害在所有物件造成的總傷害中，佔多少比例（百分比，四捨五入到小數第二位）
    public void damageRate() {
        double ratio = (this.playerDamage / totalDamage) * 100;

        //四捨五入到小數第二位>>>
        DecimalFormat df = new DecimalFormat("##.00");
        ratio = Double.parseDouble(df.format(ratio));
        //<<<

        System.out.println("此player目前造成的傷害佔所有player總傷害的百分比： " + ratio + "%");

    }

    //比較兩個物件的傷害，並回傳造成較高傷害的物件
    public Player compare(Player p) {
        if (this.playerDamage > p.playerDamage) {
            return this;
        } else if (this.playerDamage < p.playerDamage) {
            return p;
        } else {  //平手
            return this;
        }
    }
}


public class HW02_2 {

    public static void main(String[] args) {
        //創造10個Player物件，每個物件可攻擊3次
        Player[] players = new Player[10];

        //1
        System.out.println("玩家1");
        players[0] = new Player(3, 3, 3);
        for (int i = 0; i < 3; i++) {
            System.out.print("玩家第" + (i + 1) + "次攻擊: ");
            players[0].attack();
            System.out.println();  //newline
        }

        //2
        System.out.println("玩家2");
        players[1] = new Player(2, 7, 1);
        for (int i = 0; i < 3; i++) {
            System.out.print("玩家第" + (i + 1) + "次攻擊: ");
            players[1].attack();
            System.out.println();
        }

        //3
        System.out.println("玩家3");
        players[2] = new Player(4, 2, 3);
        for (int i = 0; i < 3; i++) {
            System.out.print("玩家第" + (i + 1) + "次攻擊: ");
            players[2].attack();
            System.out.println();
        }

        //4
        System.out.println("玩家4");
        players[3] = new Player(2, 2, 5);
        for (int i = 0; i < 3; i++) {
            System.out.print("玩家第" + (i + 1) + "次攻擊: ");
            players[3].attack();
            System.out.println();
        }

        //5
        System.out.println("玩家5");
        players[4] = new Player(7, 1, 1);
        for (int i = 0; i < 3; i++) {
            System.out.print("玩家第" + (i + 1) + "次攻擊: ");
            players[4].attack();
            System.out.println();
        }

        //6
        System.out.println("玩家6");
        players[5] = new Player();
        for (int i = 0; i < 3; i++) {
            System.out.print("玩家第" + (i + 1) + "次攻擊: ");
            players[5].attack();
            System.out.println();
        }

        //7
        System.out.println("玩家7");
        players[6] = new Player();
        for (int i = 0; i < 3; i++) {
            System.out.print("玩家第" + (i + 1) + "次攻擊: ");
            players[6].attack();
            System.out.println();
        }

        //8
        System.out.println("玩家8");
        players[7] = new Player();
        for (int i = 0; i < 3; i++) {
            System.out.print("玩家第" + (i + 1) + "次攻擊: ");
            players[7].attack();
            System.out.println();
        }

        //9
        System.out.println("玩家9");
        players[8] = new Player();
        for (int i = 0; i < 3; i++) {
            System.out.print("玩家第" + (i + 1) + "次攻擊: ");
            players[8].attack();
            System.out.println();
        }

        //10
        System.out.println("玩家10");
        players[9] = new Player();
        for (int i = 0; i < 3; i++) {
            System.out.print("玩家第" + (i + 1) + "次攻擊: ");
            players[9].attack();
            System.out.println();
        }

        //比較10個players的攻擊大小，選最大的出來
        Player maxDamage = players[0];
        for (int i = 0; i < 10; i++) {
            maxDamage = maxDamage.compare(players[i]);
        }
        //存取造成較高傷害的物件，並print出其造成的總傷害(showDamage)和傷害佔比(damageRate)
        Player highestDamage = maxDamage;
        System.out.println("造成傷害最大的player的狀況");
        //System.out.println(maxDamage);//無法直接print出object的name
        highestDamage.showDamage();
        highestDamage.damageRate();
    }
}
