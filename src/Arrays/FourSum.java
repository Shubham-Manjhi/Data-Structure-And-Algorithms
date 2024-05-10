package Arrays;

import java.util.*;

class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-3; ++i) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            long num = (long)target - (long)nums[i];
            for(int j = i+1; j < nums.length-2; ++j) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int l = j+1, r = nums.length-1;
                while(l < r) {
                    long sum = (long)nums[j] + (long)nums[l] + (long)nums[r];
                    if(sum > num) {
                        r--;
                    } else if(sum < num){
                        l++;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                        while(l < r && nums[l] == nums[l-1]) l++;
                        while(l < r && nums[r] == nums[r+1]) r--;
                    }
                }
            }
        }

        return ans;
    }
}
