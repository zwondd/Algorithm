/*
    200823
    LG codepro - [20년도_2차] 무인열차
	my solution 
 */
#include <iostream>
#include <cstring>
#include <queue>
#define MAX 1000000
using namespace std;

int N; // 세로크기
int M; // 가로크기
int map[50 + 10][50 + 10]; // 지도 데이터

int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int minRail = MAX;
queue<int> q;


void InputData(void){
	cin >> N >> M;
	for (int i = 1; i <= N; i++){
		for (int j = 1; j <= M; j++){
			cin >> map[i][j];


		}
	}
}

void dfs(int x, int y, int factory) {
	map[x][y] = factory;

	for(int i=0; i<4; i++) {
		int nx = x + dx[i];
		int ny = y + dy[i];

		if ( map[nx][ny] == factory )
			continue;
		if ( map[nx][ny] == 1 ) 
			dfs(nx,ny,factory);
	}
	return;
}

void bfs() {

	while( !q.empty() ) {
		int curx = q.front(); q.pop();
		int cury = q.front(); q.pop();

		// printf("=== curx : %d, cury : %d ===\n", curx, cury);

		for(int i=0; i<4; i++) {
			int nx = curx + dx[i];
			int ny = cury + dy[i];

			if ( nx<0 || nx>N || ny<0 || ny>M ) // array index of factory is 1~N, 1~M
				continue;

			if ( map[nx][ny] == -1 ) {
			 	continue;
			} 
			
			if ( map[nx][ny] == -2 ) {
				if ( minRail > map[curx][cury] + 1 ) {
					minRail = map[curx][cury] + 1;
				}
				continue;

				// fail
				// minRail = map[curx][cury] + 1;
				// return;
			} 

			if ( map[nx][ny] != 0 && (map[nx][ny] <= map[curx][cury] + 1) ) { 
				// "<=" added equal conditino when comparing 
				continue;
			}

			map[nx][ny] = map[curx][cury] + 1;

			q.push(nx);
			q.push(ny);
		}

	}
}

void solve() {

	for(int i=1; i<=N; i++) {
		for(int j=1; j<=M; j++) {
			if ( map[i][j] == -1 ) {
				// printf(" start x : %d, start y : %d \n", i,j);
				int cntL = 0;
				for(int k=0; k<4; k++) {  //start bfs point is only when it is edge of factory(?)
					if ( map[i + dx[k]][j + dy[k]] == -1)
						cntL++;
				}
				if ( cntL <4 ) {
					printf("pushed (%d,%d) \n", i,j);
					q.push(i);
					q.push(j);
				}
			}
		}
	}

	bfs();
}


int main(void){
	int ans = -1;
	InputData();	//입력 함수

	int factory=-1;
	for(int i=1; i<=N; i++) {
		for(int j=1; j<=M; j++) {
			if ( map[i][j] == 1 ) {
				dfs(i,j,factory--);
			} 
		}
	}

	// for(int i=0; i<N; i++) {
	// 	for(int j=0; j<M; j++) {
	// 		printf(" %d ", map[i][j]);
	// 	}
	// 	printf("\n");
	// }

	solve();

	// printf("\n\n\n");
	// for(int i=0; i<N; i++) {
	// 	for(int j=0; j<M; j++) {
	// 		printf(" %d ", map[i][j]);
	// 	}
	// 	printf("\n");
	// }

	ans = minRail;
	
	cout << ans << endl;//출력
    return 0;
}

