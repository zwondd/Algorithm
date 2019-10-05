// 191005
// 백준 #9095 : 1,2,3 더하기 
// DP

#include <iostream>
using namespace std;

int TC;
int res[12];

void solve(int n, int idx) {
    int dp[12]={0,};
    dp[1]=1;
    dp[2]=2;
    dp[3]=4;

    if(n>3) {
        for(int i=4; i<=n; i++) {
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
    }
    cout<<dp[n]<<endl;

    // res[idx]=dp[n];
}

int main(void) {
    int N;
    cin>>TC;
    for(int i=0; i<TC; i++) {
        cin>>N;
        solve(N,i);
    }
    // for(int i=0; i<TC; i++) 
    //     cout<<res[i]<<endl;

}