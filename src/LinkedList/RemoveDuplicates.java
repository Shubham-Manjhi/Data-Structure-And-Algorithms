package LinkedList;

import java.util.HashSet;

public class RemoveDuplicates {

    static void removeDuplicates(Node head) {
        HashSet<Integer> hs = new HashSet<>();
        Node current = head;
        Node prev = null;
        while (current != null) {
            int curval = current.data;
            if (hs.contains(curval)) {
                prev.next = current.next;
            } else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.head = new Node(10);
        list.head.next = new Node(12);
        list.head.next.next = new Node(11);
        list.head.next.next.next = new Node(11);
        list.head.next.next.next.next = new Node(12);
        list.head.next.next.next.next.next = new Node(11);
        list.head.next.next.next.next.next.next = new Node(10);

        System.out.println("Linked List before removing duplicates :");
        list.display();

        RemoveDuplicates.removeDuplicates(list.head);

        System.out.println("\nLinked List after removing duplicates :");
        list.display();
    }

}
