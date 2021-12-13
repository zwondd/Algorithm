/*
    2021-10-30
    [Leetcode][Easy] 191. Number of 1 Bits
*/
class NumberOfOneBits {
    /*
        time limit
    */
    public int hammingWeight(int n) {
        int cnt=0;
        while( n != 0 ) {
            if ( (n&1) == 1 ) cnt++;
            n=n>>1;
        }
        return cnt;
    }
}
