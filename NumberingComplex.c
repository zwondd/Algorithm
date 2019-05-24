#include <stdio.h>

// 19.05.24
// 백준 2667번 : 단지번호붙이기

int N;
int arr[30][30]={0,};

int visited[30][30]={0,};
int complex_arr[10000]={0,};
int complex_num=1;

int pos_x[4]={-1,0,1,0};
int pos_y[4]={0,1,0,-1};

int q_x[30];
int q_y[30];

int front=0;
int rear=0;

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
    q_x[rear++]=x;
    q_y[rear++]=y;

    while ( front!= rear )
    {
        int i;

        int cur_x=q_x[front++];
        int cur_y=q_y[front++];

        if( !visited[cur_x][cur_y] )
        {
            // printf("x:%d, y:%d \n",cur_x,cur_y);
            visited[cur_x][cur_y]=1;
            complex_arr[complex]++;
        }

        for( i=0; i<4; i++ )
        {
            int next_x=cur_x+pos_x[i];
            int next_y=cur_y+pos_y[i];

            if( next_x<0 || next_x>=N || next_y<0 || next_y>=N || visited[next_x][next_y]==1 )
            {
                continue;
            }
            else if( !arr[next_x][next_y] )
            {
                visited[next_x][next_y]=1;
                continue;
            }
            else
            {
                q_x[rear++]=next_x;
                q_y[rear++]=next_y;
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
    int i,tmp;
    for(i=1; i<complex_num-1; i++)
    {
        if ( complex_arr[i] > complex_arr[i+1] ) 
        {
            tmp=complex_arr[i+1];
            complex_arr[i+1]=complex_arr[i];
            complex_arr[i]=tmp;
        }
    }
}


int main(void)
{
    int i;

    Input_Data();

    solve();
    sort();

    printf("%d\n",complex_num-1);
    for(i=1;i<complex_num;i++)
        printf("%d\n",complex_arr[i]);
}