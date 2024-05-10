package Stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsPalindrome {

    // With Queue and Stack.
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        stack.push('r');
        stack.push('a');
        stack.push('c');
        stack.push('e');
        stack.push('c');
        stack.push('a');
        stack.push('r');
        System.out.println(isPalindromeUsingStackAndQueue(stack)); // Should print: true

        System.out.println(isPalindromeUsingStack(stack)); // Should print: true
    }

    public static boolean isPalindromeUsingStackAndQueue(Stack<Character> stack) {
        Queue<Character> queue = new LinkedList<>();

        // Copy the elements from the stack to the queue
        for (Character c : stack) {
            queue.add(c);
        }

        // Compare the elements in the stack and the queue
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindromeUsingStack(Stack<Character> stack) {
        Stack<Character> reversedStack = new Stack<>();
        Stack<Character> tempStack = (Stack<Character>) stack.clone();

        // Create a reversed copy of the original stack
        while (!tempStack.isEmpty()) {
            reversedStack.push(tempStack.pop());
        }

        // Compare the elements in the original stack and the reversed stack
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(reversedStack.pop())) {
                return false;
            }
        }

        return true;
    }
}
