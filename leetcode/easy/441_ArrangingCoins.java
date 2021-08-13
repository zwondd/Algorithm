// 2021-08-13

class ArrangingCoins {
    public int arrangeCoins(int n) {
        if (n<=1) return n;

        int left = 0; 
        int right =n;

        int ans = 0;

        while( left<=right ) {
            int m = (left+right)/2;
            long sum = (long) m * (m+1) /2;
            if ( sum<=n ) {
                ans = m;
                left = m+1;
            } else {
                right = m-1;
            }
        }
        return ans;
    }


    public int arrangeCoins1(int n) {
        long sum=0; // int sum=0;   // long type 으로 바꾸면 success 됨.
        int res=1;
        for(int i=1; i<=n; i++) {
            sum+=i;

            if ( sum > n ) {
                res = i-1;
                break;
            }
        }
        return res;
    }
    
}
