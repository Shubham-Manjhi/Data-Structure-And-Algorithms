package PriorityQueue;

import java.util.PriorityQueue;
import java.util.Collections;

public class KthSmallest {
    // Priority queue to store the smallest 'k' elements
    private PriorityQueue<Integer> maxHeap;
    private final int k;

    // Constructor
    public KthSmallest(int k, int[] nums) {
        this.k = k;
        // Initialize the max heap
        maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int num : nums) {
            add(num);
        }
    }

    // Function to add a new number 'val' to the stream
    public int add(int val) {
        if (maxHeap.size() < k) {
            // If less than 'k' numbers have been added to the stream, add the new number directly to the queue
            maxHeap.offer(val);
        } else if (maxHeap.peek() > val) {
            // If the new number is smaller than the largest (top) number in the heap, remove the largest number from heap and add the new number
            maxHeap.poll();
            maxHeap.offer(val);
        }
        // The 'peek' function returns the largest number in the heap, which represents the Kth smallest number at any given time
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {10, 20, 11, 70, 50, 40, 100, 5};
        KthSmallest kthSmallest = new KthSmallest(k, arr);
        System.out.println(kthSmallest.add(10));  // returns 10
        System.out.println(kthSmallest.add(20));  // returns 10
        System.out.println(kthSmallest.add(11));  // returns 10
        System.out.println(kthSmallest.add(70));  // returns 10
        System.out.println(kthSmallest.add(50));  // returns 11
        System.out.println(kthSmallest.add(40));  // returns 11
        System.out.println(kthSmallest.add(100)); // returns 11
        System.out.println(kthSmallest.add(5));   // returns 10
    }
}
