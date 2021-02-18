// 21-02-18
// 4_CountingElements_PermCheck

#include <vector>
#include <algorithm>
#include <cstring>
#include <limits>
using namespace std;

// My Solution 1  6min (66%) 
// wrong answer 
int solution(vector<int> &A) {
    // write your code in C++14 (g++ 6.2.0)
    int ans=1;
    sort(A.begin(), A.end());
    for(int i=0; i<A.size()-1; i++) {
        if ( A[i+1]!=A[i]+1 ) {
            ans=0;
            break;
        }
    }
    return ans;
}

// My Solution 2  3min (83%)  O(N) or O(N * log(N))
// wrong answer 
#include <algorithm>
int solution(vector<int> &A) {
    int ans=1;
    sort(A.begin(), A.end()); 
    
    // ERROR CASE
    // 1. single element 
    // 2. extreme_min_max 
    for(int i=0; i<A.size()-1; i++) {
        if ( A[0]!=1 ) {
            ans=0;
            break;
        }
    
        if ( A[i+1]!=A[i]+1 ) {
            ans=0;
            break;
        }
    }
    return ans;
}

// My Solution 3  4min (100%)  O(N) or O(N * log(N))
int solution(vector<int> &A) {
    int ans=1;
    sort(A.begin(), A.end());
    if (A[0]!=1) {
        ans=0; 
        return ans;
    }
    for(int i=0; i<A.size()-1; i++) {
        if ( A[i]+1 != A[i+1] ) {
            ans=0;
            break;
        }
    }
    return ans;
}