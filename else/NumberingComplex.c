#include <stdio.h>
#include <stdlib.h>

// 19.05.24
// 백준 2667번 : 단지번호붙이기
// BFS 방식

// - 단지 수 최대 N^2/2 개
// - sort 알고리즘 다시 공부하기 

int N;
int arr[30][30]={0,};
int visited[30][30]={0,};
int complex_arr[1000]={0,};
int complex_num=0;

int pos_x[4]={-1,0,1,0};
int pos_y[4]={0,1,0,-1};

int front=0;
int rear=0;

struct Pos{
    int x,y;
};
struct Pos q[1000];

void Input_Data(void)
{
    int i,j;
    scanf("%d",&N);
    
    for(i=0;i<N;i++)
    {
        for(j=0;j<N;j++)
        {
            scanf("%1d",&arr[i][j]);
        }
    }
}

void bfs(int complex, int x,int y) 
{
    struct Pos cur={x,y};
    q[rear++]=cur;
    visited[x][y]=1;
    complex_arr[complex]++;

    while ( front!= rear )
    {
        int i;
        struct Pos cur=q[front++];
        int cur_x=cur.x;
        int cur_y=cur.y;
        
        for( i=0; i<4; i++ )
        {
            int next_x=cur_x+pos_x[i];
            int next_y=cur_y+pos_y[i];

            if( next_x>=0 && next_x<N && next_y>=0 && next_y<N && arr[next_x][next_y] && !visited[next_x][next_y]  )
            {
                visited[next_x][next_y]=1;
                complex_arr[complex]++;
                struct Pos next={next_x,next_y};
                q[rear++]=next;
            }
        }
    }
}

void solve()
{
    int i,j;
    for(i=0; i<N; i++)
    {
        for(j=0; j<N; j++)
        {
            if( arr[i][j]==1 && !visited[i][j] )
            {
                bfs(complex_num++,i,j);
            }
        }
    }
}

void sort()
{
    int i,j,min;
    for(i=0; i<complex_num-1; i++)
    {
        min=i;
        for(j=i+1;j<complex_num;j++)
        {
            min=(complex_arr[j]<complex_arr[min]) ? j:min;
        }
        int tmp=complex_arr[i];
        complex_arr[i]=complex_arr[min];
        complex_arr[min]=tmp;
    }
}


int main(void)
{
    int i;

    Input_Data();
    solve();
    sort();

    printf("%d",complex_num);
    for(i=0;i<complex_num;i++)
        printf("\n%d",complex_arr[i]);
}