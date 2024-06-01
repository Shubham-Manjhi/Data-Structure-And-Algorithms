package Recursion;

public class Fibonacci {

    // Brute Force Approach
    public static void Fibonacci(int n) {
        int a = 0, b = 1;

        System.out.print(a + " " + b); // printing 0 and 1

        for (int i = 2; i < n; i++) {
            int sum = a + b;
            System.out.print(" " + sum);
            a = b;
            b = sum;
        }

    }

    // Recursive Approach

    static int FibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return FibonacciRecursive(n - 1) + FibonacciRecursive(n - 2);
    }

    //Optimized
    static int FibibacciOptimized(int n) {
        int[] f = new int[n + 2]; // 1 extra to handle case, n = 0
        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }
}
