package LinkedList;

/**
 * Problem: Given the head of a linked list and a value x, partition it such that all nodes less than x come before
 *          nodes greater than or equal to x. The relative order of the nodes in each of the two partitions should
 *          be preserved.
 *
 * Approach:
 * - We use two pointers to maintain two separate lists: one for nodes less than x and another for nodes greater
 *   than or equal to x.
 * - We iterate over the original list, appending each node to the appropriate list.
 * - After partitioning, we join the two lists and return the new head.
 *
 * Example Execution:
 * Given List: 1 -> 4 -> 3 -> 2 -> 5 -> 2, x = 3
 *
 * 1. Initialize two dummy heads for the two partitions.
 *    Less than x: []
 *    Greater or equal to x: []
 *
 * 2. Traverse the list and append nodes.
 *    After processing 1:
 *    Less than x: [1]
 *    Greater or equal to x: []
 *
 *    After processing 4:
 *    Less than x: [1]
 *    Greater or equal to x: [4]
 *
 *    After processing 3:
 *    Less than x: [1]
 *    Greater or equal to x: [4, 3]
 *
 *    After processing 2:
 *    Less than x: [1, 2]
 *    Greater or equal to x: [4, 3]
 *
 *    After processing 5:
 *    Less than x: [1, 2]
 *    Greater or equal to x: [4, 3, 5]
 *
 *    After processing 2:
 *    Less than x: [1, 2, 2]
 *    Greater or equal to x: [4, 3, 5]
 *
 * 3. Connect the less-than-x list to the greater-or-equal-to-x list.
 *    Final partitioned list: [1 -> 2 -> 2 -> 4 -> 3 -> 5]
 *
 * Time Complexity: O(n), where n is the number of nodes in the list.
 * Space Complexity: O(1), because no extra space is used besides pointers.
 */

class PartitionListListNode {
    int val;
    PartitionListListNode next;
    PartitionListListNode(int val) { this.val = val; }
}

class PartitionList {
    public PartitionListListNode partition(PartitionListListNode head, int x) {
        // Dummy heads for less-than-x and greater-or-equal-to-x partitions
        PartitionListListNode lessDummy = new PartitionListListNode(0);
        PartitionListListNode greaterDummy = new PartitionListListNode(0);

        // Pointers to the current end of each partition
        PartitionListListNode less = lessDummy, greater = greaterDummy;

        // Traverse the list
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        // Ensure the last node in greater partition points to null
        greater.next = null;

        // Connect the less partition to the greater partition
        less.next = greaterDummy.next;

        // Return the head of the new partitioned list
        return lessDummy.next;
    }
}

// Example to test the partition method
class PartitionListMain {
    public static void main(String[] args) {
        PartitionList solution = new PartitionList();

        // Construct the linked list: 1 -> 4 -> 3 -> 2 -> 5 -> 2
        PartitionListListNode head = new PartitionListListNode(1);
        head.next = new PartitionListListNode(4);
        head.next.next = new PartitionListListNode(3);
        head.next.next.next = new PartitionListListNode(2);
        head.next.next.next.next = new PartitionListListNode(5);
        head.next.next.next.next.next = new PartitionListListNode(2);

        // Partition the list around x = 3
        PartitionListListNode result = solution.partition(head, 3);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
