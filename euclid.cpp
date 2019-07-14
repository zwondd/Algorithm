/*
    19.07.14
    LG codpro - 유클리드 호제법
    - 재귀
 */
#include <iostream>

using namespace std;

int GCD(int m, int n);

// 작성해야 할 함수
int GCD(int m, int n)
{
    if ( n==0 ) 
        return m;

    if ( m%n == 0 )
        return n;

    if ( m==0 && n!=0 )
        return m;
    else if ( m!=0 && n==0 )
        return n;

    int temp = m%n;
    m = n;
    n= temp;
    return GCD(m,n);
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