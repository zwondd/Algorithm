/*
    19.07.14
    LG codpro - 유클리드 호제법
    - 모범답안
 */
#include <iostream>

using namespace std;

int GCD(int m, int n);

// 작성해야 할 함수
int GCD(int m, int n)
{
    return n ? GCD(n,m%n) : m;
}

int main(void)
{
	int m, n, r;
	
	// 입력 받는 부분
	cin >> m >> n;
	
	// 큰수를 변수 m에 대입
	if (m < n)
	{
		r = m; m = n; n = r;
	}

	r = GCD(m,n);

	cout << r;
}