/*
    2021-10-10
     [Leetcode][Medium] 96. Unique Binary Search Trees
*/
class UniqueBST {
    /*
        dp 문제, solution 보고 품
        참고) https://kj97.tistory.com/56

        f(n) 을 주어진 값이 n 일 때 unique binary search 개수
        f(n) = f(0) * f(n-1) + f(1) * f(n-2) + ... + f(n-1)*f(0)

        Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
        Memory Usage: 35.7 MB, less than 73.50% of Java online submissions for Unique Binary
    */
    public int numTrees(int n) {
        int[] dp = new int[20];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                dp[i] += (dp[j-1] * dp[i-j]);
            }
        }
        return dp[n];
    }
}
