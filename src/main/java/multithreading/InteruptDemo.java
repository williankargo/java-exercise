package multithreading;

public class InteruptDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread itemA = new Thread(new PrintA());
        itemA.start();
        itemA.sleep(10);
        itemA.interrupt(); //被interrupt的thread，自己決定何時結束執行
    }
}

class PrintA implements Runnable {

    @Override
    public void run() {
        int counter = 0;
        while (!Thread.currentThread().isInterrupted()) { //如果沒有這一行，會一直執行下去，即使有interrupt
            System.out.println(counter++);
        }
        System.out.println("PrintA thread should stop now!");

    }
}