/**
 * 21-02-24 
 * 8_Leader_Dominator
 */
package codility.lesson._8_Leader;

import java.util.*;

class Dominator {
    // My Solution 1 (91%) O(N*log(N)) or O(N)
    // fix1) (100%) O(N*log(N)) or O(N)
    public int solution1(int[] A) {
        if ( A.length==0 ) return -1;
        if ( A.length==1 ) return 0; // fix1) single element case

        Map<Integer, Integer> candidate=new HashMap<Integer,Integer>();
        for(int i=0; i<A.length; i++) {
            if ( candidate.containsKey(A[i]) ) {
                int tempCnt=candidate.get(A[i]);
                tempCnt++;
                candidate.replace(A[i], tempCnt);
                if ( tempCnt>A.length/2 ) return i;
            } else {
                candidate.put(A[i],1);
            }
        }
        return -1;
    }

    // Other Solution 1 
    public int solution(int[] A) {
        int len=A.length;
        int dominatorCnt=0;
        int dominatorIdx=0;
        int candidate=0;
        int count=0;
        int idx=-1;

        for(int i=0; i<len; i++) {
            if ( dominatorCnt==0 ) {
                dominatorCnt+=1;
                dominatorIdx=i;

            } else {
                if ( A[dominatorIdx]==A[i] ) {
                    dominatorCnt+=1;
                } else {
                    dominatorCnt-=1;
                }
            }
        }

        if ( dominatorCnt>0 ) 
            candidate=A[dominatorIdx];
        for(int i=0; i<len; i++) {
            if ( A[i]==candidate ) {
                count++;
                idx=i;
            }
        }
        if ( count>len/2) 
            return idx;

        return -1;
    }

    public static void main(String[] args){
        Dominator d=new Dominator();
        int[] test = {3,4,3,2,3,-1,3,3};
        System.out.println(d.solution(test));
    }
}
