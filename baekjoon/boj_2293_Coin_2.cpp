// 200118
// 백준 #2293 : 동전 1
// DP

#include <iostream>

int n, k;
int c[101];
int dp[10001];

int main() {
    scanf("%d %d", &n, &k);

    for(int i=1; i<=n; i++) {
        scanf("%d", &c[i]);
    }

    dp[0]=1;

    for(int i=1; i<=n; i++) {
        for(int j=1; j<=k; j++) {
            if(j>=c[i]) 
                dp[j] += dp[j-c[i]];
        }
    }

    printf("%d", dp[k]);

    return 0;
}