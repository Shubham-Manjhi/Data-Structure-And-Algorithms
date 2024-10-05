package LinkedList;

/**
 * Problem: Given the head of a linked list, rotate the list to the right by k places.
 *
 * Approach:
 * - First, find the length of the linked list and connect the tail to the head, making it a circular list.
 * - Then, calculate the effective rotations needed by taking k modulo the length.
 * - Break the circular list at the right position to form the rotated list.
 *
 * Example Execution:
 * Given List: 1 -> 2 -> 3 -> 4 -> 5, k = 2
 *
 * 1. Find the length of the list, which is 5.
 *    Length: 5
 *
 * 2. Connect the tail to the head to form a circle.
 *    Circular list: 1 -> 2 -> 3 -> 4 -> 5 -> [points to head 1]
 *
 * 3. Calculate the number of actual rotations needed.
 *    Effective rotations: k % length = 2 % 5 = 2
 *
 * 4. Find the new head after (length - k % length) steps.
 *    Start from head and move 3 steps (5 - 2).
 *
 * 5. Break the link to form the rotated list.
 *    Final Rotated List: 4 -> 5 -> 1 -> 2 -> 3
 *
 * Time Complexity: O(n), where n is the length of the list.
 * Space Complexity: O(1), because no extra space is used besides pointers.
 */

class RotateRightListNode {
  int val;
  RotateRightListNode next;
  RotateRightListNode(int val) { this.val = val; }
}

class Solution {
  public RotateRightListNode rotateRight(RotateRightListNode head, int k) {
    if (head == null || head.next == null || k == 0) return head;

    // Step 1: Find the length of the list
    RotateRightListNode curr = head;
    int length = 1;
    while (curr.next != null) {
      curr = curr.next;
      length++;
    }

    // Step 2: Connect tail to head (make it a circular list)
    curr.next = head;

    // Step 3: Calculate the effective rotations
    k = k % length;
    int stepsToNewHead = length - k;

    // Step 4: Find the new head
    curr = head;
    for (int i = 1; i < stepsToNewHead; i++) {
      curr = curr.next;
    }

    // Step 5: Break the circular list
    RotateRightListNode newHead = curr.next;
    curr.next = null;

    return newHead;
  }
}

// Example to test the rotateRight method
class RotateRightMain {
  public static void main(String[] args) {
    Solution solution = new Solution();

    // Construct the linked list: 1 -> 2 -> 3 -> 4 -> 5
    RotateRightListNode head = new RotateRightListNode(1);
    head.next = new RotateRightListNode(2);
    head.next.next = new RotateRightListNode(3);
    head.next.next.next = new RotateRightListNode(4);
    head.next.next.next.next = new RotateRightListNode(5);

    // Rotate the list by k = 2
    RotateRightListNode result = solution.rotateRight(head, 2);

    // Print the result
    while (result != null) {
      System.out.print(result.val + " ");
      result = result.next;
    }
  }
}