/*
   201207
   백준 #15486 : 퇴사2(DP)
 */

#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

#define MAX_DAY = 1500010

int cache[1500010];
int T[1500010];
int P[1500010];
int N;

// Sol1. runtime over
#if 0
int calMaxSal(int day) {
    int& ret=cache[day];
    
    if ( day+T[day]-1>N ) {
        return 0;
    } 
    if ( day+T[day]-1 == N ) {
        ret=P[day];
        return ret;
    }
    if ( ret!=-1 ) return ret;  
    for(int i=day+T[day]; i<=N; i++) {
        ret = max(ret, calMaxSal(i));
    }
    return ret+P[day];
}

int main(void) {
    cin>>N; 
    for(int i=1; i<=N; i++) {
       cin>>T[i]>>P[i]; 
    }
    memset(cache, -1, sizeof(cache));
    cout<<calMaxSal(1)<<endl;
    return 0;
}
#endif

int main(void) {
    cin>>N; 
    memset(cache, 0, sizeof(cache));
    for(int i=1; i<=N; i++) {
       cin>>T[i]>>P[i]; 
    }
    for(int i=N; i>=1; i--) {
        if ( i+T[i] > N+1 ) {
            cache[i]=cache[i+1];
        } else {
            cache[i]=max(cache[i+1], P[i]+cache[i+T[i]]);
        }
    }
    cout<<cache[1]<<endl;
    return 0;
}