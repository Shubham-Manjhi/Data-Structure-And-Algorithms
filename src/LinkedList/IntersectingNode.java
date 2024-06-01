package LinkedList;

public class IntersectingNode {

    static int getNodeCount(ListNode listNode) {
        ListNode current = listNode;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    static ListNode getIntersectionNode(int d, ListNode listNode1, ListNode listNode2) {
        ListNode current1 = listNode1;
        ListNode current2 = listNode2;

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

    static ListNode findIntersection(ListNode head1, ListNode head2) {
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
        list.head = new ListNode(3);
        list.head.next = new ListNode(6);
        list.head.next.next = new ListNode(9);
        list.head.next.next.next = new ListNode(15);
        list.head.next.next.next.next = new ListNode(30);

        // creating second linked list
        ListNode head2 = new ListNode(10);
        head2.next = new ListNode(15);
        head2.next.next = new ListNode(30);

        ListNode intersectingListNode = IntersectingNode.findIntersection(list.head, head2);

        System.out.println("The node of intersection is " + intersectingListNode.data);
    }

}
