package PriorityQueue;

import java.util.PriorityQueue;

public class MaximizeCapital {
    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        // Min heap to store projects based on capital requirements
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // Max heap to store projects based on profits
        PriorityQueue<int[]> maxProfitHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        // Insert all projects into the min heap
        for (int i = 0; i < profits.length; i++) {
            minCapitalHeap.offer(new int[]{capital[i], profits[i]});
        }

        int availableCapital = initialCapital;
        for (int i = 0; i < numberOfProjects; i++) {
            // Move all projects that can be afforded into the max heap
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= availableCapital) {
                maxProfitHeap.offer(minCapitalHeap.poll());
            }

            // If we can't afford any project, break
            if (maxProfitHeap.isEmpty()) {
                break;
            }

            // Select the project with the highest profit
            availableCapital += maxProfitHeap.poll()[1];
        }

        return availableCapital;
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(findMaximumCapital(new int[]{0, 1, 2}, new int[]{1, 2, 3}, 2, 1));  // Output: 6
    }
}
