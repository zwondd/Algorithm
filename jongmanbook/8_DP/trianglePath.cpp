#include <iostream>
#include <algorithm>

#define MAX_TRI 100
#define MAX_NUMBER 100

using namespace std;

int cache[100][100];
int tri[100][100];
int n;

int pathSum(int y, int x) {
    if ( y== n-1 ) return tri[y][x];

    int& ret = cache[y][x];
    if ( ret!= -1 ) return ret;
    return ret = max( pathSum( y+1,x ), pathSum( y+1, x+1 ) ) + tri[y][x];
}   

