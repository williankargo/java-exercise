package StreamDemo;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

//彼此之間無關聯狀態，可以用並行，如果資料高度相關，用並行反而會比較慢
public class ParallelStream {

    public static void main(String[] args) {
        Random random = new Random();
        int[] list = random.ints(200_000_000).toArray();  //隨機產生兩億條數據

        System.out.println("Number of processors: " + Runtime.getRuntime().availableProcessors());  //有幾個處理器

        //(1)Sequential streams work just like for-loop using a single core.
        long startTime = System.currentTimeMillis();
        int[] list1 = IntStream.of(list).filter(e -> e > 0).sorted().limit(5).toArray();
        System.out.println(Arrays.toString(list1));
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential execution time is " + (endTime - startTime) + " milliseconds.");

        //(2)Parallel streams divide the provided task into many and run them in different threads,
        // utilizing multiple cores of the computer.
        startTime = System.currentTimeMillis();
        int[] list2 = IntStream.of(list).parallel().filter(e -> e > 0).sorted().limit(5).toArray();
        System.out.println(Arrays.toString(list2));
        endTime = System.currentTimeMillis();
        System.out.println("Sequential execution time is " + (endTime - startTime) + " milliseconds.");


    }
}
