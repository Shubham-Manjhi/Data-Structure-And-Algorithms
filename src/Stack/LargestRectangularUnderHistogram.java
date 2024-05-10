package Stack;

import java.util.Stack;

public class LargestRectangularUnderHistogram {

        public static void main(String[] args) {
            // Example array of heights
            int[] h = {1, 2, 3, 4, 5};
            // Print the largest rectangle that can be formed
            System.out.println(largestRectangle(h)); // Should print: 9
        }

        public static long largestRectangle(int[] h) {
            // Stack to hold the indices of the bars
            Stack<Integer> stack = new Stack<>();
            // Variable to hold the maximum area
            int maxArea = 0;
            // Index to traverse the array
            int i = 0;

            // Traverse the array
            while (i < h.length) {
                // If the stack is empty or the current bar is higher than the bar at the top index of the stack
                if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
                    // Push the index onto the stack and move to the next bar
                    stack.push(i++);
                } else {
                    // Pop the top index from the stack
                    int top = stack.pop();
                    // Calculate the area with the popped index as the smallest bar
                    int area = h[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                    // Update the maximum area if necessary
                    maxArea = Math.max(maxArea, area);
                }
            }

            // After traversing the array, calculate the area with the remaining indices in the stack
            while (!stack.isEmpty()) {
                // Pop the top index from the stack
                int top = stack.pop();
                // Calculate the area with the popped index as the smallest bar
                int area = h[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                // Update the maximum area if necessary
                maxArea = Math.max(maxArea, area);
            }

            // Return the maximum area
            return maxArea;
        }
    }