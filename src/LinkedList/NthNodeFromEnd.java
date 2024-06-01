package LinkedList;

class NthNodeFromEnd {

    private static int nthNodeFromEnd(ListNode head, int n) {

        if (head == null) {
            return -1;
        }
        int index = 0;
        int outputValue = -1;
        while (head.next != null) {
            if (index - n -1 <= 0) {
                outputValue =  head.data;
            }
            head = head.next;
            index++;
        }
        return outputValue;
    }

    public static void main(String[] args) {
        // Example 1.
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        System.out.println(nthNodeFromEnd(head, 4));
    }

}
