/*
    200822
    LG codepro - [20년도_2차] 그림인식
	2hr..
	fail case - 3개 있음..아직 모름.
 */

// Fail case 
// 3
// 122
// 122
// 222

#include <iostream>
#include <cstring>
using namespace std;

int N;//도화지 크기
char A[10 + 2][10 + 2];//도화지 색정보
int arr[10] = {0,};
int visited[10] = {0,};
int usedColor=0;

void InputData(){
	cin >> N;
	for (int i = 0; i < N; i++) cin >> A[i];
	for(int i=0; i<N; i++) {
		for(int j=0; j<N; j++) {
            A[i][j] -= '0';
			if ( arr[A[i][j]] == 0 && A[i][j] !=0  ) {
                // printf("color : %d \n", A[i][j] );
				arr[A[i][j]] = 1;
				usedColor+=1;
			}
				
		}
	}
    // printf("use : %d \n", usedColor);
}

void solve(int curColor) {
	int minX=10, minY=10, maxX=0, maxY=0;
	for(int i=0; i<N; i++) {
		for(int j=0; j<N; j++) {
			if ( A[i][j] == curColor ) {
				minX = (minX>i) ? i:minX;
				minY = (minY>j) ? j:minY;
				maxX = (maxX<i) ? i:maxX;
				maxY = (maxY<j) ? j:maxY;
			}
		}
	}
	// printf("[%d] min x %d, y %d /// max x %d, y %d \n",curColor, minX, minY, maxX, maxY);

	for(int i=minX; i<=maxX; i++) {
		for(int j=minY; j<=maxY; j++) {
			if ( A[i][j] != curColor ) {
				usedColor-=1;
				return;
			}
		}
	}
}


int main(){
	int ans = -1;
	InputData();//	입력 함수

	for(int i=1; i<=9; i++) {
		if ( arr[i]==1 ) {
			// printf("solve : %d \n", i);
			solve(i);
		}
	}

	
	ans = usedColor;
	cout << ans << endl;//출력
	return 0;
}
