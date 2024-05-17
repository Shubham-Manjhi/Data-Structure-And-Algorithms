package DynamicProgramming;

public class MinOperation {

    public int minDistance(String word1, String word2) {
        // Get the lengths of the two words
        int m = word1.length();
        int n = word2.length();

        // Initialize a 2D array to store the minimum number of operations required to transform word1 into word2
        int[][] dp = new int[m + 1][n + 1];

        // Fill the first column of the dp array. The minimum number of operations required to transform word1 into an empty string is the length of word1
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // Fill the first row of the dp array. The minimum number of operations required to transform an empty string into word2 is the length of word2
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Fill the rest of the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the current characters of word1 and word2 are the same, the minimum number of operations is the same as the minimum number of operations for the previous characters
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If the current characters of word1 and word2 are different, the minimum number of operations is the minimum of the following three operations:
                    // 1. Replace the current character in word1 with the current character in word2
                    // 2. Delete the current character in word1
                    // 3. Insert the current character in word2 into word1
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }

        // The minimum number of operations required to transform word1 into word2 is stored in dp[m][n]
        return dp[m][n];
    }

    public static void main(String[] args) {
        MinOperation solution = new MinOperation();
        System.out.println(solution.minDistance("kitten", "sitting"));  // Output: 3
        System.out.println(solution.minDistance("rosettacode", "raisethysword"));  // Output: 8
    }

}
