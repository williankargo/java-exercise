package dataStructure.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();  //先進先出

        queue.offer(1);
        queue.offer(2);
        queue.add(3);

        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println(queue.size());

        queue.clear();
        System.out.println(queue);

        //poll v.s. remove: poll在沒有東西可移時會返回null, remove在沒有東西可移時會返回Exception
        System.out.println(queue.poll());

        int r = queue.remove();
        System.out.println(r);


    }
}
