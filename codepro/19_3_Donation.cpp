/*
    200829
    LG codepro - [19년도_3차] 기부금
	my solution 
    3/10 : fail  (기부금의 총액 더해서 total 값 구할 때 total 이 overflow 나게 됨.)
    int 범위 약 21억 (2,150,000,000)
    (10억-5억)* 백만 = int 범위 벗어나게됨.
    1. long long 사용
    2. 뺄셈으로 변경
 */
#include <iostream>
using namespace std;

int N;//직원 수
int M;//기부금 총액
int A[1000010];//직원 별 성과급

int maxA=0;

int maxDonation;

void InputData(){
	cin >> N >> M;
	for (int i = 0; i < N; i++){
		cin >> A[i];
	}
}

int check(int h){
	int i, sum = M;
	for (i = 0; i < N; i++){
		if (h < A[i]) {
			sum -= A[i] - h;
			if (sum <= 0) return 1;
		}
	}
	return 0;
}
void BinarySearch(int start, int end) {
    // cout<<"start : "<<start<<" end : "<<end<<endl;

    if ( start>end ) return;

    int middle = (start+end)/2;
    // printf("start: %d, end: %d \n", start, end);


    // 상한액 때문에 overflow 때문에 음수로 판단할 수 있음...
    // 변수가 범위 벗어나지 않는지...
    // 항상 N번 돌기 때문에 시간이 많이 걸림 -> 빼나가는 방법으로
    long long total=0;
    for(int i=0; i<N; i++) {
        // if ( A[i] <= middle ) continue;
        if ( middle<A[i]) {
            total += A[i]-middle;
        }
    }
    // printf("total : %d \n", total);
    if ( total >= M ) {
        maxDonation = middle;
        BinarySearch(middle+1, end);
    }
    else {
        BinarySearch(start, middle-1);
    }
}

int Solve() {
    for(int i=0; i<N; i++) {
        maxA = ( maxA< A[i] ) ? A[i]:maxA;
    }
    BinarySearch(0, maxA);
    return maxDonation;
}

int main(){
	int ans = 0;

	InputData();			//	입력 함수
    ans = Solve();
	cout << ans << endl;	//	정답 출력
	return 0;
}
