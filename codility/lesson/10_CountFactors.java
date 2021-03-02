/**
 * 21-02-26
 * 10_PrimeAndCompositeNumbers_CountFactors
 */

package codility.lesson.PrimeAndCompositeNumbers;

class CountFactors {
    // My Solution 1 (71%) O(N)
    // timeout error
    public int solution1(int N) {
        int cnt=0;
        for(int i=1; i<=N; i++) {
            if ( N%i==0 ) cnt++;
        }
        return cnt;
    }

    // My Solution 2 (85%) O(sqrt(N)) or O(N)
    // timeout error
    public int solution2(int N) {
        int cnt=0;
        for(int i=1; i<=N; i++) {
            if ( N%i==0 ) {
                if ( N/i==i ) {
                    cnt=cnt*2+1;
                    break;
                }
                if ( N/i<i ) {
                    cnt*=2;
                    break;
                }
                cnt++;
            };
        }
        return cnt;
    }

    // Other Solution 1 (92%) O(sqrt(N)) 
    // timeout error
    // MAX_INT case error...차이가 뭘까
    public int solution3(int N) {
        int cnt=0;
        int i=1;
        while ( N>i*i ) {
            if ( N%i==0 ) cnt+=2;
            i++;
        }
        if (N==i*i ) cnt+=1;
        
        return cnt;
    }

    // Other Solution 2 (100%) O(sqrt(N)) 
    // timeout error
    public int solution(int N) {
        int cnt = 0; 
        long i = 1;     // i의 type 차이..?
        while(i * i < N){ 
            if(N % i == 0) { 
                cnt++; 
            } 
            i++; 
        } 
        cnt = cnt*2; 
        if(i * i == N) { 
            cnt++; 
        } 
        return cnt;
    }



}
