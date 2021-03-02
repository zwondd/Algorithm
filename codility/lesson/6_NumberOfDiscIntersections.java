/**
 * 21-02-22
 * 6_Sorting_NumberOfDiscIntersections
 */ 
package codility.lesson.Sorting;

import java.util.Arrays;

class NumberOfDiscIntersections {
   
    // My Solution 1 26min (6%)
    // wrong answer, timeout error
    public int solution1(int[] A) {
        int ans=0;

        for(int i=0; i<A.length-1; i++) {
            for(int j=i+1; j<A.length; j++) {
                long right=i+A[i];
                long left=j+A[j];

                if ( right <= left ) ans++;
            }
        }
        return ans;
    }

    // My Solution 2 20min (6%)
    // wrong answer, timeout error
    public int solution2(int[] A) {
        int ans=0;

        for(int i=0; i<A.length-1; i++) {
            for(int j=i+1; j<A.length; j++) {
                if ( A[i]+A[j] > Math.abs(j-i) ) ans++;
            }
        }
        if ( ans>10000000 ) ans=-1;
        return ans;
    }

    // Other Solution 1 (100%) O(N*log(N)) or O(N)
    // https://darkstart.tistory.com/195
    public int solution3(int[] A) {

        // store all upper, lower points
        // count intersection (upper > lower)

        long[] lower = new long[A.length];
        long[] upper = new long[A.length];

        for(int i=0; i<A.length; i++) {
            lower[i] = i - (long)A[i];
            upper[i] = i + (long)A[i];
        }

        Arrays.sort(upper);
        Arrays.sort(lower);
        
        int intersection=0;
        int j=0;

        for(int i=0; i<A.length; i++) {
            while( j<A.length && upper[i]>=lower[j] ) {
                intersection = intersection+j;
                intersection = intersection-i;  // avoid double count
                j++;
            }
        }
        
        if ( intersection>10000000 ) return -1;
        return intersection;
    }

    // Other Solution 2 (68%) O(N**2) 
    // (100% in javascript)
    // https://miiingo.tistory.com/326
    public int solution(int[] A) {

        long[] lower = new long[A.length];
        long[] upper = new long[A.length];

        for(int i=0; i<A.length; i++) {
            lower[i] = i - (long)A[i];
            upper[i] = i + (long)A[i];
        }

        Arrays.sort(upper);
        Arrays.sort(lower);
        
        int intersection=0;

        for(int i=0; i<A.length-1; i++) {
            for(int j=i+1; j<A.length;j++) {
                if ( intersection > 10000000 ) return -1; 

                if ( lower[j] > upper[i] ) 
                    break;

                if ( lower[j]>=lower[i] && lower[j]<=upper[i] ) 
                    intersection++;
            }
        }
        return intersection;
    }


    public static void main(String[] args) {
        NumberOfDiscIntersections sol=new NumberOfDiscIntersections();
        int[] P={1,5,2,1,4,0};
        System.out.println(sol.solution(P));
    }
    
}
