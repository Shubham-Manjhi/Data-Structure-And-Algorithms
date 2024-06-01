package Tree.BST;

import Tree.Node;

import java.util.ArrayList;
import java.util.List;

public class NumberOfPossibleBSTGenerates {

    public List<Node> generateTrees(int n) {
        List<Node>[][] dp = new List[n + 1][n + 1];
        buildBst(1, n, dp);
        return dp[1][n];
    }

    private List<Node> buildBst(int low, int high, List<Node>[][] dp){
        // NOT return null, return list with null element
        if(low> high){
            var res = new ArrayList<Node>();
            res.add(null);
            return res;
        }

        if(dp[low][high] != null) return dp[low][high];

        var res = new ArrayList<Node>();

        for(int i = low; i<=high; i++){
            List<Node> lefts = buildBst(low, i - 1, dp);
            List<Node> rights = buildBst(i + 1, high, dp);

            for(var left : lefts)
                for(var right : rights)
                    res.add(new Node(i, left, right));
        }

        dp[low][high] = res;

        return res;
    }

}
