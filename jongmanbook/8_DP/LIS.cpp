#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>

using namespace std;

// Solution 1. Brute Force 
// comment is code before referencing solution (wrong answer)
// int getLongest (vector<int>& subseq) {
#if 0
int getLongest (const vector<int>& subseq) {
    if ( subseq.empty() ) return 0;
    int ret=0;
    for(int i=0; i<subseq.size(); i++) {
        vector<int> bigger;
        // int start = subseq[i];
        for(int j=i+1; j<subseq.size(); j++) {
            if ( subseq[j] > subseq[i] ) {
                bigger.push_back(subseq[j]);
            }
        }
        // return max(ret, getLongest(bigger)+1); // 먼저 return을 해버리면 i~subseq.size() 까지 모두 탐색하기 전에 return 됨.
        ret = max(ret, 1+getLongest(bigger));
    }
    return ret;
}

int main(void) {
    vector<int>  test = {1, 5, 2, 4, 7};
    cout<<getLongest(test)<<endl;

    return 0;
}
#endif


// Solution 2. DP- memoization
// definition of partial problem : lis2(start) = maximum LIS that starts at S[start]
#if 0
int n;
int cache[100];
int S[100]={1, 5, 2, 4, 7};
int lis2(int start) {
    int& ret= cache[start];
    if ( ret!=-1 ) return ret;

    ret=1;
    for(int next=start+1; next<n; ++next) {
        if ( S[start] < S[next] ) {
            ret=max(ret, lis2(next)+1);
        }
    }
    return ret;
}

int main(void) {
    int maxLen=0;
    memset(cache, -1, sizeof(cache));
    n=5;
    for(int begin=0; begin<n; ++begin) {
        maxLen = max(maxLen, lis2(begin));
    }
    cout<<maxLen<<endl;

    return 0;
}
#endif 

// Solution 3. DP- memoization
// Remove iteration from 0~S.size() in main thread
// if S[-1]= -infinite, only calling lis3(-1) will iterate all the element in S 
// (since S[-1]<S[x] is always true)

int n;
int cache[101], S[100];

int lis3(int start) {
    int& ret=cache[start+1];
    if ( ret!=-1 ) return ret;
    ret=1;
    for(int next=start+1; next<n; ++next) {
        if ( start==-1 || S[start]<S[next] ) {
            ret = max( ret, lis3(next)+1 );
        }
    }
    return ret;
}