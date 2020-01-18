// 200118
// 백준 #2293 : 동전 1
// DP : 본 풀이 방법으로는 메모리 초과됨.
// 4Bytes x (101+101x10001) = 4,080,408 Bytes = 약 3.9MB

#include <iostream>

int n, k;
int c[101];
// int dp[10001];

int d[101][10001];

int main() {
    scanf("%d %d", &n, &k);

    for(int i=1; i<=n; i++) {
        scanf("%d", &c[i]);
        d[i][0]=1;
    }

    for(int i=1; i<=n; i++) {
        for(int j=1; j<=k; j++) {
            d[i][j]=d[i-1][j] + d[i][j-c[i]]; 
            // printf("  d[%d][%d] : %d \n", i,j, d[i][j]);
        }
    }

    printf("%d", d[n][k]);

    return 0;
}