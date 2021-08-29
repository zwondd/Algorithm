import java.util.ArrayList;

/*
    2021-08-29
    [Leetcode][Medium] 22. Generate Parentheses
*/

import java.util.*;

// Runtime: 2 ms, faster than 28.89% of Java online submissions for Generate Parentheses.
// Memory Usage: 41 MB, less than 5.21% of Java online submissions for Generate Parentheses.
class GenerateParentheses {
    int N;
    List<String> ans = new ArrayList<String>();

    void dfs(int L, int lCnt, int useable, String s) {
        if ( L == N*2 ) {
            ans.add(s);
            return;
        }

        if ( useable>0 ) {
            dfs( L+1, lCnt, useable-1, s+')' );
        } 
        if ( lCnt<N ) {
            dfs( L+1, lCnt+1, useable+1, s+'(' );
        }
    }

    public List<String> generateParenthesis(int n) {
        N = n;
        dfs(0, 0, 0, "");
        return ans;       
    }
}
