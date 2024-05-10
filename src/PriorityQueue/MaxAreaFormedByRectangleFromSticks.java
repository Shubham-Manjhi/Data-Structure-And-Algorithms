package PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxAreaFormedByRectangleFromSticks {
    private static final long MOD = 1000000000L;

    public static void main(String[] args) {
        int[][] testCases = {
            {2, 2, 4, 4, 5, 5},
            {3, 3, 5, 8},
            {2, 2, 2, 2, 2, 2},
            {1, 1, 1, 1, 1, 1},
            {1, 2, 3, 4, 5, 6},
            {6, 6, 5, 5, 4, 4},
            {10, 10, 9, 9, 8, 8},
            {1, 1, 2, 2, 3, 3},
            {6, 6, 7, 7, 8, 8},
            {10, 10, 10, 10}
        };

        for (int[] testCase : testCases) {
            System.out.println(maxArea(testCase));
        }
    }

    public static long maxArea(int[] sideLengths) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int sideLength : sideLengths) {
            queue.offer(sideLength);
        }

        long area = 0;
        while (queue.size() >= 2) {
            int a = queue.poll();
            int b = queue.peek();
            if (a == b || a == b + 1) {
                queue.poll();
                    area = (area + (long) a * b) % MOD;
            } else {
                queue.offer(a - 1);
            }
        }

        return area;
    }
}
