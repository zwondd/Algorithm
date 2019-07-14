/*
    19.07.14
    LG codpro - 마리오게임
 */

#include <iostream>
using namespace std;

int N;//버섯 수
int P[150000 + 10];//버섯 값

void InputData(){
	cin >> N;
	for (int i = 0; i < N; i++){
		cin >> P[i];
	}
}

int main(){
	int ans = -1;

	InputData();			//	입력 함수

	//	코드를 작성하세요
    int total = 0;

    int sum = P[0];
    for(int i=1; i<N; i++) {
        if ( P[i-1] < P[i] ) sum = sum - P[i-1] + P[i];
    }

    // for(int i=0; i<N; i++) {
    //     int start = P[i];
    //     cout<<"start : "<<start<<endl;

    //     int tmpTotal = 0;
    //     for(int j=i+1; j<N; j++) {
    //         if ( start-P[j] < 0 ) {
    //             i=j-1;
    //             break;
    //         }
    //         tmpTotal = (start-P[j] > tmpTotal) ? start-P[j] : tmpTotal;
    //         i=j-1;
    //         cout<<"tmpToal : "<<tmpTotal<<endl;
    //     }
    //     total+=tmpTotal;
    //     if (i==N-2)
    //         break;
    // }
    // ans = total;

    ans = sum;
	
	
	cout << ans << endl;	//	정답 출력
	return 0;
}
