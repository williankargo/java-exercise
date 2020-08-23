package multithreading;

class Producer implements Runnable {

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生產者開始生產倒數...");
        for (int product = 1; product <= 10; product++) {
            try {
                clerk.setProduct(product);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}

class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        System.out.println("消費者開始消耗整數...");
        for (int i = 1; i <= 10; i++) {
            try {
                clerk.getProduct();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}

class Clerk {

    private int product = -1;

    public synchronized void setProduct(int product) throws InterruptedException {
        waitIfFull();
        this.product = product;
        System.out.println("生產者設定 " + this.product);
        notify();
    }

    private synchronized void waitIfFull() throws InterruptedException {
        while (this.product != -1) {
            wait();  //如果product != -1, 要wait()  (強迫 thread 放掉手上的 lock)
        }
    }

    public synchronized int getProduct() throws InterruptedException {
        waitIfEmpty();
        int p = this.product;
        System.out.println("消費者取走 " + p);
        this.product = -1;
        notify();
        return p;
    }

    private synchronized void waitIfEmpty() throws InterruptedException {
        while (this.product == -1) {
            wait();    //如果product == -1, 要wait()
        }
    }

}


public class ProducerConsumerDemo {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        new Thread(new Producer(clerk)).start();
        new Thread(new Consumer(clerk)).start();
    }
}
