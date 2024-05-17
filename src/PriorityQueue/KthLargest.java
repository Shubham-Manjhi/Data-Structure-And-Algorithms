package PriorityQueue;

import java.util.PriorityQueue;

public class KthLargest {
    // Priority queue to store the top 'k' elements
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    // Constructor
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    // Function to add a new number 'val' to the stream
    public int add(int val) {
        if (minHeap.size() < k) {
            // If less than 'k' numbers have been added to the stream, add the new number directly to the queue
            minHeap.offer(val);
        } else if (minHeap.peek() < val) {
            // If the new number is larger than the smallest (top) number in the heap, remove the smallest number from heap and add the new number
            minHeap.poll();
            minHeap.offer(val);
        }
        // The 'peek' function returns the smallest number in the heap, which represents the Kth largest number at any given time
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int k = 2;
        int[] arr = {2, 5, 1, 7, 9};
        KthLargest kthLargest = new KthLargest(k, arr);

        System.out.println(kthLargest.minHeap.peek());


    }
}
