package Arrays;

import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();

        int[] nums1 = {3,2,2,3};
        int val1 = 3;
        System.out.println(removeElement.removeElement(nums1, val1)); // Output: 2
        System.out.println(Arrays.toString(nums1)); // Output: [2,2,_,_]

        int[] nums2 = {0,1,2,2,3,0,4,2};
        int val2 = 2;
        System.out.println(removeElement.removeElement(nums2, val2)); // Output: 5
        System.out.println(Arrays.toString(nums2)); // Output: [0,1,4,0,3,_,_,_]
    }
}
