package LinkedList;

public class InsertionSort {

    static ListNode sorted;

    static void sortedInsert(ListNode newListNode) {
        if (sorted == null || sorted.data >= newListNode.data) {
            newListNode.next = sorted;
            sorted = newListNode;
        } else {
            ListNode current = sorted;
            while (current.next != null && current.next.data < newListNode.data) {
                current = current.next;
            }
            newListNode.next = current.next;
            current.next = newListNode;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(5);
        list.add(20);
        list.add(4);
        list.add(3);
        list.add(30);


        System.out.println("Linked List before Sorting:");
        list.display();

        InsertionSort.sortedInsert(list.head);

        System.out.println("\nLinked List after Sorting:");
        list.display();
    }

}
