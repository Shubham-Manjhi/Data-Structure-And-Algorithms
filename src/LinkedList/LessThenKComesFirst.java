package LinkedList;

public class LessThenKComesFirst {

    public static Node partition(Node node, int k) {
        Node head = node;
        Node tail = node;

        while (node != null) {
            Node next = node.next;
            if (node.data <= k) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(5);
        head.next.next = new Node(8);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);

        Node result = partition(head, 5);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
