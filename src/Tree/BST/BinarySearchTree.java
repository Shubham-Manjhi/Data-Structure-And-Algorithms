package Tree.BST;

import Tree.Node;

import java.util.HashSet;
import java.util.Set;

class BinarySearchTree {
    Node root;

    // Method to set left node
    void setLeft(Node node, Node left) {
        node.left = left;
    }

    // Method to get left node
    Node getLeft(Node node) {
        return node.left;
    }

    // Method to set right node
    void setRight(Node node, Node right) {
        node.right = right;
    }

    // Method to get right node
    Node getRight(Node node) {
        return node.right;
    }

    // Method to set data to a node
    void setData(Node node, int data) {
        node.data = data;
    }

    // Method to find a node
    Node find(Node root, int data) {
        if (root == null || root.data == data)
            return root;

        if (root.data < data)
            return find(root.right, data);

        return find(root.left, data);
    }

    // Method to find the minimum value node
    Node findMin(Node root) {
        Node current = root;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // Method to find the maximum value node
    Node findMax(Node root) {
        Node current = root;

        while (current.right != null) {
            current = current.right;
        }

        return current;
    }

    // Method to insert a new node
    Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insert(root.left, data);
        else if (data > root.data)
            root.right = insert(root.right, data);

        return root;
    }

    // Method to delete a node
    Node delete(Node root, int data) {
        if (root == null) return root;

        if (data < root.data)
            root.left = delete(root.left, data);
        else if (data > root.data)
            root.right = delete(root.right, data);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = findMin(root.right).data;
            root.right = delete(root.right, root.data);
        }

        return root;
    }

    // Method to find the Lowest Common Ancestor (LCA)
    Node findLCA(Node node, int n1, int n2) {
        if (node == null) {
            return null;
        }

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.data > n1 && node.data > n2) {
            return findLCA(node.left, n1, n2);
        }

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.data < n1 && node.data < n2) {
            return findLCA(node.right, n1, n2);
        }

        return node;
    }

    // Check Given Node is BST or not ?
    boolean isBST()  {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Utility method to check if a tree is a BST
    boolean isBSTUtil(Node node, int min, int max) {
        if (node == null)
            return true;

        if (node.data < min || node.data > max)
            return false;

        return (isBSTUtil(node.left, min, node.data-1) && isBSTUtil(node.right, node.data+1, max));
    }

    // Method to convert sorted array to a balanced BST
    Node sortedArrayToBST(int arr[], int start, int end) {
        // Base Case
        if (start > end) {
            return null;
        }

        // Get the middle element and make it root
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);

        // Recursively construct the left subtree and make it
        // left child of root
        node.left = sortedArrayToBST(arr, start, mid - 1);

        // Recursively construct the right subtree and make it
        // right child of root
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }

    // A utility function to print preorder traversal of BST
    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Method to do inorder traversal and add nodes to set
    void inorder(Node node, Set<Integer> set) {
        if (node == null) {
            return;
        }
        inorder(node.left, set);
        set.add(node.data);
        inorder(node.right, set);
    }

    // Method to find union of BSTs
    Set<Integer> findUnion(Node root1, Node root2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Inorder traversal of first tree and store the elements to set1
        inorder(root1, set1);
        // Inorder traversal of second tree and store the elements to set2
        inorder(root2, set2);

        // Union of two sets
        set1.addAll(set2);
        return set1;
    }

    // Method to find intersection of BSTs
    Set<Integer> findIntersection(Node root1, Node root2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Inorder traversal of first tree and store the elements to set1
        inorder(root1, set1);
        // Inorder traversal of second tree and store the elements to set2
        inorder(root2, set2);

        // Intersection of two sets
        set1.retainAll(set2);
        return set1;
    }

    // Method to print elements in the range k1 to k2
    void printInRange(Node node, int k1, int k2) {
        if (node == null) {
            return;
        }

        // Since the desired output is sorted, recurse for left subtree first
        if (k1 < node.data) {
            printInRange(node.left, k1, k2);
        }

        // If root's data lies in range, then prints root's data
        if (k1 <= node.data && k2 >= node.data) {
            System.out.print(node.data + " ");
        }

        // If root's data is smaller than k2, then only we can get output in right subtree
        if (k2 > node.data) {
            printInRange(node.right, k1, k2);
        }
    }

    // Method to trim the BST and keep only nodes in the range k1 to k2
    Node trimBST(Node node, int k1, int k2) {
        // Base case
        if (node == null) {
            return null;
        }

        // First fix the left and right subtrees of this node
        node.left = trimBST(node.left, k1, k2);
        node.right = trimBST(node.right, k1, k2);

        // Now fix this node. If the node's value is outside the range [k1, k2],
        // then we remove this node and return the appropriate child node.
        if (node.data < k1) {
            return node.right;
        }
        if (node.data > k2) {
            return node.left;
        }

        // If the node's value is in the range [k1, k2], then we return this node
        return node;
    }

    boolean areElementsSame(BinarySearchTree tree2) {
        Set<Integer> list1 = new HashSet<>();
        Set<Integer> list2 = new HashSet<>();

        // Inorder traversal of first tree and store the elements to list1
        inorder(this.root, list1);
        // Inorder traversal of second tree and store the elements to list2
        inorder(tree2.root, list2);

        // Compare two lists
        return list1.equals(list2);
    }


    // Driver method
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);

        System.out.println("The minimum value of BST is " + tree.findMin(tree.root).data);
        System.out.println("The maximum value of BST is " + tree.findMax(tree.root).data);

        System.out.println("Deleting 20");
        tree.root = tree.delete(tree.root, 20);
        System.out.println("The minimum value of BST is " + tree.findMin(tree.root).data);


        System.out.println("LCA of 30 and 70 is " + tree.findLCA(tree.root, 30, 70).data);

        if (tree.isBST())
            System.out.println("This is a BST");
        else
            System.out.println("This is not a BST");


        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        Node root = tree.sortedArrayToBST(arr, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST");
        tree.preOrder(root);

        BinarySearchTree tree1 = new BinarySearchTree();
        BinarySearchTree tree2 = new BinarySearchTree();

        /* Let us create the following tree as first tree
                5
              /   \
            3      6
          /   \     \
         2     4     7  */

        tree1.root = tree1.insert(tree1.root, 5);
        tree1.root = tree1.insert(tree1.root, 3);
        tree1.root = tree1.insert(tree1.root, 2);
        tree1.root = tree1.insert(tree1.root, 4);
        tree1.root = tree1.insert(tree1.root, 6);
        tree1.root = tree1.insert(tree1.root, 7);

        /* Let us create the following tree as second tree
                4
              /   \
            2      8
          /   \
         1     3   */

        tree2.root = tree2.insert(tree2.root, 4);
        tree2.root = tree2.insert(tree2.root, 2);
        tree2.root = tree2.insert(tree2.root, 1);
        tree2.root = tree2.insert(tree2.root, 3);
        tree2.root = tree2.insert(tree2.root, 8);

        System.out.println("Union of two BSTs: " + tree1.findUnion(tree1.root, tree2.root));
        System.out.println("Intersection of two BSTs: " + tree1.findIntersection(tree1.root, tree2.root));

        tree = new BinarySearchTree();

        /* Let us create the following BST
              20
             /  \
            8   22
           / \
          4  12
             /  \
            10  14
        */
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 22);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 14);

        System.out.println("Elements in the range 10 to 22 are: ");
        tree.printInRange(tree.root, 10, 22);

        tree = new BinarySearchTree();

        /* Let us create the following BST
              20
             /  \
            8   22
           / \
          4  12
             /  \
            10  14
        */
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 22);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 14);

        System.out.println("Trimming the BST to the range 8 to 20");
        tree.root = tree.trimBST(tree.root, 8, 20);


        tree1 = new BinarySearchTree();
        tree2 = new BinarySearchTree();

        /* Let us create the following tree as first tree
                5
              /   \
            3      6
          /   \     \
         2     4     7  */

        tree1.root = tree1.insert(tree1.root, 5);
        tree1.root = tree1.insert(tree1.root, 3);
        tree1.root = tree1.insert(tree1.root, 2);
        tree1.root = tree1.insert(tree1.root, 4);
        tree1.root = tree1.insert(tree1.root, 6);
        tree1.root = tree1.insert(tree1.root, 7);

        /* Let us create the following tree as second tree
                5
              /   \
            3      7
          /   \
         2     4   */

        tree2.root = tree2.insert(tree2.root, 5);
        tree2.root = tree2.insert(tree2.root, 3);
        tree2.root = tree2.insert(tree2.root, 2);
        tree2.root = tree2.insert(tree2.root, 4);
        tree2.root = tree2.insert(tree2.root, 7);

        System.out.println("Are elements of two BSTs same? " + tree1.areElementsSame(tree2));
    }
}
