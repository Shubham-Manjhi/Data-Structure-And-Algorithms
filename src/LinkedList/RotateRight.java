package LinkedList;

public class RotateRight {

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || k == 0) {
      return head;
    }

    // Step 1: Calculate the length of the list
    ListNode current = head;
    int length = 1;
    while (current.next != null) {
      current = current.next;
      length++;
    }

    // Step 2: Make the list circular
    current.next = head;

    // Step 3: Traverse the list to the point where the rotation should start
    int stepsToNewHead = length - k % length;
    while (stepsToNewHead-- > 0) {
      current = current.next;
    }

    // Step 4: Break the circle
    head = current.next;
    current.next = null;

    return head;
  }
}

