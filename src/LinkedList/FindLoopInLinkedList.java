package LinkedList;

/**
 ******************************************************************************************
 ******************** Topics: Linked List Cycle.   ********************
 ******************************************************************************************

 * Question Source: Linked List, Two Pointers
 * Level: Easy
 *
 * Problem: Given a linked list, determine if it has a cycle in it.
 *          A cycle means that a node's next pointer points back to a previous node.
 *
 * Approach:
 * - Use two pointers (slow and fast). Move slow by one step and fast by two steps.
 * - If there is a cycle, the fast pointer will eventually meet the slow pointer.
 * - If the fast pointer reaches the end (null), there is no cycle.
 *
 * Example Execution:
 * Given List: 3 -> 2 -> 0 -> -4
 * - The last node (-4) points back to the second node (2), creating a cycle.
 *
 * Steps:
 * 1. Initialize two pointers at the head.
 * 2. Move slow one step and fast two steps until they meet or fast reaches null.
 * 3. If they meet, return true; otherwise, return false when fast is null.
 *
 * Time Complexity: O(n), where n is the number of nodes.
 * Space Complexity: O(1), as we only use pointers for manipulation.
 */

class LinkedListCycleNode {
    int val;
    LinkedListCycleNode next;
    LinkedListCycleNode(int val) { this.val = val; }
}

class LinkedListCycleChecker {
    public boolean hasCycle(LinkedListCycleNode head) {
        // Initialize two pointers
        LinkedListCycleNode slow = head;
        LinkedListCycleNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow pointer one step
            fast = fast.next.next;     // Move fast pointer two steps

            // If slow and fast meet, there is a cycle
            if (slow == fast) {
                return true;
            }
        }

        return false; // No cycle found
    }
}

// Example to test the hasCycle method
class LinkedListCycleCheckerMain {
    public static void main(String[] args) {
        LinkedListCycleChecker checker = new LinkedListCycleChecker();

        // Construct a cycle linked list: 3 -> 2 -> 0 -> -4 -> 2 (cycle back to 2)
        LinkedListCycleNode head = new LinkedListCycleNode(3);
        LinkedListCycleNode node2 = new LinkedListCycleNode(2);
        LinkedListCycleNode node0 = new LinkedListCycleNode(0);
        LinkedListCycleNode nodeNeg4 = new LinkedListCycleNode(-4);

        head.next = node2;
        node2.next = node0;
        node0.next = nodeNeg4;
        nodeNeg4.next = node2; // Creates a cycle

        // Check for cycle
        boolean result = checker.hasCycle(head);
        System.out.println("Has Cycle: " + result);
    }
}

/**
 * Key Points:
 * - Two-pointer technique to detect cycles.
 * - Time Complexity: O(n) — single traversal of the list.
 * - Space Complexity: O(1) — in-place manipulation.
 */