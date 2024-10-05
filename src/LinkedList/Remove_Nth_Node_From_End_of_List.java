package LinkedList;

/**
 ******************************************************************************************
 ********************    Topics: Remove Nth Node From End of List.     ********************
 ******************************************************************************************

 * Question Source: Linked List, Two Pointers
 * Level: Medium
 *
 * Problem: Given the head of a linked list, remove the nth node from the end of the list
 *          and return its head.
 *
 * Approach:
 * - Use two pointers (fast and slow) that start at the head. Move the fast pointer n steps ahead.
 * - Then move both pointers until the fast pointer reaches the end of the list.
 * - The slow pointer will point to the node before the one to be removed.
 *
 * Example Execution:
 * Given List: 1 -> 2 -> 3 -> 4 -> 5, n = 2
 *
 * 1. Fast pointer moves 2 steps ahead: fast -> 3
 * 2. Move both pointers:
 *    - Now fast -> 5, slow -> 3
 * 3. Slow's next is removed (node 4).
 *
 * Final List: 1 -> 2 -> 3 -> 5
 *
 * Time Complexity: O(L), where L is the length of the list.
 * Space Complexity: O(1), as we use pointers for manipulation.
 */

class RemoveNthListNode {
    int val;
    RemoveNthListNode next;
    RemoveNthListNode(int val) { this.val = val; }
}

class Remove_Nth_Node_From_End_of_List {
    public static RemoveNthListNode removeNthFromEnd(RemoveNthListNode head, int n) {
        // Create a dummy node that points to head
        RemoveNthListNode dummy = new RemoveNthListNode(0);
        dummy.next = head;
        RemoveNthListNode fast = dummy;
        RemoveNthListNode slow = dummy;

        // Move fast pointer n steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Skip the nth node from the end
        slow.next = slow.next.next;

        return dummy.next; // Return the new head
    }
}

// Example to test the removeNthFromEnd method
class Remove_Nth_Node_From_End_of_List_Main {
    public static void main(String[] args) {

        // Construct the linked list: 1 -> 2 -> 3 -> 4 -> 5
        RemoveNthListNode head = new RemoveNthListNode(1);
        head.next = new RemoveNthListNode(2);
        head.next.next = new RemoveNthListNode(3);
        head.next.next.next = new RemoveNthListNode(4);
        head.next.next.next.next = new RemoveNthListNode(5);

        // Remove the 2nd node from the end
        RemoveNthListNode result = Remove_Nth_Node_From_End_of_List.removeNthFromEnd(head, 2);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

/**
 * Key Points:
 * - Two-pointer technique to find the node to remove.
 * - Time Complexity: O(L) — single traversal of the list.
 * - Space Complexity: O(1) — in-place manipulation.
 */
