package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class FirstMissingElements {

    public static int firstMissingPositive(int[] nums) {

        HashSet<Integer> integerHashMap = new HashSet<Integer>(nums.length);

        for (Integer i : nums) {
            integerHashMap.add(i);
        }

        System.out.println(integerHashMap);

        int count = 1;
        boolean check = true;
        while (check) {
            System.out.println(check);


            if (!integerHashMap.contains(count)) {
                check = false;
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 4}));
    }

}
