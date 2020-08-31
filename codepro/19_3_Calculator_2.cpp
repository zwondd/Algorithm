/*
    200830
    LG codepro - [19년도_3차] 계산기
	solution(answer) 보고 다시 푼 것 .
    1. 자릿수 i,j의 곱셈의 자릿수 최대 : i+j
    2. 뒤에서 부터 진법 계산. 만약 B보다 크면 몫은 올림, 나머지는 해당 자리에 
    3. Runtime error -> 배열 참조 잘 못 했을 때 (배열의 크기 잘 계산해야함.-최대배열의 크기)
        sol 의 경우 100자리+100자리 -> 약 200자리 정도 나옴? 거기서 여유롭게 210이상으로 계산.
    4. char 로 계산할 때 string 으로 0~Z까지 선언해서 쓰는 것도 하나의 방법.

 */
#include <iostream>
using namespace std;

int N;//테스트 케이스 수
int B;//진법
char S[110];//첫 번째 정수
char D[110];//두 번째 정수

void InputData(){
	cin >> B >> S >> D;
}
char convToChar ( int n ) {
    if ( n<10 )
        return n+'0';
    return n-10+'A';
}
int convToInt(char p){
    if ( p>='A' && p<='Z' ) {
        return p-'A'+10;
    }
    return p-'0';
}
void convArr(char* carr, int* iarr) {
    while(*carr != '\0') {
        if ( *carr == '-' ) {
            carr++; 
            continue;
        }
        *iarr = convToInt(*carr);
        carr++; 
        iarr++;
    }
}
void getLength(int* l, char* arr) {
    int i=0; 
    while(*arr!='\0') {
        if ( *arr!='-') i++;
        arr++;
    }
    *l = i;
}
void solve() {
    int slen, dlen, ss=1, ds=1;
    int sToDec[110], dToDec[110], sol[210]={0,};

    // get length of string
    getLength(&slen, S); 
    getLength(&dlen, D);

    // convert to decimal arry
    convArr(S, sToDec);
    convArr(D, dToDec);

    // for(int i=0; i<slen;i++)
    //     cout<<sToDec[i]<<" ";
    // cout<<endl;
    // for(int i=0; i<dlen;i++)
    //     cout<<dToDec[i]<<" ";
    // cout<<endl;

    // cout<<" slen : "<<slen<<" dlen : "<<dlen<<endl;

    // multiply from backward and update digit
    for(int i=0; i<slen; i++) {
        for(int j=0; j<dlen; j++) {
            sol[i+j] += sToDec[i] * dToDec[j];
        }
    }

    for(int i=slen+dlen-2; i>0; i--) {
        // printf("sol[%d] : %d \n" ,i, sol[i]);
        if (  sol[i]>=B ) {
            sol[i-1] += sol[i]/B;
            sol[i] = sol[i]%B;
        }
        // printf("sol[%d] : %d \n" ,i, sol[i]);
    }
    // printf("sol[0] : %d \n" ,sol[0]);

    if ( sol[0] == 0 ) {
        printf("0\n");  return;
    } 

    if ( S[0] == '-' ) ss=-1;
    if ( D[0] == '-' ) ds=-1;
    if ( ss*ds <= -1 ) {
        printf("%c",'-');
    }
    
    if ( sol[0] < B ) {
        printf("%c",convToChar(sol[0]) );
    } else {
        printf("%c",convToChar(sol[0]/B) );
        printf("%c",convToChar(sol[0]%B) );
    }

    for(int i=1; i<slen+dlen-1; i++) {
        printf("%c", convToChar(sol[i]) );
    }
    printf("\n");
}

int main() {
	int i;
	scanf("%d", &N);
	for(i = 0; i < N; i++){
		InputData();//입력 함수
		//	코드를 작성하세요
        solve();
	}
	return 0;
}