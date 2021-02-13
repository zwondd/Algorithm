/*
    21-02-13
   - 백준 #2618 : 경찰차
   경찰차 1,2가 각각 사건으로 이동하는 거리의 합의 최솟값

    직접 풀이 )

    결과 )틀렸습니다...??why??
*/

#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>

using namespace std;


int N, W;
int dp[1002][1002];
int point[1002][2];
const int INF = 987654321;

void printCar(int x, int y) {
    if ( x==W || y==W ) return;

    int next=max(x,y)+1;
    int d1, d2;

    if ( x==0 ) d1=abs(point[next][0]-1)+abs(point[next][1]-1);
    else d1=abs(point[next][0]-point[x][0])+abs(point[next][1]-point[x][1]);

    if ( y==0 ) d2=abs(point[next][0]-N)+abs(point[next][1]-N);
    else d2=abs(point[next][0]-point[y][0])+abs(point[next][1]-point[y][1]);

    if( dp[next][y]+d1 < dp[x][next]+d2 ) {
        cout<<"1"<<endl;
        printCar(next,y);
    } else {
        cout<<"2"<<endl;
        printCar(x,next);
    }
}

int solve() {
    dp[0][1] = abs(N-point[1][0]) + abs(N-point[1][1]);
    dp[1][0] = abs(1-point[1][0]) + abs(1-point[1][1]);

    for(int i=0; i<=W; i++) {
        for(int j=0; j<=W; j++) {
            if( i==j ) continue;
            int next=max(i,j)+1;

            if ( i==0 ) {
                point[0][0]=1; 
                point[0][1]=1;
            }
            if ( j==0 ) {
                point[0][0]=N;
                point[0][1]=N;
            }
            dp[i][next] = min(dp[i][next],dp[i][j]+abs(point[next][0]-point[j][0]) + abs(point[next][1]-point[j][1]) );
            dp[next][j] = min(dp[next][j],dp[i][j]+abs(point[next][0]-point[i][0]) + abs(point[next][1]-point[i][1]) );
        }
    }
    int ans=INF;
    for(int i=0; i<=W; i++) {
        ans=min(ans,dp[i][W]);
        ans=min(ans,dp[W][i]);
    }
    return ans;
}



int main(void) {
    cin>>N>>W;
    for(int i=0; i<=N; i++) {
        for(int j=0; j<=N; j++) {
            dp[i][j]=INF;
        }
    }
    for(int i=1; i<=W; i++) {
        int x,y;
        cin>>point[i][0]>>point[i][1];
    }
    cout<<solve()<<endl;
    printCar(0,0);

    return 0;
}