// 21-07-28

/*
    edge case 
    - 1 : false
*/
class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        long l = 1;
        long r = num;

        while( l<=r ) {
            long m = (l+r)/2;
            if ( m*m == num ) return true;
            if ( m*m < num ) l = m+1;
            else r = m-1;
        }
        return false;
    }

    // time limit
    // long type
    public boolean isPerfectSquare1(int num) {
        if ( num == 1 ) return true;

        for( int i=num/2; i>1; i-- ) {
            int tmp = num;
            while( tmp%i == 0 && tmp>1 ) {
                tmp /= i;
            }
            if ( tmp == 1 ) return true;
        }
        return false;
    }

    public static void main(String args[] ) {
        ValidPerfectSquare v = new ValidPerfectSquare();
        System.out.println( v.isPerfectSquare(16) );
        System.out.println( v.isPerfectSquare(14) );
        System.out.println( v.isPerfectSquare(1) );
    }
    
}
