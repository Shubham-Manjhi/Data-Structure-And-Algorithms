package LinkedList;

public class IntersectingNode {

    static int getNodeCount(Node node) {
        Node current = node;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    static Node getIntersectionNode(int d, Node node1, Node node2) {
        Node current1 = node1;
        Node current2 = node2;

        for (int i = 0; i < d; i++) {
            if (current1 == null) {
                return null;
            }
            current1 = current1.next;
        }

        while (current1 != null && current2 != null) {
            if (current1.data == current2.data) {
                return current1;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return null;
    }

    static Node findIntersection(Node head1, Node head2) {
        int c1 = getNodeCount(head1);
        int c2 = getNodeCount(head2);
        int d;

        if (c1 > c2) {
            d = c1 - c2;
            return getIntersectionNode(d, head1, head2);
        } else {
            d = c2 - c1;
            return getIntersectionNode(d, head2, head1);
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // creating first linked list
        list.head = new Node(3);
        list.head.next = new Node(6);
        list.head.next.next = new Node(9);
        list.head.next.next.next = new Node(15);
        list.head.next.next.next.next = new Node(30);

        // creating second linked list
        Node head2 = new Node(10);
        head2.next = new Node(15);
        head2.next.next = new Node(30);

        Node intersectingNode = IntersectingNode.findIntersection(list.head, head2);

        System.out.println("The node of intersection is " + intersectingNode.data);
    }

}
