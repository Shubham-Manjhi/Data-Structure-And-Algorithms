package LinkedList;

public class ReverseKElements {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        int count = 0;

        // Check for k nodes
        ListNode check = head;
        int checkCount = 0;
        while (check != null && checkCount < k) {
            check = check.next;
            checkCount++;
        }

        // If we have k nodes then reverse them
        if (checkCount == k) {
            while (current != null && count < k) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }

            if (next != null) {
                head.next = reverseKGroup(next, k);
            }

            return prev;
        } else {
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode reversedList = reverseKGroup(head, 2);
        while (reversedList != null) {
            System.out.print(reversedList.data + " ");
            reversedList = reversedList.next;
        }
        // 1 2 3 4 5
    }

}
