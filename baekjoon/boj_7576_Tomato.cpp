/*
    191216
   - 백준 #7576 : 토마토
 */

#include <iostream>
#include <queue>
using namespace std;

#define MAX 1000+1

int M, N;
int arr[MAX][MAX]={0,};
int visited[MAX][MAX]={0,};

typedef struct {
     int x;
     int y;
     int day;
}POS;

queue<POS> q;
int front = -1;
int rear = -1;
int days = 0;
int riped = 0;

int dx[4] = {-1,0,1,0};
int dy[4] = {0,1,0,-1};


void bfs() {
     while(!q.empty()) {
          POS cur=q.front();
          q.pop();

          int cur_x = cur.x;
          int cur_y = cur.y;
          int cur_day = cur.day;

          visited[cur_x][cur_y]=1;

          for(int i=0; i<4; i++) {
               int nx = cur_x + dx[i];
               int ny = cur_y + dy[i];

               if ( nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny])
                    continue;

               if ( arr[nx][ny]==0 ) {
                    arr[nx][ny] = 1;

                    q.push({nx,ny,cur_day+1});
               }
          }
          days = (days<cur_day) ? cur_day : days;
     }
}

void solve() {
     bfs();
     for(int i=0; i<N; i++) {
          for(int j=0; j<M; j++) {
               if ( arr[i][j]==0 ) {
                    days = -1;
                    break;
               }
          }
     }
}

int main() {
     cin>>M>>N;

     for(int i=0; i<N; i++) {
          for(int j=0; j<M; j++) {
               cin>>arr[i][j];
               if ( arr[i][j]==1 ) {
                    q.push({i,j,0});
               }
          }
     }

     solve();

     cout<<days<<endl;

     return 0;
}
