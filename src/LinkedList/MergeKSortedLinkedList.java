package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.data < o2.data)
                    return -1;
                else if (o1.data == o2.data)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode listNode : lists)
            if (listNode != null)
                queue.add(listNode);

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(7);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(5);
        list2.next.next = new ListNode(8);

        ListNode list3 = new ListNode(3);
        list3.next = new ListNode(6);
        list3.next.next = new ListNode(9);

        ListNode[] lists = {list1, list2, list3};

        ListNode result = mergeKLists(lists);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }

}
