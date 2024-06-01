package LinkedList;

public class LinkedListSorting {

    static ListNode sortedMerge(ListNode a, ListNode b) {
        ListNode result = null;
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

    static ListNode splitList(ListNode h) {
        ListNode fast = h, slow = h;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    static ListNode mergeSort(ListNode h) {
        if (h == null || h.next == null) {
            return h;
        }

        ListNode mid = splitList(h);
        ListNode left = mergeSort(h);
        ListNode right = mergeSort(mid);

        return sortedMerge(left, right);
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.head = new ListNode(5);
        list.head.next = new ListNode(3);
        list.head.next.next = new ListNode(2);
        list.head.next.next.next = new ListNode(4);
        list.head.next.next.next.next = new ListNode(1);

        ListNode sortedList = LinkedListSorting.mergeSort(list.head);
        while (sortedList != null) {
            System.out.print(sortedList.data + " ");
            sortedList = sortedList.next;
        }
    }

}
