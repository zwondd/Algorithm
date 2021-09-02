/*
    2021-09-02
    [Leetcode][Medium] 45. Jump Game II
    DP
*/
import java.util.Arrays;
class JumpGame {
    /*
        Runtime: 77 ms, faster than 21.33% of Java online submissions for Jump Game II.
        Memory Usage: 46.5 MB, less than 8.87% of Java online submissions for Jump Game II.
    */
    public int jump1(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=0; i<nums.length; i++) {
            for(int j=1; j<=nums[i]; j++) {
                if ( i+j >= nums.length ) continue;
                dp[i+j] = dp[i]+1 < dp[i+j] ? dp[i]+1 : dp[i+j];
            }
        }

        return dp[nums.length-1];
    }

    /*
        Runtime: 65 ms, faster than 22.72% of Java online submissions for Jump Game II.
        Memory Usage: 46.5 MB, less than 8.87% of Java online submissions for Jump Game II.
    */
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<=i+nums[i]; j++) {
                if ( j>=nums.length || dp[j] != 0 ) continue;
                dp[j] = dp[i]+1;
            }
        }

        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        JumpGame j = new JumpGame();
        int[] nums = {2,3,1,1,4};
        System.out.println(j.jump(nums));
    }
    
}
