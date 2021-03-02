/**
 * 21-02-27
 * 11_SieveOfEratosthenes_CountNonDivisible
 */
package codility.lesson.SieveOfEratosthenes;

class CountNonDivisible {
    // My Solution 1 (55%) 
    // timeout error
    // Result ) https://app.codility.com/demo/results/trainingWCDARB-M3K/
    public int[] solution1(int[] A) {
        int[] nonDivisors=new int[A.length];

        for(int i=0; i<A.length; i++) {
            int cnt=0;
            for(int j=0; j<A.length; j++){
                if (i==j) continue;

                if ( A[i]%A[j] != 0 ) cnt++;
            }
            nonDivisors[i]=cnt;
        }
        return nonDivisors;
    }

    // Other Solution 1 O(N * log(N))
    // Result ) https://app.codility.com/demo/results/trainingQ8BKWH-WM7/
    // Reference ) https://github.com/dudmy/study/blob/master/Codility/CountNonDivisible.md
    //             https://sustainable-dev.tistory.com/31
    public int[] solution(int[] A) {
        int N=A.length;
        int[] cnt=new int[2*N+1];
        for(int a:A) {
            cnt[a]++;
        }

        int[] divisible=new int[cnt.length];
        for(int i=1; i*i<divisible.length; i++) { 
            // System.out.println("== i : " + i);
            for(int j=i*i; j<divisible.length; j+=i) {
                // System.out.println("j : " + j);

                divisible[j]+=cnt[i];

                if (j!=i*i) {
                    // System.out.println("j!=i*i : " + j);
                    divisible[j]+=cnt[j/i];
                }
            }
        }
        int[] result=new int[N];
        for(int i=0; i<N; i++) {
            result[i]=N-divisible[A[i]];
        }
        return result;
    }

    public static void main(String[] args) {
        CountNonDivisible c=new CountNonDivisible();
        int[] t1={3,1,2,3,6};
        System.out.println(c.solution(t1));
    }
    
}
