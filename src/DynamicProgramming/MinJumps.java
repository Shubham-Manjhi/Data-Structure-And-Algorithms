package DynamicProgramming;

public class MinJumps {

    public int minJumps(int[] arr) {
        int n = arr.length;  // Get the length of the array
        int[] jumps = new int[n];  // Create an array to store the minimum number of jumps needed to reach each index

        if (n == 0 || arr[0] == 0)
            return Integer.MAX_VALUE;  // If the array is empty or the first element is 0, the end isn't reachable

        jumps[0] = 0;  // The first index is already reached so no jumps are needed

        // Find the minimum number of jumps to reach arr[i] from arr[0], and assign this value to jumps[i]
        for (int i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;  // Initialize the number of jumps to the maximum possible value
            for (int j = 0; j < i; j++) {
                // If the current index i is reachable from index j and the number of jumps to reach index j is not the maximum possible value
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    // Update the number of jumps to reach index i if it's less than the current value
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;  // No need to check further, so break the inner loop
                }
            }
        }
        return jumps[n - 1];  // Return the minimum number of jumps to reach the end of the array
    }

    public static void main(String[] args) {
        MinJumps solution = new MinJumps();
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println("Minimum number of jumps to reach end is " + solution.minJumps(arr));  // Output: 3
    }
}
