package LinkedList;

public class MiddleElement {

    static void printMiddle(ListNode head) {
        ListNode slow_ptr = head;
        ListNode fast_ptr = head;
        if (head != null) {
            while (fast_ptr != null && fast_ptr.next != null) {
                fast_ptr = fast_ptr.next.next;
                slow_ptr = slow_ptr.next;
            }
            System.out.println("The middle element is [" + slow_ptr.data + "]");
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();
        for (int i=5; i>0; --i) {
            llist.add(i);
        }
        printMiddle(llist.head);

    }

}
