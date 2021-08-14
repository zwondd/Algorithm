// 2021-08-14

import java.util.*;

class MajorityElement {
    public int majorityElement(int[] nums) {
        int time = nums.length/2;

        Arrays.sort(nums);

        int cnt=0;
        int majorityEle = 0;
        for(int i=0; i<nums.length; i++) {
            if( majorityEle != nums[i] ) {
                if ( cnt > time ) {
                   break;
                }
                cnt = 0;
                majorityEle = nums[i];
            }
            cnt++;
        }
        return majorityEle;
    }
}