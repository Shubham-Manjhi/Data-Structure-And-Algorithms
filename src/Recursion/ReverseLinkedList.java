package Recursion;

import LinkedList.Node;

public class ReverseLinkedList {


    public static Node reverseRecursive(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node rest = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return rest;
    }

    public static void reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);

        Node headReversedRecursive = reverseRecursive(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}
