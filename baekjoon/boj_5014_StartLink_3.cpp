// 2020-08-21 
// BFS : success

#include <iostream>
#include <cstring>
#include <queue>

#define IMPOSSIBLE "use the stairs"
#define MAX 1000010

using namespace std;

int F; // building max story
int S; // current story
int G; // startlink story
int U; // up
int D; // down

queue<int> q;
int visited[MAX] = {0,};

int bfs() {
    q.push(S);
    visited[S]=1;

    while(!q.empty()) {
        int cur=q.front();
        if ( cur==G )  
            return visited[cur]-1;
        q.pop();
        int nextFloor[2] = {cur+U, cur-D};
        for(int i=0; i<2; i++) {
            if ( nextFloor[i]>=1 && nextFloor[i]<=F ) {
                if ( visited[nextFloor[i]] == 0 ) {  // memory will exceed if visited==0 not checked
                    visited[nextFloor[i]]=visited[cur]+1;
					q.push(nextFloor[i]);
                }
            }
        }
    }

    return -1;
}



int main(void) {
    scanf("%d %d %d %d %d", &F, &S, &G, &U, &D);

    int ans = bfs();
    if ( ans == - 1) 
        printf("%s\n",IMPOSSIBLE);
    else
        printf("%d\n", ans);


    return 0;
}

