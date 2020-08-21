// 2020-08-21 
// BFS : failed

#include <iostream>
#include <cstring>
#include <queue>

#define IMPOSSIBLE "use the stairs"
#define MAX 999999999999

using namespace std;

int F; // building max story
int S; // current story
int G; // startlink story
int U; // up
int D; // down

long long cnt=MAX;

struct moveInfo {
    int idx;
    int cur;
    int move;
};

queue<moveInfo> q;

int main(void) {
    scanf("%d %d %d %d %d", &F, &S, &G, &U, &D);
    D = (-1)*D;

    moveInfo ustart = {1, S, U};
    moveInfo dstart = {1, S, D};
    if (U!=0)
        q.push(ustart); 
    if (D!=0)
        q.push(dstart);

    // printf("u : %d, d : %d \n", U, D);


    while( !q.empty() ) {
        moveInfo info = q.front();
        q.pop();

        //printf("cnt : %d \n", cnt);
        //printf("info.cur : %d , info.move : %d \n", info.cur, info.move);

        
        if ( info.cur + info.move == G ) {
            cnt = ( cnt > info.idx ) ? info.idx : cnt;
            continue;
        }

        if ( info.idx+1>=cnt  )
            continue;

        if ( info.cur+U<=F && info.cur+U>=1 && U!=0 ) {
            moveInfo newInfoU = { info.idx+1, info.cur + info.move, U };
            q.push(newInfoU);
        }

        if ( info.cur+D<=F && info.cur+D>=1 && D!=0 ) {
            moveInfo newInfoD = { info.idx+1, info.cur + info.move, D };
            q.push(newInfoD);
        }
    }

    if ( cnt == MAX )
        printf("%s\n",IMPOSSIBLE);
    else
        printf("%lld\n", cnt);


    return 0;
}

