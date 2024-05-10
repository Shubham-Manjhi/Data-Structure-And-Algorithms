package LinkedList;

class NthNodeFromEnd {

    private static int nthNodeFromEnd(Node head, int n) {

        if (head == null) {
            return -1;
        }
        int index = 0;
        int outputValue = -1;
        while (head.next != null) {
            if (index - n -1 <= 0) {
                outputValue =  head.data;
            }
            head = head.next;
            index++;
        }
        return outputValue;
    }

    public static void main(String[] args) {
        // Example 1.
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);
        System.out.println(nthNodeFromEnd(head, 4));
    }

}
