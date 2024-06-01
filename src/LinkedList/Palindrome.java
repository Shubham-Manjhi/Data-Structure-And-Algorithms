package LinkedList;

import java.util.Stack;

public class Palindrome {

    static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
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
        llist.head = new ListNode(1);
        llist.head.next = new ListNode(2);
        llist.head.next.next = new ListNode(3);
        llist.head.next.next.next = new ListNode(2);
        llist.head.next.next.next.next = new ListNode(1);

        System.out.println(Palindrome.isPalindrome(llist.head));
    }

}
