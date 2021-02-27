/**
 * 21-02-26
 * 10_PrimeAndCompositeNumbers_Flags
 */
package codility.lesson.PrimeAndCompositeNumbers;

import java.util.*;

public class Flags {
    // My Solution 1 (80%) O(N)
    // wrong answer
    // https://app.codility.com/demo/results/trainingBVC48N-YHV/
    public int solution1(int[] A) {
        int[] peeks=new int[A.length];

        if ( A.length<=2 ) return 0;

        int pIdx=0;
        for(int i=1; i<A.length-1; i++) {
            if ( A[i]>A[i-1] && A[i]>A[i+1] ) {
                peeks[pIdx++]=i;
            }
        }

        if ( pIdx<=0 ) return 0;

        int i=0;
        int maxFlag=1;
        for(i=2; i<pIdx; i++) {
            int flag=i;
            int curPeek=0;
            int nextPeek=curPeek+1;

            // System.out.println("i : " + i);

            while( peeks[curPeek] <= peeks[nextPeek] && nextPeek<pIdx ) {
            // System.out.println("pIdx " + pIdx + " peeks[curPeek] : " + peeks[curPeek] + " peeks[nextPeek] : " + peeks[nextPeek]);

                if ( peeks[nextPeek] - peeks[curPeek] >= i ) {
                    flag--;
                    curPeek=nextPeek;
                    nextPeek+=1;
                } else {
                    nextPeek+=1;
                }

                if ( flag==1 ) break;
            }
            // System.out.println("flag : " + flag);
            if ( flag==1 ) {
                maxFlag=i;
            } else {
                maxFlag=i-1;
                break;
            }
            curPeek=0;
            nextPeek=curPeek+1; 

        }
        return maxFlag;
    }

    // Other Solution 1 (66%) 
    // timeout error
    // 결과 ) https://app.codility.com/demo/results/trainingBUBGEK-UHP/
    // 참고 ) https://sweetroute.tistory.com/entry/CodilityFlags
    public int solution2(int[] A) {
        if ( A.length<3 ) return 0;

        List<Integer> peaks = new ArrayList<Integer>();

        for(int i=1; i<A.length-1; i++) {
            if ( A[i]>A[i-1] && A[i]>A[i+1] ) {
                peaks.add(i);
            }
        }

        if ( peaks.size()<3 ) {
            return peaks.size();
        }

        int output=0;
        for(int k=2; k<=peaks.size(); k++) {
            int flags=1;
            int curPeek=0;
            int nextPeek=1;

            while( curPeek<peaks.size()-1 ) {
                if ( Math.abs(peaks.get(nextPeek)-peaks.get(curPeek)) >= k ) {
                    flags+=1;
                    curPeek=nextPeek;
                    nextPeek+=1;
                } else {
                    nextPeek+=1;
                }

                if ( nextPeek==peaks.size() || flags==k ) break;
            }
            if ( output>flags ) return output;
            output = Math.max(flags, output);
        }
        return output;
    }

    // Other Solution 2 O(N)
    // Other Solution 1 과 동일한데 사용한 자료형만 다름...
    // 결과 ) https://app.codility.com/demo/results/trainingNXGK57-RTQ/
    // 참고 ) https://sweetroute.tistory.com/entry/CodilityFlags
    public int solution(int[] A) {
        if ( A.length<3 ) return 0;
        int[] peaks = new int[A.length];

        int pIdx=0;
        for(int i=1; i<A.length-1; i++) {
            if ( A[i]>A[i-1] && A[i]>A[i+1] ) {
                peaks[pIdx++]=i;
            }
        }

        if ( pIdx<3 ) {
            return pIdx;
        }

        int output=0;
        for(int k=2; k<=pIdx; k++) {
            int flags=1;
            int curPeek=0;
            int nextPeek=1;

            while( curPeek<pIdx-1 ) {
                if ( peaks[nextPeek]-peaks[curPeek]>=k ) {
                    flags+=1;
                    curPeek=nextPeek;
                    nextPeek+=1;
                } else {
                    nextPeek+=1;
                }

                if ( nextPeek==pIdx || flags==k ) break;
            }
            if ( output>flags ) return output;
            output = Math.max(flags, output);
        }
        return output;
    }



    public static void main(String args[]) {
        Flags f=new Flags();

        int[] t1= {1,5,3,4,3,4,1,2,3,4,6,2};
        System.out.println(f.solution(t1));

        int[] t2= {1,3,1};
        System.out.println(f.solution(t2));
        
        int[] t3= {1,5,5};
        System.out.println(f.solution(t3));

        
    }
}
