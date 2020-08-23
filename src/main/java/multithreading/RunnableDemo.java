package multithreading;

public class RunnableDemo {

    public static void main(String[] args) {
        Show100A it = new Show100A();
        //runnable method
        Thread threadA = new Thread(it);
        //
        threadA.start();  //thread啟動
    }
}

//class已經繼承其他父類時，用Runnable
class Show100A implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("a");
        }
    }
}