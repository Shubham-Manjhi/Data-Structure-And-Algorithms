package Tree.BST;

import Tree.Node;

public class RecoverBST {

    /**
     * Question: You are given the root of a binary search tree (BST), where the values of exactly two nodes
     * of the tree were swapped by mistake. Recover the tree without changing its structure.
     */

    Node firstNode = null;
    Node secondNode = null;
    Node prevNode = null;

    void swap() {
        int temp = firstNode.data;
        firstNode.data = secondNode.data;
        secondNode.data = temp;
    }

    public void recoverTree(Node root) {
        traverse(root);
        swap();

    }

    private void traverse(Node root) {
        if (root == null) return;
        traverse(root.left);
        if (prevNode != null && prevNode.data > root.data) {
            if (firstNode == null) {
                firstNode = prevNode;
            }
            secondNode = root;
        }
        prevNode = root;
        traverse(root.right);
    }
}
