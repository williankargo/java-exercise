package multithreading;

class LockThread extends Thread {
    int i = 10;

    public synchronized void display(LockThread obj) {  //同一object只能有一條thread進入synchronized
        try {
            System.out.println("HI! " + "It's: " + obj.getName());
            Thread.sleep(5);
            System.out.println("here1" + obj.getName());
            obj.increment(this);
            System.out.println("here2" + obj.getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void increment(LockThread obj) {
        i++;
    }
}

public class synchronizeDemo {
    public static void main(String[] args) {
        final LockThread obj1 = new LockThread();
        final LockThread obj2 = new LockThread();

        new Thread(() -> obj1.display(obj2)).start();

        new Thread(() -> obj2.display(obj1)).start();

        // 所以此例會發生deadlock
    }

}

/**
 * 当synchronized作用在实例方法时，监视器锁（monitor）便是对象实例（this）；
 * 当synchronized作用在静态方法时，监视器锁（monitor）便是对象的Class实例，因为Class数据存在于永久代，因此静态方法锁相当于该类的一个全局锁；
 * 当synchronized作用在某一个对象实例时，监视器锁（monitor）便是括号括起来的对象实例
 */