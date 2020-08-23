package multithreading;

class Cookies {

    private boolean empty = true;

    public synchronized void put(int cNo) {
        while (!empty) {
            try {
                wait();  //強迫 thread 放掉手上的 lock
            } catch (InterruptedException e) {
            }
        }
        System.out.println("主人放了第 " + cNo + " 塊餅乾.");
        empty = false;
        notify();  //通知大家來搶lock
    }

    public synchronized void eat(int cNoo) {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("小白狗吃了第 " + cNoo + " 塊餅乾.");
        empty = true;
        notify();
    }
}


class Eat implements Runnable {

    Cookies cookies;

    Eat(Cookies cookies) {
        this.cookies = cookies;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            cookies.eat(i);
        }
    }
}

class Put implements Runnable {

    Cookies cookies;

    Put(Cookies cookies) {
        this.cookies = cookies;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            cookies.put(i);
        }
    }
}


public class Dog_and_Cookies {

    public static void main(String[] args) {
        Cookies cookies = new Cookies();
        Put put = new Put(cookies);
        Eat eat = new Eat(cookies);    //使用同個cookies
        Thread dog = new Thread(eat);  //產生Tread類別物件dog
        Thread master = new Thread(put); //產生Tread類別物件master
        dog.start();
        master.start();
    }
}
