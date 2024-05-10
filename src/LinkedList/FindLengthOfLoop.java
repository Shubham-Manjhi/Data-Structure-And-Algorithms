package LinkedList;

public class FindLengthOfLoop {

    private static int findIfLoopExistsUsingFloyds(Node head) {
        Node fastPtr = head;
        Node slowPtr = head;

        boolean loopExist = false;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                loopExist = true;
                break;
            }
        }

        int length = 0;
        if (loopExist) {
            slowPtr = slowPtr.next;
            while (fastPtr != slowPtr) {
                length++;
                slowPtr = slowPtr.next;
            }
        }
        return length;
    }

}
