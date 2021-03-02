/**
 * 21-02-28
 * 12_Euclidean_ChocolatesByNumbers
 */
package codility.lesson._12_Euclidean;

import java.util.*;

public class ChocolatesByNumbers {

    public int solution1(int N, int M) {
        int[] emptyWrappers=new int[N];
        int cnt=0;
        for(int i=0; i<N; i++) {
            if ( emptyWrappers[(i+M)%N]==0 ) {
                emptyWrappers[(i+M)%N] = 1;
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }
    public int solution2(int N, int M) {
        List<Integer> wrappers=new LinkedList<Integer>();
        for(int i=0; i<N; i++) {
            wrappers.add(i);
        }
        int pos=0;
        while( !wrappers.isEmpty() ) {
            if ( wrappers.contains(pos) ) {
                wrappers.remove(wrappers.lastIndexOf(pos));
            } else {
                break;
            }
            pos=(pos+M)%N;
        }
        return N-wrappers.size();
    }

    // Other Solution 1  O(log(N + M))
    // 결국 N, M의 최대공약수 구하는 것.
    // Result ) https://app.codility.com/demo/results/trainingMK7EXD-NUF/
    public int solution(int N, int M) {
        int temp=N;
        int R=N/M;
        if ( M*R == N ) {
            return R;
        }
        while( N%M!=0 ) {
            R=N%M;
            N=M;
            M=R;
        }
        return temp/R;
    }
    
}
