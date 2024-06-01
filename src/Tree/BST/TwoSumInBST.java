package Tree.BST;

import Tree.Node;

public class TwoSumInBST {

    public static boolean twoSumInBST(Node node, int k, Node root) {
        if (node == null) {
            return false;
        }
        int a = node.data;
        int b = k - a;
        boolean ans = (a != b) && find(root, b);
        if (ans) {
            return true;
        }
        return twoSumInBST(node.left, k, root) || twoSumInBST(node.right, k, root);
    }

    public static boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            return true;
        } else if (node.data > data) {
            return find(node.left, data);
        } else {
            return find(node.right, data);
        }
    }

}
