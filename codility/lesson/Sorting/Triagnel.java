/**
 * 21-02-22
 * 6_Sorting_Triangle
 * 삼각형 조건 : 가장 긴변 < 나머지 두변 합
 */ 
package codility.lesson.Sorting;

import java.util.Arrays;

public class Triagnel {
    // My Solution 1 21min (68%) O(N**3)
    // wrong answer, timeout error
    public int solution1(int[] A) {
        for(int i=0; i<A.length-2; i++) {
            for(int j=i+1; j<A.length-1; j++) {
                for(int k=j+1; k<A.length; k++) {
                    if ( A[i]+A[j] <= A[k] ) continue;
                    if ( A[j]+A[k] <= A[i] ) continue;
                    if ( A[k]+A[i] <= A[j] ) continue;
                    return 1;
                }
            }
        }
        return 0;
    }

    // Other Solution 1 (100%) O(N*log(N))
    // 1. longest < sum of other edges
    // 2. overflow
    // https://siyoon210.tistory.com/128
    public int solution(int[] A) {
        Arrays.sort(A);
        for(int i=0; i<A.length-2; i++) {
            if ( A[i+1]>A[i+2]-A[i] ) {
                return 1;
            }
        }
        return 0;
    }
    
}
