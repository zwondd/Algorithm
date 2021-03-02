/**
 * 21-02-27
 * 10_PrimeAndCompositeNumbers_MinPerimeterRectangle
 */
package codility.lesson.PrimeAndCompositeNumbers;

class MinPerimeterRectangle {
    // My Solution 1 (100%) O(sqrt(N))
    // https://app.codility.com/demo/results/trainingCCPVBU-QV3/
    public int solution(int N) {
        long i=1;
        // int a=Integer.MAX_VALUE;  // int로 해도 100% 나옴
        long minPerimeter=Long.MAX_VALUE;
        while( i*i<N ) {
            if ( N%i==0 ) {
                long x=i;
                long y=N/i;
                minPerimeter=Math.min( minPerimeter, 2*(x+y) );
            }
            i++;
        }
        if ( i*i==N ) {
            minPerimeter=Math.min( minPerimeter, 4*i );
        }
        return (int)minPerimeter;
    }
    
}
