package DynamicProgramming;

public class MaxSumAlternativeTwoContiguousSubsequence {

    // Sum from 1 to i.
    static int maxSubArraySum(int[] a, int n) {
        if (n == 1) {
            return a[0];
        }
        int[] dp = new int[n];
        dp[0] = a[0];
        dp[1] = Math.max(a[0], a[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + a[i]);
        }

        return dp[n-1];
    }

    // Sum From i to N.
    static int maxSubArraySumHard(int[] a, int n) {
        if (n == 1) {
            return a[0];
        }
        int dp[] = new int[n+1];
        dp[n] = 0;
        dp[n-1] = a[n-1];

        for (int i = n-2; i >= 0; i--) {
            dp[i] = Math.max(dp[i+1], a[i] + (i+2<n ? dp[i+2] : 0));
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
