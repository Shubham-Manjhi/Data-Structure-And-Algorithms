package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    // Method to generate all possible subsets
    public List<List<Integer>> subsets(int[] nums) {
        // Initialize the list to store all subsets
        List<List<Integer>> list = new ArrayList<>();
        // Get the length of the input array
        int n = nums.length;

        // Loop over the range from 0 to 2^n (exclusive)
        // Each integer i in this range represents a unique subset
        for (int i = 0; i < (1<<n); i++) {
            // Initialize the list to store the current subset
            List<Integer> subset = new ArrayList<>();
            // Loop over the range from 0 to n (exclusive)
            // Each integer j in this range represents an element in the input array
            for (int j = 0; j < n; j++) {
                // Check if the j-th bit in the binary representation of i is set
                // If it is, add the j-th element of the input array to the current subset
                if ((i & (1 << j)) > 0) {
                    subset.add(nums[j]);
                }
            }
            // Add the current subset to the list of all subsets
            list.add(subset);
        }

        // Return the list of all subsets
        return list;
    }

    public static void main(String[] args) {
        SubSets solution = new SubSets();
        int[] nums = {1, 3, 3};
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);
    }
}
