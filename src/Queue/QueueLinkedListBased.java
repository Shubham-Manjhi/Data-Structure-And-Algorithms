package Queue;

import java.util.LinkedList;

public class QueueLinkedListBased
{
    private LinkedList<Integer> queue;

    public QueueLinkedListBased() {
        queue = new LinkedList<>();
    }

    public void enqueue(int value) {
        queue.addLast(value);
    }

    public int dequeue() {
        if (!isEmpty()) {
            return queue.removeFirst();
        } else {
            System.out.println("Queue is empty. Can't dequeue");
            return -1;
        }
    }

    public int front() {
        return queue.getFirst();
    }

    public int queueSize() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int max() {
        return queue.stream().max(Integer::compare).orElse(-1);
    }

    public int min() {
        return queue.stream().min(Integer::compare).orElse(-1);
    }

    public void print() {
        System.out.println(queue);
    }

    public static void main(String[] args) {
        // Create a new Queue
        QueueLinkedListBased myQueueLinkedListBased = new QueueLinkedListBased();

        // Enqueue some values
        myQueueLinkedListBased.enqueue(10);
        myQueueLinkedListBased.enqueue(20);
        myQueueLinkedListBased.enqueue(30);
        myQueueLinkedListBased.enqueue(40);
        myQueueLinkedListBased.enqueue(50);

        // Print the queue - should print "[10, 20, 30, 40, 50]"
        myQueueLinkedListBased.print();

        // Dequeue a value - should return 10
        System.out.println("Dequeued: " + myQueueLinkedListBased.dequeue());

        // Print the queue - should print "[20, 30, 40, 50]"
        myQueueLinkedListBased.print();

        // Get the front value - should return 20
        System.out.println("Front: " + myQueueLinkedListBased.front());

        // Get the queue size - should return 4
        System.out.println("Queue size: " + myQueueLinkedListBased.queueSize());

        // Check if the queue is empty - should return false
        System.out.println("Is empty: " + myQueueLinkedListBased.isEmpty());

        // Get the max value - should return 50
        System.out.println("Max: " + myQueueLinkedListBased.max());

        // Get the min value - should return 20
        System.out.println("Min: " + myQueueLinkedListBased.min());
    }
}
