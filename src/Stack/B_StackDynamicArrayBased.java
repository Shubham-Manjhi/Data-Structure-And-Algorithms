package Stack;

import java.util.ArrayList;

public class B_StackDynamicArrayBased {
    private int top;
    private ArrayList<Integer> stackArray;

    public B_StackDynamicArrayBased() {
        stackArray = new ArrayList<>();
        top = -1;
    }

    public void push(int value) {
        top++;
        stackArray.add(value);
    }

    public int pop() {
        if (!isEmpty()) {
            int value = stackArray.get(top);
            stackArray.remove(top);
            top--;
            return value;
        } else {
            System.out.println("Stack is empty.");
            return -1;
        }
    }

    public int top() {
        if (!isEmpty()) {
            return stackArray.get(top);
        } else {
            System.out.println("Stack is empty.");
            return -1;
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int size() {
        return top + 1;
    }

    public int max() {
        int max = stackArray.get(0);
        for (int i = 1; i <= top; i++) {
            if (stackArray.get(i) > max) {
                max = stackArray.get(i);
            }
        }
        return max;
    }

    public int min() {
        int min = stackArray.get(0);
        for (int i = 1; i <= top; i++) {
            if (stackArray.get(i) < min) {
                min = stackArray.get(i);
            }
        }
        return min;
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a new Stack
        B_StackDynamicArrayBased BStackDynamicArrayBased = new B_StackDynamicArrayBased();

        // Check if the stack is empty
        System.out.println("Is stack empty? " + BStackDynamicArrayBased.isEmpty()); // Should print: true

        // Push elements onto the stack
        BStackDynamicArrayBased.push(1);
        BStackDynamicArrayBased.push(2);
        BStackDynamicArrayBased.push(3);
        BStackDynamicArrayBased.push(4);
        BStackDynamicArrayBased.push(5);

        // Print the stack
        BStackDynamicArrayBased.print(); // Should print: 1 2 3 4 5

        // Get the top element of the stack
        System.out.println("Top element: " + BStackDynamicArrayBased.top()); // Should print: 5

        // Get the size of the stack
        System.out.println("Stack size: " + BStackDynamicArrayBased.size()); // Should print: 5

        // Get the maximum and minimum elements in the stack
        System.out.println("Max element: " + BStackDynamicArrayBased.max()); // Should print: 5
        System.out.println("Min element: " + BStackDynamicArrayBased.min()); // Should print: 1

        // Pop elements from the stack
        System.out.println("Popped element: " + BStackDynamicArrayBased.pop()); // Should print: 5
        System.out.println("Popped element: " + BStackDynamicArrayBased.pop()); // Should print: 4

        // Print the stack
        BStackDynamicArrayBased.print(); // Should print: 1 2 3
    }
}
