package DynamicProgramming;

public class LongestPalindromeSubsequence {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // All characters in the string are a palindrome of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int cl = 2; cl <= n; cl++) {
            for (int i = 0; i < n - cl + 1; i++) {
                int j = i + cl - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    // If there are only two characters and both are same
                    if (cl == 2) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }

        // Length of longest palindromic subsequence
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LongestPalindromeSubsequence solution = new LongestPalindromeSubsequence();
        System.out.println(solution.longestPalindromeSubseq("bbbab"));  // Output: 4  after remove 'a', bbbb = 4
        System.out.println(solution.longestPalindromeSubseq("cbbd"));  // Output: 2   after remove c and d, bb = 2
    }

}
