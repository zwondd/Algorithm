#include <vector>
#include <algorithm>

using namespace std;

// 21-02-15
// My Solution (66%) timeout O(N^2)

int solution(vector<int> &A) {
    for(unsigned int i=0; i<A.size(); i++) {
        if ( A[i]==-1 ) continue;
        for(unsigned j=i+1; j<A.size(); j++) {
            if ( A[i]==A[j] ) {
                A[i]=-1; 
                A[j]=-1;
            }
            continue;
        }
    }
    unsigned int i=0;
    for(i=0; i<A.size(); i++) {
        if ( A[i]!=-1 ) break;
    }
    return A[i];
}


// My Solution 2
// sort -> check

// 100%
// Detected time complexity: O(N) or O(N*log(N))
int solution(vector<int> &A) {
    sort(A.begin(), A.end());
    unsigned int i=0;
    for(i=0; i<A.size()-1; i+=2) {
        if ( A[i]!=A[i+1] ) break;
    }
    return A[i];
}

// Other Solution 
// XOR  (if two bits are differtn -> 1 else -> 0)
int solution(vector<int> &A) {
    int result=0;
    for(int i=0; i<A.size(); i++) {
        result=result^A[i];
    }
    return result;
}
