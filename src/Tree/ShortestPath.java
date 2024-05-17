package Tree;

import java.util.*;

public class ShortestPath {
    Node root;
    Map<Integer, Node> parent = new HashMap<>();

    public String shortestPath(Node node, int startValue, int destValue) {
        if (node == null) return "";
        buildParent(node, null);

        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(parent.get(startValue));
        visited.add(startValue);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.data == destValue) {
                return buildPath(startValue, destValue);
            }

            if (current.left != null && !visited.contains(current.left.data)) {
                queue.offer(current.left);
                visited.add(current.left.data);
            }

            if (current.right != null && !visited.contains(current.right.data)) {
                queue.offer(current.right);
                visited.add(current.right.data);
            }

            Node parentNode = parent.get(current.data);
            if (parentNode != null && !visited.contains(parentNode.data)) {
                queue.offer(parentNode);
                visited.add(parentNode.data);
            }
        }

        return "";
    }

    private void buildParent(Node node, Node parentNode) {
        if (node != null) {
            parent.put(node.data, parentNode);
            buildParent(node.left, node);
            buildParent(node.right, node);
        }
    }

    private String buildPath(int startValue, int destValue) {
        List<Character> path = new ArrayList<>();
        Node node = parent.get(destValue);

        while (node.data != startValue) {
            Node parentNode = parent.get(node.data);
            if (parentNode.left != null && parentNode.left.data == node.data) {
                path.add('L');
            } else if (parentNode.right != null && parentNode.right.data == node.data) {
                path.add('R');
            } else {
                path.add('U');
            }
            node = parentNode;
        }

        Collections.reverse(path);
        StringBuilder sb = new StringBuilder();
        for (char c : path) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ShortestPath tree = new ShortestPath();

        /* Let us create the following binary tree
                  1
                /   \
               2     3
              / \   / \
             4   5 6   7
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        int startValue = 4;
        int destValue = 6;

        String path = tree.shortestPath(tree.root, startValue, destValue);

        System.out.println("The shortest path from " + startValue + " to " + destValue + " is: " + path);
    }
}
