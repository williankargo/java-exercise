package Test.OOD;


/**
 * buffer , size = 2 A一開始持有兩個token，有一半的機率給B, 一半的機率給C
 * 如果D至少有一個token, buffer(size =
 * 2)又沒有滿，D會send一個token to buffer, 如果buffer是滿的, D停止 如果至少有一個token在buffer, F會拿一個token,
 * 如果buffer是空的，F停止
 */

public class final2 {

    public static void main(String args[]) throws Exception {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        E e = new E();
        F f = new F();

        a.f = f; //f>a
        b.a = a; //a>b
        c.a = a; //a>c
        d.b = b; //b>d
        e.c = c; //c>e
        f.d = d; //d>f
        f.e = e; //e>f

        for (int i = 0; i < 100; i++) {
            new Thread(a).start();
            new Thread(b).start();
            new Thread(c).start();
            new Thread(d).start();
            new Thread(e).start();
            new Thread(f).start();
        }
    }
}


class A implements Runnable {
    public int product = 2;
    F f = null;

    public synchronized void run() {
        try {
            getProduct();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public synchronized void getProduct() throws InterruptedException {
        while (f.product == -1) Thread.sleep(1000);

        while (f.product != -1) {
            f.product = -1;
            this.product = 1;
            System.out.println("A get a product.");
        }
    }
}

class B implements Runnable {
    public int product = -1;
    A a = null;

    public synchronized void run() {
        try {
            getProduct();

        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public synchronized void getProduct() throws InterruptedException {
        while (a.product == -1) Thread.sleep(1000);
        a.product = -1;
        this.product = 1;
        System.out.println("B get a product.");
    }
}

class C implements Runnable {
    public int product = -1;
    A a = null;

    public synchronized void run() {
        try {
            getProduct();

        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public synchronized void getProduct() throws InterruptedException {
        while (a.product == -1) Thread.sleep(1000);
        a.product = -1;
        System.out.println("C get a product.");
        this.product = 1;
    }
}

class D implements Runnable {
    public int product = -1;
    B b = null;

    public synchronized void run() {
        try {
            getProduct();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public synchronized void getProduct() throws InterruptedException {
        while (b.product == -1) Thread.sleep(1000);
        b.product = -1;
        System.out.println("D get a product.");
        this.product = 1;

    }
}

class E implements Runnable {
    public int product = -1;
    C c = null;

    public synchronized void run() {
        try {
            getProduct();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public synchronized void getProduct() throws InterruptedException {
        while (c.product == -1) Thread.sleep(1000);
        c.product = -1;
        this.product = 1;
        System.out.println("E get a product.");
    }
}

class F implements Runnable {
    public int product = -1;
    D d = null;
    E e = null;

    public synchronized void run() {
        try {
            getProduct();
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public synchronized void getProduct() throws InterruptedException {
        while (e.product == -1 && d.product == -1) Thread.sleep(1000);
        while (e.product != -1) {
            e.product = -1;
            this.product = 1;
            System.out.println("F get a product.");
        }
        while (d.product != -1) {
            d.product = -1;
            this.product = 1;
            System.out.println("F get a product.");
        }
    }
}
