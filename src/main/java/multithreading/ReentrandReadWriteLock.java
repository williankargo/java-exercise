package multithreading;


import java.util.concurrent.locks.ReentrantReadWriteLock;

class TableData {
    private final ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();

    static void sleep(int secs) {
        try {
            Thread.sleep(secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        rw1.writeLock().lock();
        System.out.println("holding write lock");
        sleep(3);
        rw1.writeLock().unlock();
        System.out.println("released write lock");
    }

    public void delete() {
        rw1.writeLock().lock();
        System.out.println("holding write lock");
        sleep(3);
        rw1.writeLock().unlock();
        System.out.println("released write lock");
    }

    public void query() {
        rw1.readLock().lock();
        System.out.println("holding read lock");
        sleep(3);
        rw1.readLock().unlock();
        System.out.println("released read lock");
    }
}

public class ReentrandReadWriteLock {

    static void query(final TableData d) {
        new Thread() {
            public void run() {
                d.query();
            }
        }.start();
    }

    static void delete(final TableData d) {
        new Thread() {
            public void run() {
                d.delete();
            }
        }.start();
    }

    static void update(final TableData d) {
        new Thread() {
            public void run() {
                d.update();
            }
        }.start();
    }

    static void counting() {
        new Thread() {
            public void run() {
                int i = 0;
                while (true) {
                    TableData.sleep(1);
                    System.out.println(i++);
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        counting();
        final TableData table = new TableData();
        query(table);
        query(table);
        update(table);
        delete(table);
        query(table);
        query(table);
        update(table);
    }


}
