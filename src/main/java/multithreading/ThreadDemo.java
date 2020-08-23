package multithreading;

public class ThreadDemo {

    public static void main(String[] args) {
        Show100B it = new Show100B();
        it.start();
    }
}

//class沒有繼承其他父類時可用Thread
class Show100B extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("b");
        }
    }
}
