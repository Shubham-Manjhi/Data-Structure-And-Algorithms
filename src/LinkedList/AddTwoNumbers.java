package LinkedList;

public class AddTwoNumbers {

    static Node addTwoLists(Node first, Node second) {
        Node res = null;
        Node prev = null;
        Node temp = null;
        int carry = 0, sum;

        while (first != null || second != null) {
            sum = carry + (first != null ? first.data : 0) + (second != null ? second.data : 0);
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
            temp = new Node(sum);

            if (res == null) {
                res = temp;
            } else {
                prev.next = temp;
            }

            prev = temp;

            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }

        if (carry > 0) {
            temp.next = new Node(carry);
        }

        return res;
    }

    public static void main(String[] args) {
        Node first = new Node(2);
        first.next = new Node(4);
        first.next.next = new Node(3);

        Node second = new Node(5);
        second.next = new Node(6);
        second.next.next = new Node(4);

        Node res = addTwoLists(first, second);
        while (res != null) {
            System.out.print(res.data + " ");
            res = res.next;
        }
    }

}
