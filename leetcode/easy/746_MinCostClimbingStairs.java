/*
    2021-09-05
    [Leetcode][Easy] 746. Min Cost Climbing Stairs
    DP
*/

class Climb{
    /*
        Runtime: 1 ms, faster than 81.18% of Java online submissions for Min Cost Climbing Stairs.
        Memory Usage: 39 MB, less than 37.46% of Java online submissions for Min Cost Climbing Stairs.
    */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];

        dp[0] = cost[0];
        dp[1] = cost[1];
        
        if ( cost.length<=2 ) return Math.min(dp[0], dp[1]);

        for(int i=2; i<cost.length; i++) {
            dp[i] = Math.min( dp[i-2], dp[i-1] ) + cost[i];
        }
        for(int i=0; i<cost.length; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();

        return Math.min( dp[cost.length-1], dp[cost.length-2]);
    }

    public static void main(String[] args) {
        Climb c = new Climb();
        int[] arr = {10,15,20};
        System.out.println(c.minCostClimbingStairs(arr));

        int[] arr2 = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(c.minCostClimbingStairs(arr2));

    }
}