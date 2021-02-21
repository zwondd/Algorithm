// 21-02-21
// 5_PrefixSums_CountDiv

#include <vector>
#include <algorithm>
#include <cstring>
#include <limits>
using namespace std;

// My Solution 1  4min (50%) O(B-A)
// timeout error
int solution(int A, int B, int K) {
    // write your code in C++14 (g++ 6.2.0)
    int divisible=0;
    for(int i=A; i<=B; i++) {
        if ( i%K==0 ) {
            divisible++;
        }
    }
    return divisible;
}

// My Solution 2  15smin (62%) O(1)
// wrong answer
int solution(int A, int B, int K) {
    return B/K-(A-1)/K;
}

// My Solution 3  2min (87%) 
// wrong answer (MAX_INT case)
int solution(int A, int B, int K) {
    int ans=0;
    if ( A==0 ) ans++;
    return ans+(B/K-(A-1)/K);
}
// My Solution 4  2min (100%) O(1)
int solution(int A, int B, int K) {
    long ans=0;
    if ( A==0 ) {
        ans++;
        ans+=B/K;
    } else {
        ans=(B/K-(A-1)/K);
    }
    return ans;
}