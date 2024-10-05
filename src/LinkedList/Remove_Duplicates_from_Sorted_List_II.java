package LinkedList;

/**
 ******************************************************************************************
 ******************** Topics: Remove Duplicates from Sorted List II.   ********************
 ******************************************************************************************

 * Question Source: Linked List, Two Pointers
 * Level: Medium
 *
 * Problem: Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
 *          leaving only distinct numbers from the original list.
 *
 * Approach:
 * - Use a dummy node to handle cases where the head itself has duplicates.
 * - Traverse the list, and for each node, check if it has duplicates. If duplicates are found,
 *   skip all nodes with that value.
 * - Connect non-duplicate nodes to form the resulting list.
 *
 * Example Execution:
 * Given List: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
 *
 * 1. Initialize a dummy node.
 *    Current List: [dummy] -> 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
 *
 * 2. Traverse the list:
 *    a. 1 has no duplicate, include it in the result.
 *    b. 2 has no duplicate, include it in the result.
 *    c. 3 has duplicates, skip all 3's.
 *    d. 4 has duplicates, skip all 4's.
 *    e. 5 has no duplicate, include it in the result.
 *
 * 3. Final Result: 1 -> 2 -> 5
 *
 * Time Complexity: O(n), where n is the number of nodes.
 * Space Complexity: O(1), as we only use pointers for manipulation.
 */

class DeleteDuplicatesListNode {
    int val;
    DeleteDuplicatesListNode next;
    DeleteDuplicatesListNode(int val) { this.val = val; }
}

public class Remove_Duplicates_from_Sorted_List_II {
    public static DeleteDuplicatesListNode deleteDuplicates(DeleteDuplicatesListNode head) {
        // Dummy node to handle edge cases where head is part of duplicates
        DeleteDuplicatesListNode dummy = new DeleteDuplicatesListNode(0);
        dummy.next = head;

        // Pointer to traverse the list
        DeleteDuplicatesListNode prev = dummy;

        while (head != null) {
            // If the current node has duplicates, skip all nodes with the same value
            if (head.next != null && head.val == head.next.val) {
                // Skip all duplicates
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                // Move prev's next to head's next, skipping duplicates
                prev.next = head.next;
            } else {
                // No duplicates, move prev pointer
                prev = prev.next;
            }
            // Move to the next node
            head = head.next;
        }

        return dummy.next;
    }
}

// Example to test the deleteDuplicates method
class DeleteDuplicatesListNodeMain {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Construct the linked list: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        DeleteDuplicatesListNode head = new DeleteDuplicatesListNode(1);
        head.next = new DeleteDuplicatesListNode(2);
        head.next.next = new DeleteDuplicatesListNode(3);
        head.next.next.next = new DeleteDuplicatesListNode(3);
        head.next.next.next.next = new DeleteDuplicatesListNode(4);
        head.next.next.next.next.next = new DeleteDuplicatesListNode(4);
        head.next.next.next.next.next.next = new DeleteDuplicatesListNode(5);

        // Remove duplicates
        DeleteDuplicatesListNode result = Remove_Duplicates_from_Sorted_List_II.deleteDuplicates(head);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

/**
 * Key Points:
 * - Duplicates are skipped by checking adjacent nodes.
 * - Time Complexity: O(n) — single traversal of the list.
 * - Space Complexity: O(1) — in-place manipulation.
 */
