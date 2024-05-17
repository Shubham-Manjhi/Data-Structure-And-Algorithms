package DynamicProgramming;

public class MaxSumAlternativeThreeContiguousSubsequence {

    // sum from 1 to i.
    static int maxSubArraySum(int[] a, int n) {
        if (n == 1) {
            return a[0];
        }
        if (n == 2) {
            return Math.max(a[0], a[1]);
        }
        if (n == 3) {
            return Math.max(Math.max(a[0], a[1]), a[2]);
        }

        int[] dp = new int[n];
        dp[0] = a[0];
        dp[1] = Math.max(a[0], a[1]);
        dp[2] = Math.max(Math.max(dp[1], dp[0] + a[2]), a[1] + a[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(Math.max(dp[i-1], dp[i-2] + a[i]), dp[i-3] + a[i]);
        }

        return dp[n-1];
    }

    // sum from i to n.

    static int maxSubArraySumHard(int a[], int n) {
        if (n == 1) {
            return a[0];
        }
        if (n == 2) {
            return Math.max(a[0], a[1]);
        }
        int dp[] = new int[n+3];
        dp[n] = 0;
        dp[n-1] = a[n-1];
        dp[n-2] = Math.max(a[n-2], a[n-1]);

        for (int i = n-3; i >= 0; i--) {
            dp[i] = Math.max(Math.max(dp[i+1], a[i] + (i+2<n ? dp[i+2] : 0)), a[i] + (i+3<n ? dp[i+3] : 0));
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        int n = a.length;
        System.out.println("Maximum sum is " + maxSubArraySum(a, n));

        System.out.println("Maximum sum is " + maxSubArraySumHard(a, n));
    }

}
