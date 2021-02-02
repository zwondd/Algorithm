/*
   - Codepro : 공기청정기 배치 프로그램 개발 
 */

#include <iostream>
#include <queue>
using namespace std;

int H;		// 세로 크기
int W;		// 가로 크기
int map[50][50];	//지도

int visit[50][50];

int dx[] = {0,-1,0,1}; //{1,0,-1,0};
int dy[] = {-1,0,1,0}; //{0,1,0,-1};

// struct ANS res[2500+1];

struct ANS{
	int count;	// room 개수
	int area;		// 가장 넓은 room 넓이
};

void InputData(){
	int i, j;
	cin >> H;
	cin >> W;
	for(i=0 ; i<H ; i++){
		for(j=0 ; j<W ; j++){
			cin >> map[i][j];
		}
	}
}

int bfs(int x, int y) {
	// cout<<"bfs"<<endl;
	queue<int> q;
	int cx, cy, nx, ny, area;
    int tmpBit;
	
	visit[x][y]=1;
	area=0;
	
	q.push(x);
	q.push(y);

	while(!q.empty()) {
		cx = q.front(); q.pop();
		cy = q.front(); q.pop();
        area+=1;

		// cout<<" cx : "<<cx<<" cy : "<<cy<<" area : "<<area<<endl;
        tmpBit = map[cx][cy];
		for(int i=0; i<4; i++) {
			// map[cx][cy] = (map[cx][cy]>>1);
			// cout<<" tmpBit "<<tmpBit<<" " << (tmpBit&1) <<endl;
			
			if ( !(tmpBit&1) ) {
                tmpBit=(tmpBit>>1);
				nx = cx + dx[i];
				ny = cy + dy[i];
				
				if ( nx<0 || nx>=H || ny<0 || ny>=W ) continue;
				if ( visit[nx][ny] || map[nx][ny]==15 ) continue;
				
				visit[nx][ny]=1;

				q.push(nx);
				q.push(ny);
			} else {
                tmpBit=(tmpBit>>1);
                continue;
            }
		}
	}
	
	return area;
}

void solve(ANS * ans) {
	int tmp;
	for(int i=0; i<H; i++) {
		for(int j=0; j<W; j++) {
			if ( !visit[i][j] && map[i][j]!=15 ) {
				(ans->count)++;
				 tmp = bfs(i,j);
			} else if ( !visit[i][j] && map[i][j]==15 ) {
				(ans->count)++;
				tmp = 1;
				visit[i][j]=1;
			}
			(ans->area) = ( tmp > (ans->area) ) ? tmp : (ans->area);
			
			// cout<<" ans.count " <<ans->count<<" ans.area " <<ans->area<<endl;
		}
	}
}

int main(){
	ANS ans = {0, 0};
	InputData();			//	입력 함수
	solve(&ans);
	
	cout << ans.count << endl;	//	정답 출력
	cout << ans.area << endl;		//	정답 출력
	return 0;
}
