package LinkedList;

public class FindLoopInLinkedList {

    // Three Approach - Sorting, HashMap, BrutForce, Floyds
    // We are going to implement Floyds

    private static boolean findIfLoopExistsUsingFloyds(Node head) {
        Node fastPtr = head;
        Node slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) return true;
        }
        return false;
    }
}
