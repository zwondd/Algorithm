/*
    200829
    LG codepro - [19년도_2차] 재고정리
	solution (answer)
	DFS - Backstracking 
	+ 모든 Tree 타지 않도록 가지치기
	7 2
	1 2 2 2 1 2 1 
 */
#include <iostream>
using namespace std;

int N;//제품 수
int M;//제품 종류 수
int ID[100000 + 10];//제품 ID

int sum[10][100000 + 10]; //미리 구간의 합을 구해놓음
int cnt[10+2];
int used[10+2];
int visited[10+2];

int sol;
int minCnt=1000000;

void DFS (int n, int p, int m) {
	cout<<" n : "<<n<<" p: "<<p<<" m: "<<m<<endl;
	if ( sol<= m ) return;
	if ( n>M ) {
		sol=m; 
		return;
	}

	for(int i=1; i<=M; i++) {
		if ( visited[i] == 1 ) continue;

		visited[i]=1;
		// int mcnt = m +cnt[i] - sum[i][p+cnt[i]-1] - sum[i][p-1];  // 연산 잘못되서 안됨
		int mcnt = m + cnt[i] - (sum[i][p + cnt[i] - 1] - sum[i][p - 1]);

		int nextP = p+cnt[i];
		// cout<<" cnt[i] : "<<cnt[i]<<" sum[i][p+cnt[i]-1] : "<<sum[i][p+cnt[i]-1]<<" last: " <<sum[i][p-1]<<endl;
		cout<<"i: "<<i<<" mcnt : "<<mcnt<<" nextP: "<<nextP<< endl;

		// cout<<"i : "<<i<<" sol : "<< m +cnt[n] - sum[n][p+cnt[n]-1] - sum[n][p-1] << " next p : " << p+cnt[n]<<endl;
		// cout<<"m : "<<m<<endl;
		DFS(n+1, nextP, mcnt);   // i가 아닌 n+1로 순서를 넘겨줘야함
		visited[i]=0;
	}
}

int solve() {
	for(int i=1; i<=N; i++)
		sum[ID[i]][i]=1;
	for(int i=1; i<=M; i++) {
		for(int j=2; j<=N; j++) {
			sum[i][j]+=sum[i][j-1];
		}
		cnt[i]=sum[i][N];
	}
	sol=N;

	cout<<"cnt : ";
	for(int i=1; i<=M; i++)
		cout<<cnt[i]<<" ";
	cout<<endl;

	// visited[1]=0;
	DFS(1,1,0);


	return sol;
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