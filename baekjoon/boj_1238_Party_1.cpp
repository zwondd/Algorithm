/*
   200830
   백준 #1238 : 파티 (다익스트라)
   Floyd Warshall success
   1. 다익스트라. 연결되지않은 간선 비용 처음에 INF(infinite) 최대값으로 지정
   2. 최소값 배열에 업데이트
 */

#include <iostream>
#include <algorithm>
using namespace std;

int N, M, X;
int MAX = 10000000;
int arr[1000+10][1000+10] = {0,};

int main() {
    scanf("%d %d %d", &N, &M, &X);
    for(int i=1; i<=N; i++) {
        for(int j=1; j<=N; j++) {
            arr[i][j] = MAX;
        }
        arr[i][i] = 0;
    }
    for(int i=0; i<M; i++) {
        int x, y, val;
        scanf( "%d %d %d",&x, &y, &val );
        arr[x][y] = min(arr[x][y], val);
    }
    for(int k=1; k<=N; k++) {
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                arr[i][j] = min(arr[i][j], arr[i][k]+arr[k][j]);
                // if ( arr[i][k] != 0 && arr[j][k] != 0 ) {
                //     if (arr[i][j] == 0) {
                //         arr[i][j] = arr[i][k]+arr[k][j];
                //     } else {
                //         arr[i][j] = (arr[i][j] > arr[i][k]+arr[k][j] ) ? arr[i][k]+arr[k][j] : arr[i][j];
                //     }
                // }
            }
        }
    }

    int sol = 0;
    for(int i=1; i<=N; i++) {
        sol = max(arr[i][X]+arr[X][i] , sol); 
        // max = ( max < arr[i][X] + arr[X][i] ) ? arr[i][X] + arr[X][i] : max;
    }

    cout<<sol;
    return 0;
}