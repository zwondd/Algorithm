/*
    210210
   - 백준 #9252 : LCS (Longest Common Subsequence)
   최장 공통 부분 수열
*/

#include <iostream>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;

string mainStr, diffStr, lcs;

int dp[1010][1010];

void printLCS(int x, int y) {
    if ( dp[x][y]==0 ) return;
    if ( mainStr[x-1] == diffStr[y-1] ){
        printLCS(x-1,y-1);
        cout<<mainStr[x-1];
    } else {
        if ( dp[x-1][y] > dp[x][y-1] )  
            printLCS(x-1,y) ;
        else 
            printLCS(x,y-1);
    }
}

int main(void) {
    cin>>mainStr;
    cin>>diffStr;

    for(int i=0; i<mainStr.size(); i++) {
        for(int j=0; j<diffStr.size(); j++) {
            if ( mainStr[i] == diffStr[j] ) {
                dp[i+1][j+1] = dp[i][j]+1;
            } else {
                dp[i+1][j+1] = max(dp[i+1][j], dp[i][j+1]); 
            } 
        }
    }
    cout<<dp[mainStr.size()][diffStr.size()]<<endl;
    printLCS(mainStr.size(), diffStr.size());
}


/*
오답

string mainStr;
string diffStr;

int dp[1010];

int solve(int mIdx, int dIdx) {
    if ( mIdx>=mainStr.size() ) return 0;

    int& ret = dp[mIdx];
    if ( ret!= -1 ) return ret;

    if ( dIdx>=diffStr.size() ) return ret=0;

    int maxS=-1;
    for(int i=dIdx; i<diffStr.size(); i++) {
        if ( diffStr[i]==mainStr[mIdx] )
            maxS = max ( maxS, solve(mIdx+1, i+1)+1 );
    }
    if ( maxS==-1 ) {
        maxS = max ( maxS, solve(mIdx+1, dIdx) );
    }
    return ret=maxS;
}

int main(void) {
    cin>>mainStr;
    cin>>diffStr;

    int maxS=-1;
    memset(dp,-1,sizeof(dp));
    for(int i=0; i<mainStr.size(); i++) {
        maxS=max(maxS, solve(i,0));
    }
    cout<<maxS<<endl;

    for(int i=0; i<mainStr.size()-1;i++) {
        if ( dp[i]!=0 && dp[i]!=dp[i+1])
            cout<<mainStr[i];
    }

    return 0;
}
*/