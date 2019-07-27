/*
    19.07.27
    LG codepro - LED
 */

#include <iostream>
#include <queue>
using namespace std;

int N;//LED 수
int S[100000 + 10];//LED 상태

int pattern[100000 + 10];


void InputData(){
	cin >> N;
	for (int i = 0; i < N; i++){
		cin >> S[i];
	}
}

int findLogestPattern() {
    int length=1, pIdx=0, max=0, part=1;

    for(int i=1; i<N; i++) {
        if ( S[i]!=S[i-1]) {
            length++;
        } else {
            pattern[pIdx++] = length;
            length=1;
        }
    }
    pattern[pIdx++]=length;

    if ( pIdx < 2 ) {
        for(int i=0; i<pIdx; i++) {
            max+=pattern[i];
        }
    } else {
        max = pattern[0] + pattern[1] + pattern[2];
        part = pattern[1] + pattern[2];
        for(int i=3; i<pIdx; i++) {
            part+=pattern[i];
            if ( max < part ) max = part;
            part-=pattern[i-2];
        }
    }
    return max;
}

int main(){
	int ans = -1;

	InputData();			//	입력 함수

	//	코드를 작성하세요
    ans = findLogestPattern();
    
	cout << ans << endl;	//	정답 출력
	return 0;
}


