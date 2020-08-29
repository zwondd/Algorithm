/*
    200829
    LG codepro - [19년도_2차] 재고정리
	my solution 
    pass 3/10
	문제 이해 잘 못 함. 항상 오름, 내림 차순으로 정렬된게 아님. 
	같은 번호일때만 연속으로 있으면됨.
 */
#include <iostream>
using namespace std;

int N;//제품 수
int M;//제품 종류 수
int ID[100000 + 10];//제품 ID

int proCnt[12] = {0,};

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

	for(int i=1; i<=N; i++) {
		proCnt[ID[i]]++;
	}
	
	
	int cur = 1;
	int movInc = 0;
	for(int i=1; i<=M; i++) {
		if ( proCnt[i] != 0 ) {
			for(int j=cur; j<cur+proCnt[i]; j++) {
				// cout<<"j : "<<j<<" ID[j] : "<<ID[j] <<endl;
				if ( ID[j] != i )
					movInc++;
			}
			// cout<<"movInc : " <<movInc<<endl;
		}
		cur = cur+proCnt[i];

	}
	
	cur = 1;
	int moveDesc = 0;
	for(int i=M; i>=1; i--) {
		if ( proCnt[i] != 0 ) {
			for(int j=cur; j<cur+proCnt[i]; j++) {
				// cout<<"j : "<<j<<" ID[j] : "<<ID[j] <<endl;
				if ( ID[j] != i )
					moveDesc++;
			}
			// cout<<"moveDesc : " <<moveDesc<<endl;
		}
		cur = cur+proCnt[i];

	}
	
	
	ans = (movInc<moveDesc) ? movInc:moveDesc;
	

	cout << ans << endl;
	return 0;
}