// 2020-08-21 
// DFS -> memory exceeded

#include <iostream>
#include <cstring>

#define IMPOSSIBLE "use the stairs"
#define MAX 999999999999

int F; // building max story
int S; // current story
int G; // startlink story
int U; // up
int D; // down

long long cnt=MAX;

void dfs (int idx, int cur, int move) {
    if ( cur+move > F || cur+move <1 || idx>=cnt )
        return;

    if ( cur+move == G ) {
        cnt = idx;
        return;
    }

    dfs(idx+1, cur+move, U);
    dfs(idx+1, cur+move, D);
}

int main(void) {
    scanf("%d %d %d %d %d", &F, &S, &G, &U, &D);
    D = (-1)*D;

    dfs(0, S, 0);

    if ( cnt == MAX )
        printf("%c\n",IMPOSSIBLE);
    else
        printf("%d\n", cnt);


    return 0;
}

