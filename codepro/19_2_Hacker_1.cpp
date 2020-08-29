/*
    200824
    LG codepro - [19년도_2차] 해커대회
	my solution - TC 4/10 success (나머지 모두 timeout)
	배열의 경우 삽입, 삭제 시 메모리 이동이 빈번하게 됨 
	-> 링크드 리스트로 메모리 이동을 하지 않고 메모리 연결만 해줌.
	or 두개의 stack을 이용해서도 해결 가능
 */
#include <iostream>
#include <cstring>
using namespace std;

char str[100000 + 10];//초기 문자열
char cmd[500000 + 10];//명령어 문자열

// 항상 left 의 기준으로 설정.
// cursor 의 index 0~N (N+1 개)


void InputData(){
	cin >> str;
	cin >> cmd;
}

int main(){
	InputData();//	입력 함수
	
	// cursor 의 초기 index ( 초기문자열 크기)
	int cursorIdx=0;
	char * s = str;
	while(str[cursorIdx]!='\0') {
		cursorIdx++;
	}
	int maxStrIdx = cursorIdx;
	int cmdIdx=0;
	
	//printf("maxStrIdx %d \n",maxStrIdx);
	

	// while(cmd[cmdIdx]!='\0') {
	for(int cmdIdx=0; cmd[cmdIdx]; cmdIdx++) {
		//printf("cmd : %c \n", cmd[cmdIdx]);
		if ( cmd[cmdIdx] == 'L' && cursorIdx!=0 ) {
			cursorIdx-=1;
		}
		
		if ( cmd[cmdIdx] == 'R' && cursorIdx!=maxStrIdx ) {
			cursorIdx+=1;
		}
		
		if ( cmd[cmdIdx] == 'B' && cursorIdx!=0 ) {
			int temp = cursorIdx;
			
			for(int i=cursorIdx-1; i<maxStrIdx ; i++) {
				str[i] = str[i+1];
			}
			maxStrIdx-=1;
			cursorIdx-=1;
		}
		
		if ( cmd[cmdIdx]>='a' && cmd[cmdIdx]<='z' ) {
			maxStrIdx+=1;
			for(int i=maxStrIdx; i>cursorIdx; i--) {
				str[i] = str[i-1];
			}
			str[cursorIdx] = cmd[cmdIdx];
			cursorIdx+=1;
		}
		
		//printf("== str %s \n", str);
		//printf("=== cursorIdx : % d\n", cursorIdx);

		// cmdIdx++;
	}
	
	cout<<str;
	
	//printf("cursor : %d \n", cursorIdx);
	//printf("%d %d %d %d", 'A','Z','a','z');	
	return 0;
}
