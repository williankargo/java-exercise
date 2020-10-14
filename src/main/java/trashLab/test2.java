package trashLab;


import java.util.concurrent.atomic.AtomicInteger;

class GetThread implements Runnable {
    private static AtomicInteger counter = new AtomicInteger(0);

    public void run() {
        int c = counter.incrementAndGet();
        System.out.print(c + " ");
    }
}

public class test2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new GetThread());
        Thread t2 = new Thread(new GetThread());
        Thread t3 = new Thread(new GetThread());

        Thread[] threads = {t1, t2, t3};
        for (Thread t : threads) {
            t.start();
        }
    }
}

