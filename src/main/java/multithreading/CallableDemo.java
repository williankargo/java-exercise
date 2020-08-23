package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService items = Executors.newFixedThreadPool(3);

        Future<Double> future = items.submit(new PrintNumber2());  //submit返回future

        items.shutdown();//記得要關掉，不再接受請求！

        while (!future.isDone()) { //非阻塞式
            System.out.println("Thread is not finished!");
        }
        try {
            System.out.println("future:" + future.get()); //get是阻塞式的，會一直等待到完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


//runnable是void無法傳回值，callable可以傳回值
class PrintNumber2 implements Callable<Double> {

    @Override
    public Double call() throws Exception {
        return Math.random(); //可返回<>內的類型
    }
}