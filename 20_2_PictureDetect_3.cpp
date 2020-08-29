/*
    200822
    LG codepro - [20년도_2차] 그림인식
	solution 
 */


#include <iostream>
using namespace std;

int N;//도화지 크기
char A[10 + 2][10 + 2];//도화지 색정보
// int arr[10] = {0,};
// int visited[10] = {0,};
// int usedColor=0;

void InputData(){
	cin >> N;
	for (int i = 0; i < N; i++) cin >> A[i];
}

int solve() {
	int i, r, c, minr, minc, maxr, maxc, cnt=0;
	int check[10] = {0,};

	for(i='1'; i<='9'; i++) {
		minr = minc = 10;
		maxr = maxc = 0;

		for(r=0; r<N; r++) {
			for(c=0; c<N; c++) {
				if ( A[r][c] != i ) 
					continue;
				if( minr > r ) minr = r;
				if ( maxr < r ) maxr = r;
				if ( minc > c ) minc = c;
				if ( maxc < c ) maxc = c;
			}
		}

		if ( minr == 10 ) continue;

		check[i-'0']++;
		for(r=minr; r<=maxr; r++) {
			for(c=minc; c<=maxc; c++) {
				if ( A[r][c] == i ) continue;
				check[A[r][c]-'0']++;
			}
		}

	}

	for(i=1; i<=9; i++) {
		if ( check[i] == 1 ) cnt++;
	}

	return cnt;
}

int main(){
	int ans = -1;
	InputData();//	입력 함수

	ans = solve();
	cout << ans << endl;//출력
	return 0;
}
