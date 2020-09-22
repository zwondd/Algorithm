/*
    200902
    LG codepro - [20년도_1차] 안테나 송수신
	my solution 
    2/10 : success (5 Timeouts)

    Sample 예제는 통과되나 해결책이 잘못됨.
    -> i 번째 높이보다 작은 것에 대해 계속 인덱스를 증가하는게 아니라
    i 번째 스타트에서 그다음부터 current < next 이면서, 
    next<=H[i] 일때까지만 반복하도록 구현해야함.
 */

#include <iostream>
using namespace std;

int N;//송수신 안테나 수
int H[100000 + 10];//송수신 안테나 높이

void InputData(){
	cin >> N;
	for (int i = 0; i < N; i++) cin >> H[i];
}

int main(){
	int ans = -1;
	InputData();//	입력 함수

	int i, j, cnt=0;
	int h;
	for(i=0; i<N; i++) {
		cnt++;

		for(j=i+1; j<N; j++) {
            // break 조건이 잘 못 됨.
			// if ( H[i] < H[j] ) break;
		}
		
		if ( j-i > 1 ) {
			if ( H[i] == H[i+1] ) continue;
			if ( j > N-1 ) continue;
			cnt++;
			// cout<<"i : " <<i << " j : "<<j<<endl;
		}
	}
	
	ans = cnt;
	
	cout << ans << endl;//출력
	return 0;
}
