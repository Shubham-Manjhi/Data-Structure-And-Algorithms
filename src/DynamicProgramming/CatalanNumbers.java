package DynamicProgramming;

public class CatalanNumbers {
    // Number of BST with n Vertices is CatalanNumber and denoted by Cn.

    // Recursive Approach
    private int CatalanNumber(int n) {
        if (n==0) return 1;

        int count = 0;
        for (int i=0; i<=n; i++) {
            count += CatalanNumber(i-1) * CatalanNumber(n-i);
        }
        return count;
    }

    // DP Approach

    private Integer n = 3;

    private int[] table = new int[n + 1];

    private int CatalanNumberDP(int n) {

        return 0;
    }


}
