package LinkedList;

public class ReverseKElements {

    public static Node reverseKGroup(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;
        int count = 0;

        // Check for k nodes
        Node check = head;
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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        Node reversedList = reverseKGroup(head, 2);
        while (reversedList != null) {
            System.out.print(reversedList.data + " ");
            reversedList = reversedList.next;
        }
        // 1 2 3 4 5
    }

}
