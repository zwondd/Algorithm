// 21-07-06

class Solution {
    

    // my solution
    public boolean isPowerOfThree(int n) {
        while( n>3 ) {
            if ( n%3 == 0 ) {
                n/=3;
            } else {
                return false;
            }
        }
        if ( n>0 && n%3 ==0 && n!=0 || n==1 ) return true;
        return false;
    }

    // sol 1 ) iterative 
    public boolean isPowerOfThree1(int n) {
        if ( n==0 ) return false;
        while ( n%3 == 0 ) {
            n/=3;
        }

        return n==1;
    }

    // sol 2 ) recursive 
    public boolean isPowerOfThree2(int n) {
        return n==1 || n>0 && n%3 ==0 && isPowerOfThree2(n/3);
    }
    public static void main(String[] args) {
        int[] arr = { 27, 0, 9, 45 };

        Solution s = new Solution();
        for( int i=0; i< arr.length; i++) {
            System.out.println( " i : " + arr[i] + " " + s.isPowerOfThree(arr[i]));
        }

        System.out.println(s.isPowerOfThree1(-3));
        System.out.println( (-3)%3 );
    }
}