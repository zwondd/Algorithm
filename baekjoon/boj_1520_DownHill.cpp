#include <iostream>
#include <cstring>
#include <algorithm>

using namespace std;

int cache[510][510]={0,};
int h[510][510];
int M, N;

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

// number of ways to go from (x,y) -> (0,M)
int getPath (int x, int y) {
    if ( x<=0 || y<=0 || x>M || y>N ) return 0;

    int& ret = cache[x][y];
    if ( x==1 && y==N ) return ret=1;
    if ( ret!=-1 ) return ret;

    ret=0;
    for(int i=0; i<4; i++) {
        if ( h[x][y] > h[x+dx[i]][y+dy[i]] ) {
            ret += getPath(x+dx[i], y+dy[i]);
        }
    }

    return ret;
};

int main(void) {
    cin >> M;
    cin >> N;
    for(int i=M; i>0; i--) {
        for(int j=1; j<=N; j++) {
            cin>>h[i][j];
        }
    }
    memset(cache, -1, sizeof(cache));
    cout<< getPath(M,1);

    return 0;
}