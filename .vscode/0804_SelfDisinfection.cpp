/*
    19.08.04
    LG codepro - Self Disinfection 
 */

#include <iostream>
using namespace std;

int y[110];		//	살균대상의 y 좌표 배열
int x[110];		//	살균대상의 x 좌표 배열
int N;				//	필터 한 변의 크기
int L;				//	LED의 범위(길이) 
int M;				//	살균대상의 개수
int sol;			//	정답

void Input(void){
	cin >> N >> L >> M;
	for (int i = 0; i < M; i++)		
        cin >> y[i] >> x[i];
}

int main(void){
	
	Input();

    int maxCnt = 0;
    for(int i=0; i<M; i++) {
        for(int j=1; j<=L/2-1; j++) {
            // cout<<" j : "<<j <<'\n';
            int coordCnt , x_bound, y_bound;
            coordCnt=1; 
            x_bound = x[i] + j;
            y_bound = y[i] + (L/2-j);
            for(int k=i+1; k<M; k++) {
                if ( x[k] >= x[i] && x[k] <= x_bound && y[k] >= y[i] && y[k] <= y_bound ) 
                    coordCnt++;
            }
            maxCnt = (maxCnt < coordCnt ) ? coordCnt : maxCnt;
            // cout<<"maxCnt : "<<maxCnt<<'\n';
        }
    }
    sol = maxCnt;

	//	정답출력
	printf("%d", sol);

	return 0;
}