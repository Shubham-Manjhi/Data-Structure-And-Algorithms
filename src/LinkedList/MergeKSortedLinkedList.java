package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList {

    public static Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<Node> queue = new PriorityQueue<Node>(lists.length, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.data < o2.data)
                    return -1;
                else if (o1.data == o2.data)
                    return 0;
                else
                    return 1;
            }
        });

        Node dummy = new Node(0);
        Node tail = dummy;

        for (Node node : lists)
            if (node != null)
                queue.add(node);

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.next = new Node(4);
        list1.next.next = new Node(7);

        Node list2 = new Node(2);
        list2.next = new Node(5);
        list2.next.next = new Node(8);

        Node list3 = new Node(3);
        list3.next = new Node(6);
        list3.next.next = new Node(9);

        Node[] lists = {list1, list2, list3};

        Node result = mergeKLists(lists);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }

}
