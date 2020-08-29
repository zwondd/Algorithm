/*
    200829
    LG codepro - [19년도_2차] 재고정리
	solution (answer)
	DFS - Backstracking 
	+ 모든 Tree 타지 않도록 가지치기
 */
#include <iostream>
using namespace std;

int N;//제품 수
int M;//제품 종류 수
int ID[100000 + 10];//제품 ID

int sum[10][100000 + 10]; //미리 구간의 합을 구해놓음
int cnt[10+2];
int used[10+2];
int sol;

void DFS (int n, int p, int m) {
	


}

int solve() {
	
}


void InputData(){
	int i;
	cin >> N >> M;
	for(i = 1; i <= N; i++){
		cin >> ID[i];
	}
}
int main(){
	int ans = -1;

	InputData();//입력 함수
	
	//	코드를 작성하세요
	ans = solve();

	cout << ans << endl;
	return 0;
}