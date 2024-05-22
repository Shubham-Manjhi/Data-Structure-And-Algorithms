package LinkedList;

public class LessThenKComesFirst {

    public static ListNode partition(ListNode listNode, int k) {
        ListNode head = listNode;
        ListNode tail = listNode;

        while (listNode != null) {
            ListNode next = listNode.next;
            if (listNode.data <= k) {
                listNode.next = head;
                head = listNode;
            } else {
                tail.next = listNode;
                tail = listNode;
            }
            listNode = next;
        }
        tail.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);

        ListNode result = partition(head, 5);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}
