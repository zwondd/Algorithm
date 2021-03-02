/**
 * 21-03-02
 * 12_Euclidean_CommonPrimeDivisors
 */
package codility.lesson._12_Euclidean;

import java.util.*;

public class CommonPrimeDivisors 
{
    // My Solution 1 (71min) (23%) 
    // wrong answer, runtime error, timeout error
    // Result ) https://app.codility.com/demo/results/trainingZ9RRWA-XBD/
    public int solution1(int[] A, int[] B) {
        int maxPrime=0;
        List<Integer> primes=new ArrayList<>();
        primes.add(2);
        int result=0;

        for(int i=0; i<A.length; i++) {
            int minNum= Math.min(A[i], B[i]);
            if ( minNum>maxPrime ) {
                maxPrime=minNum;
                isPrimeNumber(maxPrime, primes);
            }
            int cntA=0;
            int cntB=0;

            for(int j=0; j<primes.size(); j++) {
                int cmpPrime= primes.get(j);
                if ( cmpPrime > A[i] || cmpPrime >B[i] ) 
                    break;

                if ( A[i]%cmpPrime==0 ) cntA++;
                if ( B[i]%cmpPrime==0 ) cntB++;
                if ( cntA!=cntB ) break; // added
                // System.out.println("cntA : " +cntA + " cntB : " + cntB);
            }
            if ( cntA==cntB && cntA!=0 ) result++;
            // System.out.println("result : " +result);
        }
        return result;
    }

    public void isPrimeNumber(int k, List<Integer> list) {
        int lastPrime=list.get(list.size()-1);
        
        for(int i=lastPrime+1; i<=k; i++) {
            int j=2;
            boolean isPrime=true;
            while(j*j<i) {
                if ( i%j==0 ) {
                    isPrime=false; 
                    break;
                }
                j++;
            }
            if ( isPrime ) {
                list.add(i);
            }
        }
    }


    // Other Solution 1 (71min) (23%) 
    // 풀이 ) gcd(x,y)=1 이면 (x,y가 서로소라면) 공유하는 소수가 없다.
    //        g=gcd(x,y) 일 때, gcd(x,g)=1 이면 x,y 사이에 공유하지 않는 소수가 존재함.
    // 
    // Result ) https://app.codility.com/demo/results/training3EQ3WJ-AUK/
    // 
    // 참고) https://mkki.github.io/codility/2018/05/31/codility-common-prime-divisors.html
    //       https://velog.io/@ahj1592/Codility-12.2-CommonPrimeDivisors

    public int solution(int[] A, int[] B) {
        int len=A.length;
        int result=0;

        for(int i=0; i<len; i++) {
            if ( isSameDivisors(A[i],B[i])) {
                result++;
            }
        }
        return result;
    }

    private int gcd(int a, int b) {
        if ( a%b == 0 ) {
            return b;
        }
        return gcd(b, a%b);
    }

    private boolean isSameDivisors(int a, int b) {
        int gcdAB=gcd(a,b);
        int gcdA=0;
        int gcdB=0;

        while( gcdA!=1 ) {
            gcdA=gcd(a, gcdAB);
            a/=gcdA;
        }
        
        while( gcdB!=1 ) {
            gcdB=gcd(b, gcdAB);
            b/=gcdB;
        }

        return ( a==1 && b==1 ) ? true:false;
    }

    public static void main(String[] args) {
        CommonPrimeDivisors c=new CommonPrimeDivisors();
        // Solution s=new Solution();
        int[] a1={15, 10, 3};
        int[] b1={75, 30, 5};
        System.out.println(c.solution(a1, b1));

        // int[] a2={2, 3, 5};
        // int[] b2={2, 3, 10};
        // System.out.println(c.solution(a2, b2));

        // int[] a3={7, 61, 88, 121};
        // int[] b3={14, 2, 5, 11};
        // System.out.println(c.solution(a3, b3));
    }}