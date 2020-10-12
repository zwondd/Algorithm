/*
    201012
    LG codepro - [19년도 5차] 인기투표
	1. 이진탐색
		이름 알파벳 순으로 정렬-> 이진탐색으로 같은 이름의 lower~upper 까지 합: O(NM)
	2. Hash Table 사용
 */

#include <iostream>
#include <stdlib.h> 
#include <string.h>
using namespace std;

int N;//후보자수
char str[10000 + 10][20 + 10];//후보자 이름
int M;//투표참가인원
char name[100000 + 10][20 + 10];//투표용지에 써있는 이름
int score[100000 + 10];//점수

int idx[100000 + 10];
typedef struct{
	int id;
	int score;
} STRSUM;

int comp(const void *a, const void*b ) {
	const int x=*(const int*)a, y=*(const int*)b;
	return strcmp(name[x], name[y]);
}

int comp2(const void *data1, const void* data2) {
	const STRSUM x=*(const STRSUM*)data1, y=*(const STRSUM*)data2;
	if ( x.score == y.score ) {
		return x.id>y.id;
	}
	return x.score<y.score;
}

int bslow(int s, int e, int d) {
	int m, sol=-1, r;
	while( s<=e ) {
		m = (s+e)/2;
		r = strcmp( name[idx[m]], str[d] );
		if ( r==0 ) {
			sol=m; 
			e=m-1;
		}
		else if (r>0) e=m-1;
		else s=m+1;
	}
	return sol;
}

// Pass Rate (8/10) 
//  why???
void solve_binary() {
	int i, j, low;
	STRSUM data[10000+10];

	for(i=0; i<M; i++) {
		idx[i] = i;
	}
	qsort(idx, M, sizeof(idx[0]), comp);

	cout<<"=============="<<endl;
	for(int i=0; i<M; i++) {
		cout<<idx[i]<<" "<<name[idx[i]]<<endl;
	}
	cout<<"=============="<<endl;

	int dataSize=0;
	for(i=0; i<N; i++) {
		data[i].id = i; 
		data[i].score=0;
		low = bslow(0, M-1, i);
		if ( low<0 ) continue;
		dataSize++;
		for(j=low; (j<M) && !strcmp(str[i], name[idx[j]]); j++) {
			data[i].score += score[idx[j]];
		}
		cout<<" *** "<<str[data[i].id]<<"  "<<data[i].score<<endl;
	}
	cout<<"dataSize : "<<dataSize<<endl;

	qsort(data, dataSize, sizeof(data[0]), comp2);
	cout<<"======data========"<<endl;
	for(int i=0; i<dataSize; i++) {
		cout<<str[data[i].id]<<" "<<data[i].score<<endl;
	}
	cout<<"=============="<<endl;

	for(int i=0; i<3; i++) {
		cout<<str[data[i].id]<<" "<<data[i].score<<endl;
	}

}


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

int main(){
	InputData();//	입력 함수

	solve_binary();
	return 0;
}
