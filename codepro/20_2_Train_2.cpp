/*
    200823
    LG codepro - [20년도_2차] 무인열차
	solution in lecture -> fail 됨..?
 */
#include <iostream>
using namespace std;

int N; // 세로크기
int M; // 가로크기
int map[50 + 10][50 + 10]; // 지도 데이터

int dr[] = {0,0,-1,1};
int dc[] = {-1,1,0,0};

typedef struct {
	int r,c,t;
}QUE;

QUE que[50+50+10];
int wp, rp;

void push(int r, int c, int t) {
	map[r][c] = 3;
	que[wp].r=r;
	que[wp].c=c;
	que[wp].t=t;
	wp++;
}

void pop() {
	rp++;
}
QUE front() {
	return que[rp];
}

int empty() {
	return wp==rp;
}

void InputData(void){
	cin >> N >> M;
	for (int i = 1; i <= N; i++){
		for (int j = 1; j <= M; j++){
			cin >> map[i][j];
			map[i][j]++;
		}
	}
}

int FloodFill (int r, int c) {
	if ( map[r][c] != 2 ) return 0;
	map[r][c] = 3;
	int cnt = 0;
	for (int i=0; i<4; i++) {
		cnt+= FloodFill(r+dr[i], c+dc[i]);
	}
	if ( cnt<4 ) {
		//printf(" r : %d , c : %d \n", r, c);
		push(r,c,0);
	}
	return 1;
}

void SaveStart() {
	for(int i=1; i<=N; i++) {
		for(int j=1; j<=M; j++) {
			if ( map[i][j] == 2) {
				//printf("floodfill : %d %d \n", i,j);
				FloodFill(i,j);
				return;
			}
		}
	}
}

int BFS() {
	wp=rp=0;
	SaveStart();
	while(!empty()) {
		QUE cur = front(); pop();
		for(int i=0; i<4; i++) {
			int nr = cur.r + dr[i];
			int nc = cur.c + dc[i];
			if ( map[nr][nc] == 2 ) 
				return cur.t;
			if ( map[nr][nc] != 1 ) 
				continue;
			push ( nr, nc, cur.t+1 ); 
		}
	}
	return -1;
}

int main(void) {
	int ans = -1;
	InputData();
	ans = BFS();
	cout<<ans<<endl;
	
	return 0;
}
