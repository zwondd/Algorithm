/*
    2022-08-22
    [Leetcode][Medium] 1759. Count Number of Homogenous Substrings
*/
class CountHomogenousSubstring {
    /*
     * error
     * https://leetcode.com/problems/count-number-of-homogenous-substrings/discuss/1064935/1759.-Easy-and-intiutive-solution-with-explanation-in-c%2B%2B
     */
    public int countHomogenous2(String s) {
        final int mod = 1000000007;
        int n=s.length();

        if ( n==1 ) return 1;

        long ans = 0;
        int i=0, j=1;

        while( j<n ) {
            while( j<n && s.charAt(i) == s.charAt(j) ) {
                j++;
            }
            long len = j-i;
            ans += len*(len+1)/2;
            i=j;
        }
        return (int)ans%mod;
    }

    /*
     * Runtime: 12 ms, faster than 87.89% of Java online submissions for Count Number of Homogenous Substrings.
     * Memory Usage: 42.7 MB, less than 92.04% of Java online submissions for Count Number of Homogenous Substrings.
     */
    public int countHomogenous(String s) {
        final int mod = 1000000007;
        long totalCnt = 0;
        int length = s.length();

        char prev = '0';
        int consecutive = 0;
        for(int i=0; i<length; i++) {
            char c = s.charAt(i);

            if ( c == prev ) {
                consecutive++;
            } else {
                long curCnt = (long) consecutive*(consecutive+1)/2%mod;
                totalCnt = (totalCnt+curCnt) % mod;
                consecutive=1;
                prev=c;
            }
        }
        long curCnt = (long) consecutive*(consecutive+1)/2%mod;
        totalCnt = (totalCnt+curCnt) % mod;
        
        return (int)totalCnt;

    }
}
