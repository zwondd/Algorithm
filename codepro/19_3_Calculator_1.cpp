/*
    200830
    LG codepro - [19년도_3차] 계산기
	my solution 
    1/10 (통과율)  
    약 2시간 30분 걸림...
    sample tc 외에 모두 fail...
 */
#include <iostream>
#include <math.h>

using namespace std;

int N;//테스트 케이스 수
int B;//진법
char S[110];//첫 번째 정수
char D[110];//두 번째 정수
char res[110][110];
int idxarr[2][4] = {0,};
int minusCnt=0;
int maxCnt;

void InputData(){
	cin >> B >> S >> D;
}

char ConvertDecimal(long long num) {
	if ( num>=10 )
		return num-10+'A';
	
	return num-0+'0';
}

void ConvertNumber(long long num, int k, int idx) {
	maxCnt++;
	long long div = num/B;
	long long mod = num%B;
	if ( div<B ) {
		res[idx][maxCnt-k-1] = ConvertDecimal(div);
		res[idx][maxCnt-k] = ConvertDecimal(mod);
		// cout<<"k : "<<k<<" maxCnt-k : "<<maxCnt-k-1<< " " <<ConvertDecimal(div)<< endl;
		// cout<<"k : "<<k<<" maxCnt-k+1 : "<<maxCnt-k<<" "<<ConvertDecimal(mod)<<endl;
		return;
	}	else {
		ConvertNumber(div, k+1, idx);
	}
	res[idx][maxCnt-k] = ConvertDecimal(mod);
	// cout<<"k : "<<k<<" maxCnt-k+1 : "<<maxCnt-k<<" "<<ConvertDecimal(mod)<<endl;
}

int Convert(char t) {
	if ( t>='A' && t<='Z' ) {
		return 10+t-'A';
	} 
	return t-'0';
}

long long Multiply (char* p, int k) {
	long long temp=0;
	int j=0;
	for(int i=idxarr[k][0]; i<=idxarr[k][1]; i++) {
		// cout<<"pow : "<<pow(B,idxarr[k][2]-j)<<" convert : "<<Convert(p[i])<<endl;
		temp+=(pow(B,idxarr[k][2]-j)*Convert(p[i]));
		j++;
	}
	return temp;
}

void CalIdx(char* p, int k) {
	for(int i=0; p[i]!='\0'; i++) {
		if ( i==0 && p[i]== '-' ) {
			minusCnt++; 
			idxarr[k][0]++;
		}
		idxarr[k][1]++;
	}
	idxarr[k][1]-=1;
	
	idxarr[k][2] = idxarr[k][1]-idxarr[k][0];
}

void Solve(int idx) {
	long long S10, D10, result;
	
	// initialize
	minusCnt = 0;
	for(int i=0; i<2; i++) {
		for(int j=0; j<3; j++) {
			idxarr[i][j]=0;
		}
	}
	res[idx][0]='\0';
	
	
	CalIdx(S, 0); S10 = Multiply(S,0);
	CalIdx(D, 1); D10 = Multiply(D,1);
	result = S10*D10;

	if ( result == 0 ) {
		res[idx][0]='0'; res[idx][1]='\0';
		return;
	}
		
	maxCnt=0;
	if ( minusCnt == 1 ) {
		res[idx][0]='-'; maxCnt++;
		ConvertNumber(result,0, idx);
	} else {
		ConvertNumber(result,0, idx);
	}
	res[idx][maxCnt+1]='\0';
}

int main(){
	int i;
	scanf("%d", &N);
	for(i = 0; i < N; i++){
		InputData();//입력 함수
		Solve(i);
	}

    for(i=0; i<N; i++)
     cout<<res[i]<<endl;

	return 0;
}