package Searching;

public class CheckDuplicates {

    public static boolean checkDuplicates(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > num) {
                nums[j + 1] = nums[j--];
            }
            nums[j + 1] = num;
            if (j > -1 && nums[j] == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 3};
        System.out.println("Does array contain duplicates? " + checkDuplicates(arr));
    }
}
