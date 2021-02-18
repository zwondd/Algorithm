// 21-02-18
// 4_CountingElements_MissingInteger

#include <vector>
#include <algorithm>
#include <cstring>
#include <limits>
using namespace std;

// My Solution 1  6min (100%) O(N) or O(N * log(N))
int solution(vector<int> &A) {
    // write your code in C++14 (g++ 6.2.0)
    sort(A.begin(), A.end());
    int minInteger=1;

    for(int i=0; i<A.size();i++) {
        if ( A[i]==minInteger ) minInteger++;
        else if ( A[i]>minInteger ) break;
    }
    return minInteger;
}

// Other Solution 2  (100%) O(N) or O(N * log(N))
// Nodejs
// function solution(A) {
//     // write your code in JavaScript (Node.js 8.9.4)
//     const set = new Set(A);
//     const size = set.size;
    
//     for(let i=1; i<=size; i++){
//         if(!set.has(i)){
//             return i;
//         }
//         continue;
//     }
    
//     return size+1;
// }