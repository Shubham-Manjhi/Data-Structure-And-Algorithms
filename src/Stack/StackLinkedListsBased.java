package Stack;

import java.util.LinkedList;

public class StackLinkedListsBased {
    private LinkedList<Integer> stackList;

    public StackLinkedListsBased() {
        stackList = new LinkedList<>();
    }

    public void push(int value) {
        stackList.addFirst(value);
    }

    public int pop() {
        if (!isEmpty()) {
            return stackList.removeFirst();
        } else {
            System.out.println("Stack is empty.");
            return -1;
        }
    }

    public int top() {
        if (!isEmpty()) {
            return stackList.getFirst();
        } else {
            System.out.println("Stack is empty.");
            return -1;
        }
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public int size() {
        return stackList.size();
    }

    public int max() {
        if (!isEmpty()) {
            return stackList.stream().max(Integer::compare).get();
        } else {
            System.out.println("Stack is empty.");
            return -1;
        }
    }

    public int min() {
        if (!isEmpty()) {
            return stackList.stream().min(Integer::compare).get();
        } else {
            System.out.println("Stack is empty.");
            return -1;
        }
    }

    public void print() {
        stackList.forEach(value -> System.out.print(value + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a new Stack
        StackLinkedListsBased stackLinkedListsBased = new StackLinkedListsBased();

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stackLinkedListsBased.isEmpty()); // Should print: true

        // Push elements onto the stack
        stackLinkedListsBased.push(1);
        stackLinkedListsBased.push(2);
        stackLinkedListsBased.push(3);
        stackLinkedListsBased.push(4);
        stackLinkedListsBased.push(5);

        // Print the stack
        stackLinkedListsBased.print(); // Should print: 5 4 3 2 1

        // Get the top element of the stack
        System.out.println("Top element: " + stackLinkedListsBased.top()); // Should print: 5

        // Get the size of the stack
        System.out.println("Stack size: " + stackLinkedListsBased.size()); // Should print: 5

        // Get the maximum and minimum elements in the stack
        System.out.println("Max element: " + stackLinkedListsBased.max()); // Should print: 5
        System.out.println("Min element: " + stackLinkedListsBased.min()); // Should print: 1

        // Pop elements from the stack
        System.out.println("Popped element: " + stackLinkedListsBased.pop()); // Should print: 5
        System.out.println("Popped element: " + stackLinkedListsBased.pop()); // Should print: 4

        // Print the stack
        stackLinkedListsBased.print(); // Should print: 3 2 1
    }
}
