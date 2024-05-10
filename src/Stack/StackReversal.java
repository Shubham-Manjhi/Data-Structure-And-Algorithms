package Stack;

import java.util.Stack;

public class StackReversal {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        reverse(stack);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int bottom = popBottom(stack);
        reverse(stack);
        stack.push(bottom);
    }

    private static int popBottom(Stack<Integer> stack) {
        int top = stack.pop();

        if (stack.isEmpty()) {
            return top;
        } else {
            int bottom = popBottom(stack);
            stack.push(top);
            return bottom;
        }
    }
}
