package DynamicProgramming;

public class Factorials {

    public long factorial(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;  // base case: 0! = 1

        for (int i = 1; i <= n; i++) {
            dp[i] = i * dp[i - 1];  // relation: n! = n * (n-1)!
        }

        return dp[n];  // return n!
    }

    public static void main(String[] args) {
        Factorials solution = new Factorials();
        System.out.println(solution.factorial(5));  // Output: 120
        System.out.println(solution.factorial(10));  // Output: 3628800
    }

}
