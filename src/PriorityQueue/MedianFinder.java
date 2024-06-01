package PriorityQueue;

import java.util.PriorityQueue;
import java.util.Comparator;

public class MedianFinder {
    // Max heap to store the smaller half elements
    private final PriorityQueue<Integer> small = new PriorityQueue<>(Comparator.reverseOrder());
    // Min heap to store the larger half elements
    private final PriorityQueue<Integer> large = new PriorityQueue<>();

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        // Add to the appropriate heap
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
        } else {
            large.offer(num);
        }

        // Balance the heaps
        if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        } else if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }

    public Double findMedian() {
        if (small.isEmpty() || large.isEmpty()) {
            return null;
        }
        if (small.size() > large.size()) {
            return small.peek().doubleValue();
        } else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
    }
}
