package DynamicProgramming;

public class MaxSumContiguousSubsequence {
    static void maxSubArraySum(int[] a, int size) {
        int maxSoFar = a[0];
        int currMax = a[0];

        for (int i = 1; i < size; i++) {
            currMax = Math.max(a[i], currMax + a[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }

        System.out.println("Maximum contiguous sum is " + maxSoFar);
    }

    public static void main(String[] args) {
        int[] a = {-2, 11, -4, 13, -5, 2};
        int n = a.length;
        maxSubArraySum(a, n);
    }
}
