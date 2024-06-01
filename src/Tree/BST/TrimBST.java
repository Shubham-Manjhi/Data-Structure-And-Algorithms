package Tree.BST;

import Tree.Node;

/**
 * Question: Given the root of a binary search tree and the lowest and highest boundaries as low and high,
 * trim the tree so that all its elements lie in [low, high]. Trimming the tree should not change the relative
 * structure of the elements that will remain in the tree (i.e., any node's descendant should remain a descendant).
 * It can be proven that there is a unique answer.
 *
 * Return the root of the trimmed binary search tree. Note that the root may change depending on the given bounds.
 */


public class TrimBST {

    Node trimBST(Node node, int k1, int k2) {
        if (node == null) return null;

        node.left = trimBST(node.left, k1, k2);
        node.right = trimBST(node.right, k1, k2);

        if (node.data < k1) {
            return node.right;
        }
        if (node.data > k2) {
            return node.left;
        }
        return node;
    }

}
