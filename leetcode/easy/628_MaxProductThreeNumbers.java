/*
    2022-01-06
    [Leetcode][Easy] 628. Maximum Product of Three Numbers
*/
import java.util.*;

class MaxProductThreeNumbers {
    /*
        Runtime: 9 ms, faster than 66.33% of Java online submissions for Maximum Product of Three Numbers.
        Memory Usage: 40.7 MB, less than 32.70% of Java online submissions for Maximum Product of Three Numbers.
    */
    public int maximumProduct(int[] nums) {
        int res=Integer.MIN_VALUE;
        int len=nums.length;
        Arrays.sort(nums);

        int x = nums[0]*nums[1]*nums[len-1];;
        int y = nums[0]*nums[len-2]*nums[len-1];
        int z = nums[len-3]*nums[len-2]*nums[len-1];

        res = Math.max(x, y);
        res = Math.max(res, z);

        return res;
    }  
}
