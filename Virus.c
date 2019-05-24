#include <stdio.h>

// 백준 2506번 : 바이러스

int computer_count;
int conn_count;
int conn_ary[101][101]={0,};
int visited[101];
// int sum=0;
int sum=-1;

void solve(int k) 
{
    int i;

    visited[k] = 1;
    sum+=1;
    for( i=1; i<=computer_count; i++ )
    {
        if ( conn_ary[k][i]==1 && visited[i]==0 )
        {
            // printf("k : %d , i : %d \n",k,i);
            solve(i);
        }
    }
}

int main(void) 
{
    int i=0;
    scanf("%d", &computer_count);
    scanf("%d", &conn_count);

    for(i=1; i<=conn_count; i++) 
    {
        int x,y;
        scanf("%d %d", &x, &y);
        conn_ary[x][y] = 1;
        conn_ary[y][x] = 1;
    }

    solve(1);

    // for(i=2; i<=computer_count; i++)
    //     if ( visited[i] == 1 )
    //         sum+=1;

    printf("%d", sum);
}
