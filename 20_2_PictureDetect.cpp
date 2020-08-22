/*
    200822
    LG codepro - [20년도_2차] 그림인식
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

void solve(int color, int minX, int minY) {
	int maxX=N, maxY=N;
	for(int i=minX; i<N; i++) {
        if ( A[i][minY] != color ) {
            maxX = i;
            break;
        }			
	}
	
	for(int i=0; i<N; i++) {
        if ( A[minX][i] != color ) {
            maxY = i;
            break;
        }		
	}
	
    printf(" color : %d, [min] x : %d, y: %d //  [max] x: %d, y: %d \n", color, minX, minY, maxX, maxY);
	for(int i=minX; i<N; i++) {
		for(int j=minY; j<N; j++) {
			if ( A[i][j] == color ) { 
                if ( i>=maxX || j>=maxY ) {
                    printf("a[i][j] : %d \n", A[i][j]);
                    usedColor-=1;
                    return;
                }
			}
		}
	}
}

int main(){
	int ans = -1;
	InputData();//	입력 함수

	//	코드를 작성하세요
	for(int i=0; i<N; i++) {
		for(int j=0; j<N; j++) {
			if ( A[i][j]!=0 && visited[A[i][j]]==0 ) {
				solve(A[i][j], i, j);
				visited[A[i][j]]=1;
			}
		}
	}

	
	ans = usedColor;
	cout << ans << endl;//출력
	return 0;
}
