package Tree.BST;

import LinkedList.ListNode;
import Tree.Node;

public class SortedLinkedListToBST {

    Node sortedListNodeToBST(ListNode head){
        if(head == null) return null ;
        if(head.next == null) return new Node(head.data) ;
        ListNode mid = findMid(head) ;
        ListNode newHead = mid.next ;
        mid.next = null ;
        ListNode temp = head ;

        while(temp.next != mid) temp = temp.next ;
        temp.next = null ;

        Node root = new Node(mid.data) ;
        root.left = sortedListNodeToBST(head) ;
        root.right = sortedListNodeToBST(newHead) ;
        return root ;
    }

    ListNode findMid(ListNode head){
        ListNode slow = head ;
        ListNode fast = head ;
        while(fast != null &&  fast.next != null){
            fast = fast.next.next ;
            slow = slow.next ;
        }
        return slow ;
    }

}
