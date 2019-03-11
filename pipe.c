#include <stdio.h>

int N;//정사각형 지도 크기
int X, Y;//수돗물 공급되는 시작 좌표, 가로, 세로
int map[20][20];//지도 정보

int check[20][20];

int pipe[][4] = {
	{0,0,0,0},
	{0,0,1,1},
	{1,1,0,0},
	{0,1,0,1},
	{0,1,1,0},
	{1,0,1,0},
	{1,0,0,1},
	{1,1,0,1},
	{0,1,1,1},
	{1,1,1,0},
	{1,0,1,1},
	{1,1,1,1}
};

int dir_x[4] = {-1,1,0,0};
int dir_y[4] = {0,0,-1,1};

int check_connection[4] = {1,0,3,2};

int total_pipe_cnt;

void Input_Data(void){
	int i, j;
	scanf("%d", &N);
	scanf("%d %d", &X, &Y);
	for(i=0 ; i<N ; i++){
		for(j=0 ; j<N ; j++){
			scanf("%1x", &map[i][j]);
		}
	}
}

void solve( int x, int y )
{
	int i = 0;
	int j = 0;
	
	check[x][y] = 1;
	if ( map[x][y] )
	{
		total_pipe_cnt--;

	}
	
	for (i=0; i<4; i++)
	{
		int new_x = x + dir_x[i];
		int new_y = y + dir_y[i];

		
		if ( new_x<0 || new_x>=N || new_y<0 || new_y>=N || check[new_x][new_y]==1 || map[new_x][new_y]==0 )
		{
			continue;
		}

		
		if ( pipe[map[new_x][new_y]][check_connection[i]] && pipe[map[x][y]][i] )
		{
			solve(new_x,new_y);
		}
	}
}

int main(void){
	int ans = -1;
	int i = 0;
	int j = 0;
	Input_Data();		//	입력 함수
	
	for ( i=0; i<N; i++ ) 
	{
		for ( j=0; j<N; j++)
		{
			if ( map[i][j] != 0 )
			{
				total_pipe_cnt++;
			}
		}
	}
	
	for ( i=0; i<N; i++ )
	{
		for (j=0; j<N; j++ )
		{
			if ( check[i][j] == 0 )
				solve(X,Y);	
		}
		
	}
	ans = total_pipe_cnt;
	
	
	printf("%d\n", ans);		//	정답 출력
	return 0;
}
