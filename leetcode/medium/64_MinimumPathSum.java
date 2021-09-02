/*
    2021-09-02
    [Leetcode][Medium] 64. Minimum Path Sum
    DP
*/

class MinimumPathSum {
    /*
        Runtime: 122 ms, faster than 5.15% of Java online submissions for Minimum Path Sum.
        Memory Usage: 48.3 MB, less than 6.01% of Java online submissions for Minimum Path Sum.
    */
    public int minPathSum1(int[][] grid) {
        int width = grid.length;
        int height = grid[0].length;
        int[][] dp = new int[width][height];

        dp[0][0] = grid[0][0];

        if ( width == 0 && height == 0 ) return dp[0][0];

        for(int i=0; i<width; i++) {
            for(int j=0; j<height; j++) {
                if ( i==0 && j==0 ) continue;
                if ( i==0 ) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                    continue;
                }
                if ( j==0 ) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                    continue;
                }
                 dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        for(int i=0; i<width; i++) {
            for(int j=0; j<height; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[width-1][height-1];
    }

    /*
       Runtime: 2 ms, faster than 81.06% of Java online submissions for Minimum Path Sum.
        Memory Usage: 41.8 MB, less than 56.66% of Java online submissions for Minimum Path Sum. 
    */
    public int minPathSum(int[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if ( i==0 && j==0 ) continue;
                if ( i==0 ) {
                    grid[i][j] += grid[i][j-1];
                    continue;
                }
                if ( j==0 ) {
                    grid[i][j] += grid[i-1][j];
                    continue;
                }
                grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        MinimumPathSum m = new MinimumPathSum();
        int[][] grid =  {{1,3,1},{1,5,1},{4,2,1}};
        int[][] grid1 =  {{1,2,3},{4,5,6}};
        System.out.println(m.minPathSum(grid));
    }
    
}
