package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService items = Executors.newFixedThreadPool(3); //創造一個thread pool //可以使用newCachedThreadPool伸縮池

        items.execute(new PrintNumber());
        items.execute(new PrintNumber());
        items.execute(new PrintNumber());

        items.execute(new PrintNumber()); //必須要有空的thread完成後才可以執行

        items.shutdown(); //關閉thread調用（但thread可能還在執行）
    }
}

class PrintNumber implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + Math.random());
        try {
            Thread.sleep((int) (Math.random() * 20000)); //使用sleep必須要有try & catch
            System.out.println(Thread.currentThread().getName() + "finished!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}