/*
    2022-01-04
    [Leetcode][Easy] 645. Set Mismatch
*/
import java.util.*;

class SetMismatch {
    /*
        Runtime: 16 ms, faster than 11.15% of Java online submissions for Set Mismatch.
        Memory Usage: 52.1 MB, less than 9.05% of Java online submissions for Set Mismatch.
    */
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] check = new int[nums.length+1];
        int[] res = new int[2];
        
        for(int i=0; i<nums.length; i++) {
            check[nums[i]]++;
        }

        for(int i=1; i<=nums.length; i++) {
            if ( check[i]==2 ) res[0]=i;
            if ( check[i]==0 ) res[1]=i;
        }
        return res;
    }
}
