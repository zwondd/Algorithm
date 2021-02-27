/**
 * 21-02-27
 * 10_PrimeAndCompositeNumbers_Peeks
 */
package codility.lesson.PrimeAndCompositeNumbers;

public class Peeks {
    // My Solution 1 (36%) 
    // wrong answer
    // https://app.codility.com/demo/results/training7FYXVE-HVU/
    public int solution1(int[] A) {
        if ( A.length<3 ) return 0;
        int[] peaks = new int[A.length];
        int pLen=0;
        for(int i=1; i<A.length-1; i++) {
            if ( A[i]>A[i-1] && A[i]>A[i+1] ) {
                peaks[pLen++]=i;
            }
        }

        if ( pLen<=1 ) return pLen;

        int pPos=0;
        int start=0;
        int end=A.length-1;
        int maxBlock=0;

        for(int block=1; block<=pLen; block++) {
            if ( A.length%block !=0 ) continue;

            // System.out.println("block : " + block);

            int blockToCheck=block;
            int blockSize=A.length/block;
            end=start+blockSize-1;
            
            while( end<A.length ) {
                // System.out.println("start : " + start+ " end : " + end + " pLen : " + pLen );
                // System.out.println(" peaks[pPos] " +peaks[pPos]);
                if ( peaks[pPos]>=start && peaks[pPos]<=end ) {
                    blockToCheck--;
                    pPos++;
                    start=end+1;
                    end=start+blockSize-1;
                } else {
                    pPos++;
                }
                if ( blockToCheck==0 || end<pLen || pPos>=pLen ) break;
            }

            // System.out.println("blockToCheck : " + blockToCheck);

            if ( blockToCheck!=0 ) break;

            maxBlock=Math.max(maxBlock, block);
            pPos=0;
            start=0;
        }
        return maxBlock;
    }

    // Other Solution 1 (63%) 
    // wrong answer
    // 결과) https://app.codility.com/demo/results/trainingV6VB8V-2F5/
    // 참고) https://sustainable-dev.tistory.com/28
    // 
    //  fix 1) (100%) O(N * log(log(N)))
    //  결과 ) https://app.codility.com/demo/results/trainingRX2US4-XQ3/
    public int solution(int[] A) {
        if ( A.length<3 ) return 0;

        int[] peaks = new int[A.length];
        int pLen=0;
        for(int i=1; i<A.length-1; i++) {
            if ( A[i]>A[i-1] && A[i]>A[i+1] ) {
                peaks[pLen++]=i;
            }
        }

        if ( pLen<=1 ) return pLen;

        for(int i=pLen; i>=2; i--) {
            if ( A.length%i==0 ) {
                int k=A.length/i;
                int cntBlock=0;

                for(int j=0; j<pLen; j++) {
                    int start=cntBlock*k;
                    int end=(cntBlock+1)*k;
                    if ( peaks[j]>=start && peaks[j]<end ) { // fix 1)
                        cntBlock++;
                    }
                }
                if ( cntBlock==i ) return i;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        Peeks p=new Peeks();
        int[] t1={1,2,3,4,3,4,1,2,3,4,6,2};
        System.out.println(p.solution(t1));
    }
    
}
