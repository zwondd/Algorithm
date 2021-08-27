import javax.swing.text.StyledEditorKit.BoldAction;

/*
    2021-08-27
    [Leetcode][Medium] 5. Longest Palindromic Substring

    solution ) dp
    ref. https://izmirprogramming.tistory.com/12

*/
class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        /*
            Runtime: 131 ms, faster than 37.98% of Java online submissions for Longest Palindromic Substring.
            Memory Usage: 43.6 MB, less than 19.93% of Java online submissions for Longest Palindromic
        */
        int left=0, right=0;
        int size = s.length();
        char[] c = s.toCharArray();
        boolean[][] dp = new boolean[size][size];


        for( int i=0; i<size; i++) {
            for(int j=0; j<i; j++) {
                dp[j][i] = ( c[j] == c[i] ) && ( i-j<=2 || dp[j+1][i-1] );
                if ( dp[j][i] ) {
                    if ( i-j > right-left ) {
                        left = j;
                        right = i;
                    }
                }
            }
        }


        /*
            Runtime: 629 ms, faster than 7.80% of Java online submissions for Longest Palindromic Substring.
            Memory Usage: 106.9 MB, less than 5.00% of Java online submissions for Longest Palindromic
        */
        // for( int i=0; i<s.length(); i++) {
        //     for(int j=0; j<i; j++) {
        //         dp[j][i] = ( s.charAt(j) == s.charAt(i) ) && ( i-j<=2 || dp[j+1][i-1] );
        //         if ( dp[j][i] ) {
        //             if ( i-j > right-left ) {
        //                 left = j;
        //                 right = i;
        //             }
        //         }
        //     }
        // }
        return s.substring(left, right+1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
        String s = "babad";
        System.out.println( sol.longestPalindrome(s) );
    }
}
