/*
    19.07.20
    LG codepro - 데이터 리오더링
 */

#include <iostream>
using namespace std;

unsigned int Make_Data(unsigned int rcv);

// 작성할 함수
unsigned int Make_Data(unsigned int rcv)
{
	int sol = 0;
	sol = (rcv&15) <<28  ;
	sol += ((rcv>>15) & 15) << 24;
	sol += ((rcv>>26) & 63) << 18;
	sol += ((rcv>>9) & 3)<<16;
	sol += ((rcv>>23) & 7 )<<13;
	sol += ((rcv>>4) & 31)<<8;
	sol += ((rcv>>11) & 15)<<4;
	sol += ((rcv>>19) & 15) <<0;
	return sol;
}

int main(void)
{
	unsigned int rcv=0,sol;
	
	// 입력 받는 부분
	cin >> hex >> uppercase >> rcv;
	
	sol = Make_Data(rcv);

	cout << hex << uppercase << sol;
}