package Tree.BST;

import Tree.Node;

public class SortedArrayToBST {

    public Node sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return convertListToBST(nums, 0, nums.length - 1);
    }

    private Node convertListToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        Node node = new Node(nums[mid]);

        node.left = convertListToBST(nums, left, mid - 1);
        node.right = convertListToBST(nums, mid + 1, right);
        return node;
    }

}
