package Tree.BST;

import Tree.Node;


/**
 * Question: Given the root of a binary tree, determine if it is a valid binary search tree (BST).

 * A valid BST is defined as follows:

 * 1. The left subtree of a node contains only nodes with keys less than the node's key.
 * 2. The right subtree of a node contains only nodes with keys greater than the node's key.
 * 3. Both the left and right subtrees must also be binary search trees.
 */


public class IsValidBST {

    public boolean isValidBST(Node root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(Node node, long min, long max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return isValidBSTHelper(node.left, min, node.data) && isValidBSTHelper(node.right, node.data, max);
    }

}
