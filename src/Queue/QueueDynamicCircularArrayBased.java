package Queue;

public class QueueDynamicCircularArrayBased {
    private int maxSize;
    private int front;
    private int rear;
    private int queueSize;
    private int[] queueArray;

    public QueueDynamicCircularArrayBased(int size) {
        maxSize = size;
        front = 0;
        rear = -1;
        queueSize = 0;
        queueArray = new int[maxSize];
    }

    public void enqueue(int value) {
        if (isFull()) {
            // Double the size of the array if it's full
            int[] newArray = new int[maxSize * 2];
            for (int i = 0; i < maxSize; i++) {
                newArray[i] = queueArray[(front + i) % maxSize];
            }
            front = 0;
            rear = maxSize - 1;
            queueArray = newArray;
            maxSize *= 2;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = value;
        queueSize++;
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
        QueueDynamicCircularArrayBased myQueueDynamicCircularArrayBased = new QueueDynamicCircularArrayBased(5);

        // Enqueue some values
        myQueueDynamicCircularArrayBased.enqueue(10);
        myQueueDynamicCircularArrayBased.enqueue(20);
        myQueueDynamicCircularArrayBased.enqueue(30);
        myQueueDynamicCircularArrayBased.enqueue(40);
        myQueueDynamicCircularArrayBased.enqueue(50);

        // Try to enqueue another value - should print "Queue is full. Can't enqueue 60"
        myQueueDynamicCircularArrayBased.enqueue(60);

        // Print the queue - should print "10 20 30 40 50"
        myQueueDynamicCircularArrayBased.print();

        // Dequeue a value - should return 10
        System.out.println("Dequeued: " + myQueueDynamicCircularArrayBased.dequeue());

        // Print the queue - should print "20 30 40 50"
        myQueueDynamicCircularArrayBased.print();

        // Get the front value - should return 20
        System.out.println("Front: " + myQueueDynamicCircularArrayBased.front());

        // Get the queue size - should return 4
        System.out.println("Queue size: " + myQueueDynamicCircularArrayBased.queueSize());

        // Check if the queue is empty - should return false
        System.out.println("Is empty: " + myQueueDynamicCircularArrayBased.isEmpty());

        // Check if the queue is full - should return false
        System.out.println("Is full: " + myQueueDynamicCircularArrayBased.isFull());

        // Get the max value - should return 50
        System.out.println("Max: " + myQueueDynamicCircularArrayBased.max());

        // Get the min value - should return 20
        System.out.println("Min: " + myQueueDynamicCircularArrayBased.min());
    }
}
