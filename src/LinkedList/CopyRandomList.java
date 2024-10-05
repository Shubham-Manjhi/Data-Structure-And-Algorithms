package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 ******************************************************************************************
 ******************** Topics: Copy List with Random Pointer.   ********************
 ******************************************************************************************

 * Question Source: Linked List, HashMap
 * Level: Medium
 *
 * Problem: A linked list is given where each node contains an additional random pointer
 *          which could point to any node in the list or null. Create a deep copy of the list.
 *
 * Approach:
 * 1. Use a HashMap to store the mapping between original nodes and copied nodes.
 * 2. First, create copies of each node and store them in the map.
 * 3. Then, set the next and random pointers using the stored map.
 *
 * Example Execution:
 * Original List: [1(random -> 3)] -> [2(random -> 1)] -> [3(random -> 2)]
 * Copy List:     [1(random -> 3)] -> [2(random -> 1)] -> [3(random -> 2)]
 *
 * Time Complexity: O(n), where n is the number of nodes.
 * Space Complexity: O(n), due to the use of the HashMap.
 */

class RandomPointerListNode {
    int val;
    RandomPointerListNode next, random;
    RandomPointerListNode(int val) { this.val = val; }
}

class CopyRandomPointerList {
    public RandomPointerListNode copyRandomList(RandomPointerListNode head) {
        if (head == null) return null;

        // Map to hold original node -> new node mapping
        Map<RandomPointerListNode, RandomPointerListNode> map = new HashMap<>();

        // Step 1: Create all nodes and store them in the map
        RandomPointerListNode current = head;
        while (current != null) {
            map.put(current, new RandomPointerListNode(current.val));
            current = current.next;
        }

        // Step 2: Assign next and random pointers
        current = head;
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }

        // Return the head of the copied list
        return map.get(head);
    }
}

// Example to test the copyRandomList method
class CopyRandomPointerListMain {
    public static void main(String[] args) {
        // Construct a random pointer list: 1 -> 2 -> 3
        RandomPointerListNode head = new RandomPointerListNode(1);
        RandomPointerListNode node2 = new RandomPointerListNode(2);
        RandomPointerListNode node3 = new RandomPointerListNode(3);
        head.next = node2;
        node2.next = node3;

        // Assign random pointers
        head.random = node3;
        node2.random = head;
        node3.random = node2;

        // Copy the list
        CopyRandomPointerList copyList = new CopyRandomPointerList();

        // Print the copied list
        RandomPointerListNode temp = copyList.copyRandomList(head);
        while (temp != null) {
            System.out.println("Node value: " + temp.val + ", Random node value: " +
                    (temp.random != null ? temp.random.val : "null"));
            temp = temp.next;
        }
    }
}

/**
 * Key Points:
 * - HashMap is used to map each original node to its corresponding copied node.
 * - Time Complexity: O(n) — linear traversal through the list.
 * - Space Complexity: O(n) — additional space for HashMap.
 */
