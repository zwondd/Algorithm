#include <iostream>
#include <cstring>

using namespace std;

int n, board[100][100];
int cache[100][100];

int jump(int x, int y) {
    if ( x>=n || y>=n ) return 0;
    if ( x==n-1 && y==n-1 ) return 1;

    int& ret = cache[x][y];
    if ( cache[x][y] != -1 ) return ret; 

    return ret= ( jump(x+cache[x][y], y) || jump(x, y+ cache[x][y]) );
}