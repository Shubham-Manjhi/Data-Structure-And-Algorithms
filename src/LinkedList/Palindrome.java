package LinkedList;

import java.util.Stack;

public class Palindrome {

    static boolean isPalindrome(Node head) {
        Node slow = head;
        boolean ispalin = true;
        Stack<Integer> stack = new Stack<Integer>();

        while (slow != null) {
            stack.push(slow.data);
            slow = slow.next;
        }

        while (head != null) {
            int i = stack.pop();
            if (head.data == i) {
                ispalin = true;
            } else {
                ispalin = false;
                break;
            }
            head = head.next;
        }
        return ispalin;
    }

    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();
        llist.head = new Node(1);
        llist.head.next = new Node(2);
        llist.head.next.next = new Node(3);
        llist.head.next.next.next = new Node(2);
        llist.head.next.next.next.next = new Node(1);

        System.out.println(Palindrome.isPalindrome(llist.head));
    }

}
