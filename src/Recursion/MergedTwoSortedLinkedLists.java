package Recursion;

import LinkedList.Node;
import LinkedList.SinglyLinkedList;

public class MergedTwoSortedLinkedLists {

    public static Node sortedMerge(Node list1, Node list2) {
        Node dummyNode = new Node(0);
        Node tail = dummyNode;
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
        return dummyNode.next;
    }

    public Node sortedMergeRecursive(Node list1, Node list2) {
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
        list1.head = new Node(1);
        list1.head.next = new Node(3);
        list1.head.next.next = new Node(5);

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.head = new Node(2);
        list2.head.next = new Node(4);
        list2.head.next.next = new Node(6);

        SinglyLinkedList result = new SinglyLinkedList();
        result.head = sortedMerge(list1.head, list2.head);
        System.out.println("Merged list : ");
        result.display();
    }

}
