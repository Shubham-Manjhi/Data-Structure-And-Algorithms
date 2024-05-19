package Tree.BST;

import Tree.Node;

public class KthSmallestElementInBST {
    private int result = -1;
    private int count = 0;
    public int kthSmallest(Node root, int k) {
        inOrderTraversal(root, k);
        return result;
    }

    private void inOrderTraversal(Node node, int k) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, k);
        if (++count == k) {
            result = node.data;
            return;
        }
        inOrderTraversal(node.right, k);
    }

    // Test the code
    public static void main(String[] args) {
        // Construct the BST
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);
        root.left.right = new Node(2);

        // Find the 1st smallest element
        int k = 1;
        int result = new KthSmallestElementInBST().kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element is: " + result);

        // Find the 2nd smallest element
        k = 2;
        result = new KthSmallestElementInBST().kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element is: " + result);

        // Find the 3rd smallest element
        k = 3;
        result = new KthSmallestElementInBST().kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element is: " + result);

        // Find the 4th smallest element
        k = 4;
        result = new KthSmallestElementInBST().kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element is: " + result);
    }
}
