package Tree.BST;

import Tree.Node;

public class InOrderTraversal {

    public Node searchBST(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (root.data == val) {
            return root;
        } else if (root.data > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

}
