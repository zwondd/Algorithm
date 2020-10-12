/*
    201012
    LG codepro - [19년도 5차] 인기투표
 */

#include <iostream>
#include <string.h>
using namespace std;

int N;//후보자수
char str[10000 + 10][20 + 10];//후보자 이름
int M;//투표참가인원
char name[100000 + 10][20 + 10];//투표용지에 써있는 이름
int score[100000 + 10];//점수

int strSum[10000+10]={0,};

void InputData(){
	int i;
	cin >> N;
	for (i = 0; i < N; i++){
		cin >> str[i];
	}
	cin >> M;
	for (i = 0; i < M; i++){
		cin >> name[i] >> score[i];
	}
}

// Pass Rate (3/10) 
// Timeout O(N^2)
void solve_1() {
    for(int i=0; i<N; i++) {
		for(int j=0; j<M; j++) {
			if ( strcmp(str[i],name[j]) == 0 )  {
				strSum[i]+=score[j];
			}
		}
	}	
	for(int k=0; k<3; k++) {
		int max=0;
		for(int i=0; i<N; i++) {
			max = (strSum[max]<strSum[i]) ? i:max;
		}
		cout<<str[max]<< " " <<strSum[max]<<endl;
		strSum[max]=-1;
	}
}


void solve_2() {
    for(int i=0; i<N; i++) {
		for(int j=0; j<M; j++) {
			if ( strcmp(str[i],name[j]) == 0 )  {
				strSum[i]+=score[j];
			}
		}
	}	
	for(int k=0; k<3; k++) {
		int max=0;
		for(int i=0; i<N; i++) {
			max = (strSum[max]<strSum[i]) ? i:max;
		}
		cout<<str[max]<< " " <<strSum[max]<<endl;
		strSum[max]=-1;
	}
}




int main(){
	InputData();//	입력 함수

    // solve1(); Timeout

	
	

	return 0;
}
