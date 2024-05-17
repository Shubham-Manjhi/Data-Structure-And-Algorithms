package Arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        // If the array is empty, we return 0
        if (nums.length == 0) return 0;

        // Initialize the slow pointer i
        int i = 0;

        // Start from the second element in the array and iterate over the array
        for (int j = 1; j < nums.length; j++) {
            // If we find a non-duplicate element (nums[j] != nums[i])
            if (nums[j] != nums[i]) {
                // Increment i and copy the non-duplicate element to the next position
                i++;
                nums[i] = nums[j];
            }
            // If nums[j] == nums[i], we just skip it and move to the next element
        }

        // The number of unique elements in the array is i + 1
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicates = new RemoveDuplicatesFromSortedArray();

        int[] nums1 = {1,1,2};
        System.out.println(removeDuplicates.removeDuplicates(nums1)); // Output: 2
        System.out.println(Arrays.toString(nums1)); // Output: [1,2,_]

        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates.removeDuplicates(nums2)); // Output: 5
        System.out.println(Arrays.toString(nums2)); // Output: [0,1,2,3,4,_,_,_,_,_]
    }

}
