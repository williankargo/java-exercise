package multithreading;

public class JoinMethod {

    public static void main(String[] args) {
        Thread itemA = new Thread(new PrintTaskA());

        itemA.start();
    }

}

class PrintTaskA implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i == 50) {
                Thread itemB = new Thread(new PrintTaskB());
                try {
                    itemB.join(); //等到這個執行完，下面才可以執行
                    itemB.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(i + " ");
        }
    }
}

class PrintTaskB implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("wait!");
        }
    }
}
