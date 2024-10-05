package LinkedList;

/**
 ******************************************************************************************
 ******************** Topics: Add Two Numbers.   ********************
 ******************************************************************************************

 * Question Source: Linked List, Math
 * Level: Medium
 *
 * Problem: You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * Approach:
 * 1. Traverse both linked lists.
 * 2. Sum the values of corresponding nodes along with any carry.
 * 3. If the sum is >= 10, maintain a carry for the next sum.
 * 4. Create a new node for each digit of the result.
 *
 * Example Execution:
 * List1: [2 -> 4 -> 3] (represents 342)
 * List2: [5 -> 6 -> 4] (represents 465)
 * Sum: [7 -> 0 -> 8] (represents 807)
 *
 * Time Complexity: O(n), where n is the length of the longer list.
 * Space Complexity: O(n), for the resulting linked list.
 */

class AddTwoNumbersListNode {
    int val;
    AddTwoNumbersListNode next;
    AddTwoNumbersListNode(int x) { val = x; }
}

class AddTwoNumbersList {
    public AddTwoNumbersListNode addTwoNumbers(AddTwoNumbersListNode l1, AddTwoNumbersListNode l2) {
        AddTwoNumbersListNode dummy = new AddTwoNumbersListNode(0);
        AddTwoNumbersListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new AddTwoNumbersListNode(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }
}

// Example to test the addTwoNumbers method
class AddTwoNumbersMain {
    public static void main(String[] args) {
        // Construct first linked list: 2 -> 4 -> 3
        AddTwoNumbersListNode l1 = new AddTwoNumbersListNode(2);
        l1.next = new AddTwoNumbersListNode(4);
        l1.next.next = new AddTwoNumbersListNode(3);

        // Construct second linked list: 5 -> 6 -> 4
        AddTwoNumbersListNode l2 = new AddTwoNumbersListNode(5);
        l2.next = new AddTwoNumbersListNode(6);
        l2.next.next = new AddTwoNumbersListNode(4);

        // Add the two numbers
        AddTwoNumbersList solution = new AddTwoNumbersList();

        // Print the resulting list
        AddTwoNumbersListNode temp = solution.addTwoNumbers(l1, l2);
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        // Output should be: 7 0 8 (represents 807)
    }
}

/**
 * Key Points:
 * - Traverse both linked lists simultaneously and add corresponding digits.
 * - Use carry to handle sums that are >= 10.
 * - Time Complexity: O(n) — linear traversal through the longer list.
 * - Space Complexity: O(n) — space for the result.
 */