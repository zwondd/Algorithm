/*
    200822
    LG codepro - [20년도_2차] 그림인식
	2hr..
	fail case - 3개 있음..아직 모름.
	문제 이해 잘 못함! 덧칠하지 않은 색의 개수를 찾아야 함.
	즉 색 아래에 다른 색이 칠해져 있는 경우를 제외해야하므로
	minx~maxx, miny~maxy 사이에 현재 자신의 color 가 아닌 다른 color 칠해져 있을 경우 그 color 는 
	current color 위에 칠해져 있으므로 정답에서 제외해야함. 
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

int check[10] = {0,};

void InputData(){
	cin >> N;
	for (int i = 0; i < N; i++) cin >> A[i];
	for(int i=0; i<N; i++) {
		for(int j=0; j<N; j++) {
            //A[i][j] -= '0';
			if ( arr[A[i][j]-'0'] == 0 && A[i][j] !='0'  ) {
                // printf("color : %d \n", A[i][j] );
				arr[A[i][j]-'0'] = 1;
				usedColor+=1;
			}
				
		}
	}
    // printf("use : %d \n", usedColor);
}

void solve(int curColor) {
	check[curColor]++;

	int minX=10, minY=10, maxX=0, maxY=0;
	for(int i=0; i<N; i++) {
		for(int j=0; j<N; j++) {
			if ( A[i][j]-'0' == curColor ) {
				minX = (minX>i) ? i:minX;
				maxX = (maxX<i) ? i:maxX;
				minY = (minY>j) ? j:minY;
				maxY = (maxY<j) ? j:maxY;
			}
		}
	}
	// printf("[%d] min x %d, y %d /// max x %d, y %d \n",curColor, minX, minY, maxX, maxY);


	// fail
	for(int i=minX; i<=maxX; i++) {
		for(int j=minY; j<=maxY; j++) {
			if ( A[i][j]-'0' != curColor && visited[A[i][j]-'0'] == 0 ) {
				// printf(" removed color : %d \n", A[i][j]-'0');
				visited[A[i][j]-'0'] = 1;
				usedColor-=1;
				// return;
			}
		}
	}

	// success
	// for(int i=minX; i<=maxX; i++) {
	// 	for(int j=minY; j<=maxY; j++) {
	// 		if ( A[i][j]-'0' != curColor ) {
	// 			check[A[i][j]-'0']++;
	// 		}
	// 	}
	// }
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

	// int cnt=0;
	// for(int i=1; i<=9; i++) {
	// 	printf("check : %d \n", check[i]);
	// 	if ( check[i] == 1 ) cnt++;
	// }

	
	// ans = cnt;
	ans = usedColor;
	cout << ans << endl;//출력
	return 0;
}
