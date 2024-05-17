package Stack;

public class A_StackArrayBased {
    private final int maxSize;
    private int top;
    private final int[] stackArray;

    public A_StackArrayBased(int size) {
        top = -1;
        maxSize = size;
        stackArray = new int[maxSize];
    }

    public void push(int value) {
        if(!isStackFull()){
            top++;
            stackArray[top] = value;
        } else {
            System.out.println("Stack is full. Can't push " + value);
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        } else {
            System.out.println("Stack is empty.");
            return -1;
        }
    }

    public int top() {
        if (!isEmpty()) {
            return stackArray[top];
        } else {
            System.out.println("Stack is empty.");
            return -1;
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isStackFull() {
        return (top == maxSize - 1);
    }

    public int size() {
        return top + 1;
    }

    public int max() {
        int max = stackArray[0];
        for (int i = 1; i <= top; i++) {
            if (stackArray[i] > max) {
                max = stackArray[i];
            }
        }
        return max;
    }

    public int min() {
        int min = stackArray[0];
        for (int i = 1; i <= top; i++) {
            if (stackArray[i] < min) {
                min = stackArray[i];
            }
        }
        return min;
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a new Stack with a size of 5
        A_StackArrayBased AStackArrayBased = new A_StackArrayBased(5);

        // Check if the stack is empty
        System.out.println("Is stack empty? " + AStackArrayBased.isEmpty()); // Should print: true

        // Push elements onto the stack
        AStackArrayBased.push(1);
        AStackArrayBased.push(2);
        AStackArrayBased.push(3);
        AStackArrayBased.push(4);
        AStackArrayBased.push(5);

        // Print the stack
        AStackArrayBased.print(); // Should print: 1 2 3 4 5

        // Check if the stack is full
        System.out.println("Is stack full? " + AStackArrayBased.isStackFull()); // Should print: true

        // Get the top element of the stack
        System.out.println("Top element: " + AStackArrayBased.top()); // Should print: 5

        // Get the size of the stack
        System.out.println("Stack size: " + AStackArrayBased.size()); // Should print: 5

        // Get the maximum and minimum elements in the stack
        System.out.println("Max element: " + AStackArrayBased.max()); // Should print: 5
        System.out.println("Min element: " + AStackArrayBased.min()); // Should print: 1

        // Pop elements from the stack
        System.out.println("Popped element: " + AStackArrayBased.pop()); // Should print: 5
        System.out.println("Popped element: " + AStackArrayBased.pop()); // Should print: 4

        // Print the stack
        AStackArrayBased.print(); // Should print: 1 2 3
    }
}
