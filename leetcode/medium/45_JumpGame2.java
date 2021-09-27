/*
    2021-09-27
    [Leetcode][Medium] 45. Jump Game II
*/
import java.util.*;

class JumpGame2 {
    /*
        Runtime: 49 ms, faster than 32.00% of Java online submissions for Jump Game II.
        Memory Usage: 39.4 MB, less than 86.29% of Java online submissions for Jump Game II.
    */
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill( dp, Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=0; i<nums.length; i++) {
            for( int j=0; j<=nums[i]; j++ ) {
                if ( i+j > nums.length-1 ) continue;
                dp[i+j] = Math.min( dp[i+j], dp[i]+1);
            }
        }
        return dp[nums.length-1];
    }

    /*
      Runtime: 1 ms, faster than 99.51% of Java online submissions for Jump Game II.
      Memory Usage: 39.3 MB, less than 90.43% of Java online submissions for Jump Game II.  

      참조) https://bcp0109.tistory.com/280
    */
    public int jump2(int[] nums) {
        int count=0, curMax=0, nextMax=0;

        for(int i=0; i<nums.length-1; i++) {
            nextMax = Math.max( nextMax, i+nums[i] );

            if ( i==curMax ) {
                count++;
                curMax = nextMax;
            }
        }
        return count;
    }
}
