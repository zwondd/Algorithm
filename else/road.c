#include <stdio.h>
#define MAX (1<<29)

int N;//지도 크기
char map[110][110];//지도 정보
int visited[110][110];

int dir_x[4] = {1,0,-1,0};
int dir_y[4] = {0,1,0,-1};

struct Q {
	int x,y;
};
struct Q queue[100*100*100];

void Input_Data(void){
	int i;
	scanf("%d", &N);
	for(i = 0 ; i < N ; i++){
		scanf("%s", map[i]);
	}
}

void init (void)
{
	int i,j;
	for(i=0; i<N; i++)
	{
		for(j=0; j<N; j++)
		{
			visited[i][j] = MAX;
		}
	}
}

int bfs (void)
{
	int i=0;
	int front = 0;
	int rear = 0;
	
    visited[0][0] = map[0][0] - '0';
	queue[front].x = 0;
	queue[front].y = 0;
	front++;
	
	while ( rear < front )
	{
		struct Q pos = queue[rear++];
        // printf("front : %d, rear : %d \n", front, rear);
        // printf("pos.x : %d pos.y : %d \n",pos.x,pos.y);
		for(i=0; i<4; i++)
		{
			int new_x = pos.x + dir_x[i];
			int new_y = pos.y + dir_y[i];
            // printf("new_x : %d new_y : %d \n",new_x,new_y);
            // printf("pos visited[][] : %d \n", visited[pos.x][pos.y]);
			
			if ( new_x<0 || new_x>=N || new_y<0 || new_y>=N )
				continue;
			
			if ( visited[pos.x][pos.y] + (map[new_x][new_y]-'0') < visited[new_x][new_y])
            {
                visited[new_x][new_y] = visited[pos.x][pos.y] + (map[new_x][new_y]-'0');
                // printf("visited[][] : %d \n", visited[new_x][new_y]);
                
                queue[front].x = new_x;
                queue[front].y = new_y;
                front++;
            }
            
				
		}
	}
	return visited[N-1][N-1];
}

/*
void solve(int x, int y)
{
	int i = 0;
	int cur_cost = visited[x][y];
	// printf("\nx : %d, y : %d , visited[%d][%d] : %d \n", x,y, x,y, visited[x][y]);
	
	if ( x<0 || x>=N || y<0 || y>=N )
		return;
	
	for( i=0; i<4; i++)
	{
		int new_x = x + dir_x[i];
		int new_y = y + dir_y[i];
		int new_cost = map[new_x][new_y] - 48;
		
		if ( !visited[new_x][new_y] )
			visited[new_x][new_y] = cur_cost + new_cost;
		else if ( visited[new_x][new_y] != 0 && (cur_cost+new_cost < visited[new_x][new_y]))
			visited[new_x][new_y] = cur_cost + new_cost;
		else 
			continue;
		solve(new_x,new_y);
	}
}

void solve_2()
{
	int x,y,k;
	int prev_x[2] = {-1,0};
	int prev_y[2] = {0,-1};
	
	for(x=0; x<N; x++)
	{
		for (y=0; y<N; y++)
		{
			int cur_cost = map[x][y]-48;
			int prev_cost[2] = {0,};
			
			for(k=0; k<2; k++)
			{
				if ( x + prev_x[k] >= 0 && x + prev_x[k]<N && y + prev_y[k] >= 0 && y + prev_y[k] <N )
				{
					prev_cost[k] = visited[x + prev_x[k]][y + prev_y[k]];
				}
				else
				{
					prev_cost[k] = 999999;
				}
			}
			
			if ( prev_cost[0] == 999999 && prev_cost[1] == 999999 )
				visited[x][y] = map[x][y]-48;
			else
				visited[x][y] = (prev_cost[0] < prev_cost[1] ) ? prev_cost[0] + cur_cost : prev_cost[1] + cur_cost;
			// printf("prev_cost[0] : %d , [1] : %d \n", prev_cost[0],prev_cost[1]);
			// printf("\nmap[x][y] : %d, visited[%d][%d] : %d \n",cur_cost, x,y,visited[x][y]);
		}
	}
}
*/

int main(void){
	int ans = -1;
	Input_Data();		//	입력 함수

	// solve(0,0);
	// solve_2();
	// ans = visited[N-1][N-1];
    init();
	ans = bfs();
	
	printf("%d\n", ans);		//	정답 출력
	return 0;
}
