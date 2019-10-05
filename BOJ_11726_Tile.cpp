// 191005
// 백준 #11726 : 2xn 타일링 
// DP - dp 연산 할 때마다 나눈값을 저장해야 런타임에러 안남.

#include <iostream>
using namespace std;

int N;
int dp[1001];

int solve(int n) {
    dp[1]=1;
    dp[2]=2;

    if(n>2) {
        for(int i=3; i<=n; i++) {
            dp[i]=(dp[i-1]+dp[i-2])%10007;
        }
    }

    return dp[n];
}

int main(void) {
    cin>>N;
    cout<<solve(N);
}