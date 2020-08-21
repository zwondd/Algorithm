/*
    200106
   - 백준 #1010 : 다리놓기
 */

#include <stdio.h>
#include <cstring>
using namespace std;

// int T,n,m;
int d[31][31];

// int solve(int n, int m) {
//     if ( n==m || m==0 ) 
//         return 1;
//     if ( d[n][m] ) return d[n][m];
//     return d[n][m] = solve(n-1,m-1) + solve(n-1,m);
// }

int solve2(int n, int m) {
    for(int i=1; i<=m; i++) 
        d[1][i] = i;

    for(int i=2; i<=n; i++) {
        for(int j=i; j<=m; j++) {
            for(int k=j; k>=i; k--) {
                d[i][j] += d[i-1][k-1];
            }
        }
    }
    // cout<<d[n][m]<<endl;

    printf("%d\n",d[n][m]);
}

int main() {
    int T, n, m;
    // int d[31][31] = {0,};
    // cin >> T;
    scanf("%d",&T);
    for(int i=0; i<T; i++) {
        scanf("%d %d", &n, &m);
        // solve(n,m);
        solve2(n,m);
        memset(d,0,sizeof(d));
        // for(int a=0; a<31;a++) {
        //     for(int b=0; b<31; b++) {
        //         d[a][b]=0;
        //     }
        // }
    }

    return 0;
}