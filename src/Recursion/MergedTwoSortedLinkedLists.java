package Recursion;

import LinkedList.ListNode;
import LinkedList.SinglyLinkedList;

public class MergedTwoSortedLinkedLists {

    public static ListNode sortedMerge(ListNode list1, ListNode list2) {
        ListNode dummyListNode = new ListNode(0);
        ListNode tail = dummyListNode;
        while (true) {
            if (list1 == null) {
                tail.next = list2;
                break;
            }
            if (list2 == null) {
                tail.next = list1;
                break;
            }
            if (list1.data <= list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        return dummyListNode.next;
    }

    public ListNode sortedMergeRecursive(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.data <= list2.data) {
            list1.next = sortedMergeRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = sortedMergeRecursive(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.head = new ListNode(1);
        list1.head.next = new ListNode(3);
        list1.head.next.next = new ListNode(5);

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.head = new ListNode(2);
        list2.head.next = new ListNode(4);
        list2.head.next.next = new ListNode(6);

        SinglyLinkedList result = new SinglyLinkedList();
        result.head = sortedMerge(list1.head, list2.head);
        System.out.println("Merged list : ");
        result.display();
    }

}
