/**
 * 21-06-06
 * 13_FibonacciNumbers_FibFrog
 */
package codility.lesson;

import java.util.*;

class FiboFrog2 {
    int N;
    List<Integer> fibo = new ArrayList<>();

    public void getFibonacci( int cur, int max ) {
        if ( cur>max ) return;

        int tmp = fibo.get(cur-1) + fibo.get(cur-2);
        fibo.add(tmp);
        getFibonacci(cur+1, max);
    };

    public int solution(int[] A) {
        N = A.length;
        fibo.add(0);
        fibo.add(1);
        if ( N>2 ) {
            getFibonacci(2, N-1);
        }
        Collections.reverse(fibo);
        for(int i: fibo) {
            System.out.print( " - " + i );
        }
        return 0;
    }


    public static void main(int[] args) {
        int[] A = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};

        FiboFrog2 s = new FiboFrog2();
        s.solution(A);
    }
}
