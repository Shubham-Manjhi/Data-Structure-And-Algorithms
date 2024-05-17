package LinkedList;

public class LinkedListSorting {

    static Node sortedMerge(Node a, Node b) {
        Node result = null;
        if (a == null)
            return b;
        if (b == null)
            return a;

        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    static Node splitList(Node h) {
        Node fast = h, slow = h;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow.next;
        slow.next = null;
        return mid;
    }

    static Node mergeSort(Node h) {
        if (h == null || h.next == null) {
            return h;
        }

        Node mid = splitList(h);
        Node left = mergeSort(h);
        Node right = mergeSort(mid);

        return sortedMerge(left, right);
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.head = new Node(5);
        list.head.next = new Node(3);
        list.head.next.next = new Node(2);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(1);

        Node sortedList = LinkedListSorting.mergeSort(list.head);
        while (sortedList != null) {
            System.out.print(sortedList.data + " ");
            sortedList = sortedList.next;
        }
    }

}
