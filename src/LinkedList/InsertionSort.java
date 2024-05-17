package LinkedList;

public class InsertionSort {

    static Node sorted;

    static void sortedInsert(Node newNode) {
        if (sorted == null || sorted.data >= newNode.data) {
            newNode.next = sorted;
            sorted = newNode;
        } else {
            Node current = sorted;
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
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
