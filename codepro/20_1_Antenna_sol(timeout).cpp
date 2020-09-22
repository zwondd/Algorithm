/*
    200902
    LG codepro - [20년도_1차] 안테나 송수신
    4/10 : success (6 Timeouts)

    timeout solution 
 */

#include <iostream>
using namespace std;

int N;//송수신 안테나 수
int H[100000 + 10];//송수신 안테나 높이

void InputData(){
    cin >> N;
    for (int i = 0; i < N; i++) cin >> H[i];
}

int Solve(){
	int cnt = 0;
	int i, j, h;
	for (i = 0; i < N; i++){
		h = 0;
		for (j = i+1; j < N; j++){
			if (h < H[j]){
				cnt++;
				h = H[j];
			}
			if (H[i] <= H[j]) break;
		}
	}
	return cnt;
}

int main(){
	int ans = -1;
    InputData();//	입력 함수

	ans = Solve();//	코드를 작성하세요
	
	cout << ans << endl;//출력
    return 0;
}
