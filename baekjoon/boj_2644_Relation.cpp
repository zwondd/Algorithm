#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

int N, M, p1, p2;
int info[101][101] = {0,};
int visited[101] = {0,};
queue<int> q;


int bfs() {
    while( !q.empty() ) {
        int cur = q.front();
        // printf("cur : %d \n", cur);
        q.pop();

        if ( cur == p2 ) 
            return visited[cur];

        for(int i=1; i<=N; i++) {
           if ( info[cur][i] == 1 && visited[i] == 0 ) {
               // has child
               visited[i] = visited[cur]+1;
               q.push(i);
           }
        }

        for(int j=1; j<=N; j++) {
           if ( info[j][cur] == 1 && visited[j] ==0 ) {
               // has parent
               visited[j] = visited[cur]+1;
               q.push(j);
           }
        }
    }

    return -1;
}


int main(void) {
    scanf("%d", &N);
    scanf("%d %d", &p1, &p2);
    scanf("%d", &M);

    for(int i=0; i<M; i++) {
        int temp1, temp2;
        scanf("%d %d", &temp1, &temp2);
        // arr[temp1].push_back(temp2);

        info[temp1][temp2] = 1;
    }

    // print linked list
    // for(int i=0; i<N; i++) {
    //     printf("idx : %d ", i);
    //     list<int>::iterator itor;
    //     for(itor=arr[i].begin(); itor!=arr[i].end(); itor++) {
    //         printf(" -> %d ", *itor );
    //     }
    //     printf("\n");
    // }

    q.push(p1);

    int ans = bfs();
    printf("%d", ans);
}