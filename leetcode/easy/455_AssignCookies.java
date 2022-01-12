import java.util.Arrays;

/*
    2022-01-12
    [Leetcode][Easy] 455. Assign Cookies
*/
class AssignCookies {
    /*
        Runtime: 6 ms, faster than 98.81% of Java online submissions for Assign Cookies.
        Memory Usage: 39.5 MB, less than 89.65% of Java online submissions for Assign Cookies.
    */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int cnt=0;
        int idx=0;

        for(int j=0; j<g.length; j++) {
            for(int i=idx; i<s.length; i++) {
                if ( s[i] >= g[j] ) {
                    idx=i+1;
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }

    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi=0,si=0;
        while(gi<g.length&&si<s.length){
            if(g[gi]<=s[si])
                gi++;
            si++;
        }
        return gi;
    }
}
