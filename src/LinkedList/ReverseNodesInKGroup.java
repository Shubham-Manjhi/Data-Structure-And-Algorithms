package LinkedList;

/**
 ******************************************************************************************
 ******************** Topics: Reverse Nodes in k-Group.   ********************
 ******************************************************************************************

 * Question Source: Linked List
 * Level: Hard
 *
 * Problem: Given a linked list, reverse the nodes of the list k at a time, and return the
 *          modified list. k is a positive integer and is less than or equal to the length
 *          of the list. If the number of nodes is not a multiple of k, then the last nodes
 *          should remain in their original order.
 *
 * Approach:
 * 1. Iterate through the list to count k nodes.
 * 2. Reverse the nodes within the group of k, and connect them with the rest of the list.
 * 3. If the remaining nodes are fewer than k, leave them as is.
 *
 * Example Execution:
 * List: [1 -> 2 -> 3 -> 4 -> 5], k = 2
 * After reverse: [2 -> 1 -> 4 -> 3 -> 5]
 *
 * Time Complexity: O(n), where n is the length of the list.
 * Space Complexity: O(1), for iterative in-place reversal.
 */

class ReverseNodesInKGroupListNode {
    int val;
    ReverseNodesInKGroupListNode next;
    ReverseNodesInKGroupListNode(int x) { val = x; }
}

class ReverseNodesInKGroup {
    public ReverseNodesInKGroupListNode reverseKGroup(ReverseNodesInKGroupListNode head, int k) {
        // Create a dummy node to simplify edge cases
        ReverseNodesInKGroupListNode dummy = new ReverseNodesInKGroupListNode(0);
        dummy.next = head;

        // Initialize pointers
        ReverseNodesInKGroupListNode groupPrev = dummy;

        while (true) {
            // Find the kth node
            ReverseNodesInKGroupListNode kth = getKthNode(groupPrev, k);
            if (kth == null) break; // End if less than k nodes remain

            // Start reversing the k-group
            ReverseNodesInKGroupListNode groupNext = kth.next;
            ReverseNodesInKGroupListNode prev = kth.next;
            ReverseNodesInKGroupListNode curr = groupPrev.next;

            // Reverse k nodes
            while (curr != groupNext) {
                ReverseNodesInKGroupListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            // Update the pointers for the next group
            ReverseNodesInKGroupListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }

        return dummy.next;
    }

    // Helper function to get the kth node from the start
    private ReverseNodesInKGroupListNode getKthNode(ReverseNodesInKGroupListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}

// Example to test the reverseKGroup method
class ReverseNodesInKGroupMain {
    public static void main(String[] args) {
        // Construct a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ReverseNodesInKGroupListNode head = new ReverseNodesInKGroupListNode(1);
        head.next = new ReverseNodesInKGroupListNode(2);
        head.next.next = new ReverseNodesInKGroupListNode(3);
        head.next.next.next = new ReverseNodesInKGroupListNode(4);
        head.next.next.next.next = new ReverseNodesInKGroupListNode(5);

        // Reverse the nodes in groups of k = 2
        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();
        ReverseNodesInKGroupListNode result = solution.reverseKGroup(head, 2);

        // Print the reversed list
        ReverseNodesInKGroupListNode temp = result;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        // Output should be: 2 1 4 3 5
    }
}

/**
 * Key Points:
 * - Reverse nodes in k-groups, handle incomplete groups.
 * - Time Complexity: O(n) — linear traversal for all nodes.
 * - Space Complexity: O(1) — no additional space except pointers.
 */
