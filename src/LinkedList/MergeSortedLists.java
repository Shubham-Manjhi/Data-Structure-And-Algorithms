package LinkedList;

/**
 ******************************************************************************************
 ******************** Topics: Merge Two Sorted Lists.   ********************
 ******************************************************************************************

 * Question Source: Linked List, Two Pointers
 * Level: Easy
 *
 * Problem: Merge two sorted linked lists into a single sorted linked list. The merged list
 *          should be made by splicing together the nodes of the two input lists.
 *
 * Approach:
 * 1. Use two pointers to traverse both lists.
 * 2. Compare the current nodes of both lists, and add the smaller node to the result list.
 * 3. Once one list is exhausted, append the remaining nodes of the other list to the result.
 *
 * Example Execution:
 * List1: [1 -> 2 -> 4]
 * List2: [1 -> 3 -> 4]
 * Merged List: [1 -> 1 -> 2 -> 3 -> 4 -> 4]
 *
 * Time Complexity: O(n + m), where n and m are the lengths of the two lists.
 * Space Complexity: O(1), if result list is created by reusing the nodes of input lists.
 */

class MergeSortedListsNode {
    int val;
    MergeSortedListsNode next;
    MergeSortedListsNode(int x) { val = x; }
}

class MergeSortedLists {
    public MergeSortedListsNode mergeTwoLists(MergeSortedListsNode l1, MergeSortedListsNode l2) {
        // Dummy node to help with the construction of the merged list
        MergeSortedListsNode dummy = new MergeSortedListsNode(0);
        MergeSortedListsNode current = dummy;

        // Traverse both lists
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append the remaining nodes from either list
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }
}

// Example to test the mergeTwoLists method
class MergeSortedListsMain {
    public static void main(String[] args) {
        // Construct first sorted linked list: 1 -> 2 -> 4
        MergeSortedListsNode l1 = new MergeSortedListsNode(1);
        l1.next = new MergeSortedListsNode(2);
        l1.next.next = new MergeSortedListsNode(4);

        // Construct second sorted linked list: 1 -> 3 -> 4
        MergeSortedListsNode l2 = new MergeSortedListsNode(1);
        l2.next = new MergeSortedListsNode(3);
        l2.next.next = new MergeSortedListsNode(4);

        // Merge the two sorted lists
        MergeSortedLists solution = new MergeSortedLists();

        // Print the merged sorted list
        MergeSortedListsNode temp = solution.mergeTwoLists(l1, l2);
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        // Output should be: 1 1 2 3 4 4
    }
}

/**
 * Key Points:
 * - Use a dummy node to simplify the merge process.
 * - Time Complexity: O(n + m) — linear traversal through both lists.
 * - Space Complexity: O(1) — constant space for pointers.
 */
