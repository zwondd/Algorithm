/**
 * 21-02-28
 * 11_SieveOfEratosthenes_CountSemiprimes
 */
package codility.lesson.SieveOfEratosthenes;

import java.util.*;

class CountSemiprimes {
    // My Solution 1 (34min) (11%) 
    // wrong answer, runtime error, timeout error
    // Result ) https://app.codility.com/demo/results/trainingGJWGMG-AN9/ 
    
    // fix 1) (55%) O(N * log(log(N)) + M * N) or O(M * N**3) or O(M * N ** (3/2))
    // only timeout error
    // fix 1 Result ) https://app.codility.com/demo/results/trainingRWM4HS-CEV/
     
    // timeout 추측 : semiPrimes를 전체 배열로 가지고 있어서 loop 연산시 timeout error 난게 아닐까

    public int[] solution1( int N, int[] P, int[] Q ) {
        int[] primes=new int[N+1];
        int[] semiPrimes=new int[N+1];
        int[] result=new int[P.length];

        Arrays.fill(primes, 1);
        Arrays.fill(semiPrimes, 0);

        primes[1]=0;
        for(int i=2; i*i<=N; i++) {
            if ( primes[i]==1 ) { // fix 1)
                for(int j=i*i; j<=N; j+=i) {
                    primes[j]=0;
                }
            }
        }
        for(int i=2; i<N; i++) {
            for(int j=i; j<=N; j++) { // fix 1)
                if ( primes[i]==1 && primes[j]==1 && i*j<=N ) {
                    semiPrimes[i*j]=1;
                }
            }
        }
        for(int i=2; i<=N; i++) {
            semiPrimes[i]+=semiPrimes[i-1];
        }
        for(int i=0; i<P.length; i++) {
            result[i]=semiPrimes[Q[i]]-semiPrimes[P[i]-1];
        }
        return result;
    }

    // Other Solution 1 참고 (100%) O(N * log(log(N)) + M)
    // Result ) https://app.codility.com/demo/results/trainingX5GKVS-BZ5/
    // Reference ) https://mkki.github.io/codility/2018/05/31/codility-count-semiprimes.html
    public int[] solution( int N, int[] P, int[] Q ) {
        boolean[] isPrime=new boolean[N+1];
        List<Integer> primes=new ArrayList<Integer>();
        int[] semiPrimes=new int[N+1];
        int[] result=new int[P.length];

        Arrays.fill(isPrime, true);

        for(int i=2; i*i<=N; i++) {
            if ( isPrime[i]==true ) { 
                for(int j=i*i; j<=N; j+=i) {
                    isPrime[j]=false;
                }
            }
        }
        for(int i=2; i<=N; i++) {
            if ( isPrime[i]== true ) primes.add(i);
        }
        for(int i=0; i<primes.size(); i++) {
            for(int j=0; j<primes.size(); j++) {
                int semiPrimeCandidate=primes.get(i)*primes.get(j);

                if ( semiPrimeCandidate>N ) break;
                semiPrimes[semiPrimeCandidate]=1;
            }
        }
        for(int i=1; i<=N; i++) semiPrimes[i]+=semiPrimes[i-1];
        for(int i=0; i<P.length; i++) {
            result[i]=semiPrimes[Q[i]]-semiPrimes[P[i]-1];
        }
        return result;
    }

    public static void main(String[] args) {
        CountSemiprimes c=new CountSemiprimes();
        int[] p1 = {1,4,16};
        int[] q1 = {26,10,20};

        System.out.println(Arrays.toString(c.solution(26, p1, q1)));
    }
    
}
