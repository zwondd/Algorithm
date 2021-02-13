/*
    21-02-13
   - 백준 #2618 : 경찰차
   경찰차 1,2가 각각 사건으로 이동하는 거리의 합의 최솟값
*/

#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>

#define INF 987654321
using namespace std;

/*
   Solution 1 ) 

   결과 ) 메모리 : 5948 KB / 시간 : 56 ms

   https://kibbomi.tistory.com/95
*/
#if 0
int N,W;
pair<int,int> work[1002];
int dp[1002][1002];

int dist(pair<int,int>a, pair<int,int>b) {
    return abs(b.first-a.first)+abs(b.second-a.second);
}

void trace(int x, int y) {
    if ( x==W || y==W ) return;

    int next=max(x,y)+1;
    int dist1, dist2;

    if ( x==0 ) dist1=dist({1,1}, work[next]);
    else dist1=dist(work[x],work[next]);

    if ( y==0 ) dist2=dist({N,N}, work[next]);
    else dist2=dist(work[y], work[next]);

    if ( dp[next][y]+dist1 > dp[x][next]+dist2 ) {
        cout<<"2"<<endl;
        trace(x,next);
    } else {
        cout<<"1"<<endl;
        trace(next,y);
    }
}

int solve(int x, int y) {
    if ( x==W || y==W ) return 0;

    int& ret=dp[x][y];
    if ( ret!=-1 ) return ret;

    int next=max(x,y)+1;
    int dist1, dist2;

    if ( x==0 ) 
        dist1=dist( {1,1}, work[next]);
    else 
        dist1=dist(work[x], work[next]);

    if ( y==0 ) 
        dist2=dist( {N,N}, work[next]);
    else 
        dist2=dist( work[y], work[next]);
    
    ret=min(solve(next,y)+dist1, solve(x,next)+dist2);

    return ret;
}

int main(void) {
    memset(dp,-1,sizeof(dp));
    cin>>N>>W;
    for(int i=1; i<=W; i++) 
        cin>>work[i].first>>work[i].second;
    
    cout<<solve(0,0)<<endl;
    trace(0,0);

    return 0;
}
#endif 

/*
   Solution 2 ) 

   결과 ) 메모리 : 5940 KB / 시간 : 56 ms

   https://injae-kim.github.io/problem_solving/2020/03/11/baekjoon-2618.html
*/
#if 1

int row,col;
vector<pair<int,int>> pathA;
vector<pair<int,int>> pathB;

int num;
int dp[1002][1002];

vector<int> v;

int getMinDist(int x, int y) {
    if ( x==num || y==num ) return 0;

    int& ret=dp[x][y];
    if ( ret!=-1 ) return ret;

    ret=INF;

    int next=max(x,y)+1;

    int distA=abs(pathA[next].first-pathA[x].first)+abs(pathA[next].second-pathA[x].second);
    int distB=abs(pathB[next].first-pathB[y].first)+abs(pathB[next].second-pathB[y].second);

    int ret1=getMinDist(next,y)+distA;
    int ret2=getMinDist(x,next)+distB;

    return ret=min(ret1,ret2);
}

void trace(int x, int y) {
    if ( x==num || y==num ) return;

    int next=max(x,y)+1;
    int distA=abs(pathA[next].first-pathA[x].first)+abs(pathA[next].second-pathA[x].second);
    int distB=abs(pathB[next].first-pathB[y].first)+abs(pathB[next].second-pathB[y].second);

    int ret1=getMinDist(next,y)+distA;
    int ret2=getMinDist(x,next)+distB;

    if ( ret1<ret2 ) {
        cout<<"1"<<endl;
        trace(next,y);
    } else {
        cout<<"2"<<endl;
        trace(x,next);
    }
}

void solve() {
    cout<<getMinDist(0,0)<<endl;
    trace(0,0);
}

int main(void) {
    cin>>row; 
    col=row;
    cin>>num;

    memset(dp,-1,sizeof(dp));

    pathA.push_back({1,1});
    pathB.push_back({row,row});

    for(int i=0; i<num; i++) {
        int x,y; 
        cin>>x>>y;
        pathA.push_back({x,y});
        pathB.push_back({x,y});
    }
    solve();
}


#endif 