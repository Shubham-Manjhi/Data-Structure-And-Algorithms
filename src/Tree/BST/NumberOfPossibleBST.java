package Tree.BST;

public class NumberOfPossibleBST {

    /**
     * Question: Given an integer n, return the number of structurally unique BST's (binary search trees)
     * which have exactly n nodes with unique values from 1 to n.
     */

    //    Using DP.
    public int numTrees(int n) {
        // Create an array to store the count of unique BSTs for each number of nodes
        int[] dp = new int[n + 1];

        // Base cases:
        // For 0 or 1 nodes, there is only 1 unique BST possible
        dp[0] = 1;
        dp[1] = 1;

        // For each number of nodes from 2 to n
        for (int i = 2; i <= n; i++) {
            // For a tree with i nodes, iterate over all possible numbers of nodes in the left subtree
            for (int j = 1; j <= i; j++) {
                // dp[j - 1] represents the number of unique BSTs for the left subtree with j - 1 nodes
                // dp[i - j] represents the number of unique BSTs for the right subtree with i - j nodes
                // Multiplying these gives the total number of unique BSTs for the current arrangement of nodes
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        // Return the count of unique BSTs for n nodes
        return dp[n];
    }

    // Using Catalan Number.
    public int numTreesUsingCatalanNumber(int n) {
        return CatalanNumber(n, new int[n + 1]);
    }

    public int CatalanNumber(int n, int[] table) {
        if (table[n] != 0) return table[n];
        if (n == 0) return 1;
        table[n] = 0;
        for (int i = 1; i <= n; i++)
            table[n] += CatalanNumber(i - 1, table) * CatalanNumber(n - i, table);
        return table[n];
    }

    public static void main(String[] args) {
        NumberOfPossibleBST bstCount = new NumberOfPossibleBST();
        int n = 3; // Example input
        int uniqueBSTs = bstCount.numTrees(n);
        System.out.println("Number of unique BSTs with " + n + " nodes: " + uniqueBSTs + " " + bstCount.numTreesUsingCatalanNumber(n));
    }
}
