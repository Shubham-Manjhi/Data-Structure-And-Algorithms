package Queue;

public class QueueCircularArrayBased {
    private int maxSize;
    private int front;
    private int rear;
    private int queueSize;
    private int[] queueArray;

    public QueueCircularArrayBased(int size) {
        maxSize = size;
        front = 0;
        rear = -1;
        queueSize = 0;
        queueArray = new int[maxSize];
    }

    public void enqueue(int value) {
        if (!isFull()) {
            rear = (rear + 1) % maxSize;
            queueArray[rear] = value;
            queueSize++;
        } else {
            System.out.println("Queue is full. Can't enqueue " + value);
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            int temp = queueArray[front];
            front = (front + 1) % maxSize;
            queueSize--;
            return temp;
        } else {
            System.out.println("Queue is empty. Can't dequeue");
            return -1;
        }
    }

    public int front() {
        return queueArray[front];
    }

    public int queueSize() {
        return queueSize;
    }

    public boolean isEmpty() {
        return (queueSize == 0);
    }

    public boolean isFull() {
        return (queueSize == maxSize);
    }

    public int max() {
        int max = queueArray[front];
        for(int i=0; i<queueSize; i++) {
            if(queueArray[(front+i)%maxSize] > max)
                max = queueArray[(front+i)%maxSize];
        }
        return max;
    }

    public int min() {
        int min = queueArray[front];
        for(int i=0; i<queueSize; i++) {
            if(queueArray[(front+i)%maxSize] < min)
                min = queueArray[(front+i)%maxSize];
        }
        return min;
    }

    public void print() {
        for(int i=0; i<queueSize; i++) {
            System.out.print(queueArray[(front+i)%maxSize] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a new Queue with a maximum size of 5
        QueueCircularArrayBased myQueueCircularArrayBased = new QueueCircularArrayBased(5);

        // Enqueue some values
        myQueueCircularArrayBased.enqueue(10);
        myQueueCircularArrayBased.enqueue(20);
        myQueueCircularArrayBased.enqueue(30);
        myQueueCircularArrayBased.enqueue(40);
        myQueueCircularArrayBased.enqueue(50);

        // Try to enqueue another value - should print "Queue is full. Can't enqueue 60"
        myQueueCircularArrayBased.enqueue(60);

        // Print the queue - should print "10 20 30 40 50"
        myQueueCircularArrayBased.print();

        // Dequeue a value - should return 10
        System.out.println("Dequeued: " + myQueueCircularArrayBased.dequeue());

        // Print the queue - should print "20 30 40 50"
        myQueueCircularArrayBased.print();

        // Get the front value - should return 20
        System.out.println("Front: " + myQueueCircularArrayBased.front());

        // Get the queue size - should return 4
        System.out.println("Queue size: " + myQueueCircularArrayBased.queueSize());

        // Check if the queue is empty - should return false
        System.out.println("Is empty: " + myQueueCircularArrayBased.isEmpty());

        // Check if the queue is full - should return false
        System.out.println("Is full: " + myQueueCircularArrayBased.isFull());

        // Get the max value - should return 50
        System.out.println("Max: " + myQueueCircularArrayBased.max());

        // Get the min value - should return 20
        System.out.println("Min: " + myQueueCircularArrayBased.min());
    }
}