#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int series[1010];
int dp[1010];
int N;

int longestLength (int start) {
    if ( start >= N ) return 0;

    int &ret = dp[start];
    if ( ret!= -1 ) return ret;

    ret = 1; // set ret as 1 
    for(int i=start+1; i<N; i++) {
        if ( series[start] > series[i] ) {
            ret = max( ret, longestLength(i)+1 );
        }
    }
    return ret;
}

int main(void) {
    cin>>N;
    for(int i=0; i<N; i++) {
        cin>>series[i];
    }
    memset(dp, -1, sizeof(dp));
    int maxLen=1;
    for(int i=0; i<N; i++) {
        maxLen = max( maxLen, longestLength(i) );
    }
    cout<<maxLen<<endl;
    
    return 0;
}