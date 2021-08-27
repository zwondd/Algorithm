/*
    2021-08-27
    [Leetcode][Medium] 97. Interleaving String

    Revies 재풀이

    Runtime: 9 ms, faster than 14.12% of Java online submissions for Interleaving String.
    Memory Usage: 39.2 MB, less than 18.51% of Java online submissions for Interleaving String.

*/
class InterleavingString_2 {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];

        if ( s1.length() + s2.length() != s3.length() ) {
            return false;
        }

        for(int i=0; i<=s1.length(); i++) {
            for(int j=0; j<=s2.length(); j++) {
                dp[i][j] = false;
            }
        }
        dp[0][0] = true;
        for(int i=1; i<=s1.length(); i++) dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        for(int i=1; i<=s2.length(); i++) dp[0][i] = dp[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
        // for(int i=1; i<=s1.length(); i++) {
        //     if ( s1.charAt(i-1) == s3.charAt(i-1) ) 
        //         dp[i][0] = true;
        // }
        // for(int i=1; i<=s2.length(); i++) {
        //     if ( s2.charAt(i-1) == s3.charAt(i-1) ) 
        //         dp[0][i] = true;
        // }

        for(int i=1; i<=s1.length(); i++) {
            for(int j=1; j<=s2.length(); j++) {
                dp[i][j] = ( dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1) || 
                            dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1) );
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        InterleavingString il = new InterleavingString();
        // String s1 = "aabcc";
        // String s2 = "dbbca";
        // String s3 = "aadbbcbcac";

        String s1 = "db";
        String s2 = "b";
        String s3 = "cbb";
        System.out.println( il.isInterleave(s1, s2, s3) );
    }
    
}
