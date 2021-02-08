/*
    210209
   - 백준 #11066 : 파일합치기
   - 풀이참조 : https://junkwon-dev.github.io/ps/boj-11066/
 */
#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int fileCnt;
int C[510];
int dp[510][510];

int getMinFileSize(int s, int e) {
    // cout<<"s : "<<s<<" e : "<<e<<endl;
    if ( s==e ) return 0;

    int& ret = dp[s][e];
    if( ret != -1 ) return ret;

    int sum=0;
    for(int i=s; i<=e; i++) {
        sum+=C[i];
    }

    int minFileSize=987654321;
    int ans = -1;
    for(int i=s; i<e; i++) {
        int tmp = getMinFileSize(s,i)+getMinFileSize(i+1,e) + sum;
        if (ans==-1 || ans>tmp) {
            ans=tmp;
        }
    }
    return dp[s][e]=ans;
}

int main(void) {
    int TC;
    cin>>TC;
    for(int i=0; i<TC; i++) {
        cin>>fileCnt;
        memset(dp, -1, sizeof(dp));

        for(int j=1; j<=fileCnt; j++) {
            cin>>C[j];
        }
        cout<<getMinFileSize(1,fileCnt)<<endl;
        // int fileSizeSum=0;
        // for(int j=2; j<=fileCnt;j++)
        // fileSizeSum+=dp[j-1][j];
        // cout<<fileSizeSum<<endl;
    }
}