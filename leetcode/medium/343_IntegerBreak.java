/*
    2022-04-01
    [Leetcode][Medium] 343. Integer Break
*/
class IntegerBreak {
    public int integerBreak1(int n) {

        int maxProduct = 1;
        for(int i=n-1; i>=2; i--) {
            int res = dfs(n, i, 1, 0, 1); // level start 인덱스
            maxProduct = Math.max(res, maxProduct);
            // System.out.println("k: " + i +  " / result : " + res);
        }
        return maxProduct;
    }

    /*
        timeout
    */
    public int dfs(int n, int k, int level, int sum, int product) {
        System.out.println("k : " + k + " / lv : " + level + " / sum : " + sum + " / product : " + product);
        if ( level==k ) {
            System.out.println("product : " + (n-sum));
            return product*(n-sum);
        }

        int max=product;
        for(int i=1; i<n-sum; i++) { // i의 범위 중요
            int tmp = dfs(n, k, level+1, sum+i, product*i);
            max = Math.max(tmp, max);
        }
        return max;
    }

    /*
        DP 풀이 ) 솔루션 참고 
        https://www.programcreek.com/2015/04/leetcode-integer-break-java/
        
        Runtime: 1 ms, faster than 63.69% of Java online submissions for Integer Break.
        Memory Usage: 41.3 MB, less than 18.07% of Java online submissions for Integer Break.
    */
    public int integerBreak(int n) {
        int[] dp = new int[n+1];

        for(int i=1; i<n; i++) {
            for(int j=1; j<i+1; j++) {
                if ( i+j<=n ) {
                    dp[i+j]=Math.max(Math.max(dp[i],i)*Math.max(dp[j],j), dp[i+j]);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        IntegerBreak ib = new IntegerBreak();
        int result = ib.integerBreak(3);
        System.out.println(result);
    }
}
