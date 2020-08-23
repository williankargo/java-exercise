package dataStructure.Stack;

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();  //先進後出

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.peek());  //pop但不是真正取出元素，觀察用
        System.out.println(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println(stack);


    }
}
