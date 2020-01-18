/*
    191216
   - 백준 #7576 : 토마토
 */

#include <iostream>
using namespace std;

#define MAX 1000+1

int M, N;
int arr[MAX][MAX]={0,};
int visited[MAX][MAX]={0,};

typedef struct Pos {
     int x;
     int y;
     int day;
}POS;

POS queue[MAX*500];
int front = -1;
int rear = -1;
int days = 0;
int riped = 0;

int dx[4] = {-1,0,1,0};
int dy[4] = {0,1,0,-1};


void bfs() {
     // queue[(rear++)%MAX]={x,y,1};
     // int riped=0;

     while(front!=rear) {
          POS cur = queue[front];
          front=(front+1)%MAX;

          int cur_x = cur.x;
          int cur_y = cur.y;
          int cur_day = cur.day;

          visited[cur_x][cur_y]=1;

          // printf("cur_x : %d, cur_y : %d, cur_day : %d \n", cur_x, cur_y, cur_day);

          for(int i=0; i<4; i++) {
               int nx = cur_x + dx[i];
               int ny = cur_y + dy[i];
               // printf("--> nx : %d, ny : %d \n", nx, ny);

               // if ( nx<0 || nx>=M || ny<0 || ny>=N )
               if ( nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny])
                    continue;

               // if ( visited[nx][ny]==1 )
               //      continue;

               // if ( arr[nx][ny]==1 ) {
               //      rear = (rear+1)%MAX;
               //      queue[rear]={nx,ny,cur_day};
               // }

               // if ( arr[nx][ny]==0 && visited[nx][ny]==0 ) {
               if ( arr[nx][ny]==0 ) {
                    riped++;
                    arr[nx][ny] = 1;
                    rear = (rear+1)%MAX;

                    queue[rear]={nx,ny,cur_day+1};
                    // printf("-- pushed : nx %d ny %d day %d\n", nx, ny, cur_day+1);
               }
          }
          days = (days<cur_day) ? cur_day : days;
          // printf("days: %d \n", days);
     }
}

void solve() {
     // for(int i=0; i<M; i++) {
     //      for(int j=0; j<N; j++) {
     // for(int i=0; i<N; i++) {
     //      for(int j=0; j<M; j++) {
     //           if ( arr[i][j]==1 && visited[i][j]==0 ) {
     //                rear = (rear+1)%MAX;
     //                queue[rear]={i,j,0};
     //           }
     //      }
     // }

     bfs();

     // for(int i=0; i<M; i++) {
     //      for(int j=0; j<N; j++) {
     for(int i=0; i<N; i++) {
          for(int j=0; j<M; j++) {
               if ( arr[i][j]==0 ) {
                    // printf("-----");
                    // printf("i : %d, i: %d \n", i, j);
                    days = -1;
                    break;
               }
          }
     }
}

int main() {
     scanf("%d %d", &M, &N);

     // for(int i=0; i<M; i++) {
     //      for(int j=0; j<N; j++) {
     for(int i=0; i<N; i++) {
          for(int j=0; j<M; j++) {
               cin>>arr[i][j];
               // scanf("%d", &arr[i][j]);
               if ( arr[i][j]==1 ) {
                    rear = (rear+1)%MAX;
                    queue[rear]={i,j,0};
               }
          }
     }

     solve();

     cout<<days<<endl;

     //printf("%d\n", days);

     return 0;
}
