// 21-02-17
// 4_CountingElements_MaxCounter

#include <vector>
#include <algorithm>

using namespace std;

// My Solution 1 (22%) 27min 
// wrong answer, timeout error
#include <algorithm>
vector<int> solution(int N, vector<int> &A) {
    vector<int> arr (N+1);
    int maxCnt=0;
    for(int i=0; i<A.size(); i++) {
        if ( A[i]==N+1 ) {
            fill(arr.begin(), arr.end(), maxCnt);
        } else {
            arr[A[i]]+=1;
            maxCnt=max(maxCnt, arr[A[i]]);
        }
    }
    arr.erase(arr.begin());
    return arr;
}

// My Solution 2 (77%) 
// timeout error 
#include <algorithm>
vector<int> solution(int N, vector<int> &A) {
    vector<int> arr (N+1);
    int maxCnt=0;
    for(int i=0; i<A.size(); i++) {
        if ( A[i]==N+1 ) {
            fill(arr.begin(), arr.end(), maxCnt);
        } else {
            arr[A[i]]+=1;
            maxCnt=max(maxCnt, arr[A[i]]);
        }
    }
    arr.erase(arr.begin());
    return arr;
}

// Other Solution 1 (100%) O(N + M)
vector<int> solution(int N, vector<int> &A) {
    vector<int> arr (N);
    int maxCnt=0;
    int finalMaxCnt=0;
    for(int i=0; i<A.size(); i++) {
        if ( A[i]==N+1 ) {
            finalMaxCnt=maxCnt;
        } else {
            arr[A[i]-1]=max(finalMaxCnt, arr[A[i]-1])+1;
            // maxCnt=arr[A[i]-1];  //wrong
            maxCnt=max(maxCnt, arr[A[i]-1]);
        }
    }
    for(int i=0; i<arr.size(); i++) {
        arr[i]=max(arr[i], finalMaxCnt);
    }
    return arr;
}