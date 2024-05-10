package Stack;

import java.util.LinkedList;

public class GenericStackWithMinMaxInO1<T extends Comparable<T>> {

    // Can we Optimize Min or Max Space Complexity ? Yes, Push or Pop change Min or Max if elements are Same.

    private final LinkedList<T> stackList;
    private final LinkedList<T> minStack;
    private final LinkedList<T> maxStack;

    public GenericStackWithMinMaxInO1() {
        stackList = new LinkedList<>();
        minStack = new LinkedList<>();
        maxStack = new LinkedList<>();
    }

    public void push(T value) {
        stackList.addFirst(value);
        if (minStack.isEmpty() || value.compareTo(minStack.peekFirst()) <= 0) {
            minStack.addFirst(value);
        }
        if (maxStack.isEmpty() || value.compareTo(maxStack.peekFirst()) >= 0) {
            maxStack.addFirst(value);
        }
    }

    public T pop() {
        if (!isEmpty()) {
            T value = stackList.removeFirst();
            if (value.equals(minStack.peekFirst())) {
                minStack.removeFirst();
            }
            if (value.equals(maxStack.peekFirst())) {
                maxStack.removeFirst();
            }
            return value;
        } else {
            System.out.println("Stack is empty.");
            return null;
        }
    }

    public T top() {
        if (!isEmpty()) {
            return stackList.getFirst();
        } else {
            System.out.println("Stack is empty.");
            return null;
        }
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public int size() {
        return stackList.size();
    }

    public T max() {
        if (!isEmpty()) {
            return maxStack.peekFirst();
        } else {
            System.out.println("Stack is empty.");
            return null;
        }
    }

    public T min() {
        if (!isEmpty()) {
            return minStack.peekFirst();
        } else {
            System.out.println("Stack is empty.");
            return null;
        }
    }

    public void print() {
        stackList.forEach(value -> System.out.print(value + " "));
        System.out.println();
    }

    public boolean isStackFull() {
        // In a LinkedList implementation, the stack is never full
        // as long as there is available memory, so we return false
        return false;
    }

    public static void main(String[] args) {
        // Create a new Stack
        GenericStackWithMinMaxInO1<Integer> genericStackWithMinMaxInO1 = new GenericStackWithMinMaxInO1<>();

        // Check if the stack is empty
        System.out.println("Is stack empty? " + genericStackWithMinMaxInO1.isEmpty()); // Should print: true

        // Push elements onto the stack
        genericStackWithMinMaxInO1.push(1);
        genericStackWithMinMaxInO1.push(2);
        genericStackWithMinMaxInO1.push(3);
        genericStackWithMinMaxInO1.push(4);
        genericStackWithMinMaxInO1.push(5);

        // Print the stack
        genericStackWithMinMaxInO1.print(); // Should print: 5 4 3 2 1

        // Get the top element of the stack
        System.out.println("Top element: " + genericStackWithMinMaxInO1.top()); // Should print: 5

        // Get the size of the stack
        System.out.println("Stack size: " + genericStackWithMinMaxInO1.size()); // Should print: 5

        // Get the maximum and minimum elements in the stack
        System.out.println("Max element: " + genericStackWithMinMaxInO1.max()); // Should print: 5
        System.out.println("Min element: " + genericStackWithMinMaxInO1.min()); // Should print: 1

        // Pop elements from the stack
        System.out.println("Popped element: " + genericStackWithMinMaxInO1.pop()); // Should print: 5
        System.out.println("Popped element: " + genericStackWithMinMaxInO1.pop()); // Should print: 4

        // Print the stack
        genericStackWithMinMaxInO1.print(); // Should print: 3 2 1

        // Check if the stack is full
        System.out.println("Is stack full? " + genericStackWithMinMaxInO1.isStackFull()); // Should print: false
    }
}
