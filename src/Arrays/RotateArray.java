package Arrays;

import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        // Create a new array of the same length
        int[] newArray = new int[nums.length];

        // For each number in the original array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the new position of this number
            int newPosition = (i + k) % nums.length;

            System.out.println(newPosition);

            // Place the number in the new array
            newArray[newPosition] = nums[i];
        }

        // Copy the new array to the original one
        System.arraycopy(newArray, 0, nums, 0, nums.length);
    }

    public void rotateOptimized(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();

        int[] nums1 = {1,2,3,4,5,6,7};
        rotateArray.rotate(nums1, 3);
        System.out.println(Arrays.toString(nums1)); // Output: [5,6,7,1,2,3,4]

        int[] nums2 = {-1,-100,3,99};
        rotateArray.rotateOptimized(nums2, 2);
        System.out.println(Arrays.toString(nums2)); // Output: [3,99,-1,-100]
    }

}
