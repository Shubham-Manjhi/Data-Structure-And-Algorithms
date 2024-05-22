package Tree.BST;

import Tree.Node;

public class RangeSumBST {

    int sum = 0;

    public int rangeSumBST(Node root, int low, int high, int sum) {

        if(root.data<=high && root.data>=low){
            sum+=root.data;
        }

        if(root.data>=low && root.left!=null){
            rangeSumBST(root.left, low, high, sum);
        }

        if(root.data<=high && root.right!=null){
            rangeSumBST(root.right, low, high, sum);
        }

        return sum;
    }

}
