
// 유클리드 호제법 (최대공약수)
#include <stdio.h>

int GCD(int m, int n);

int GCD_2(int m, int n)
{
	int mod = -1;
	
	while ( mod != 0 ) 
	{
		// printf("mod : %d \n",mod);
		mod = m % n;
		if ( mod == 0 )
		{
			return n;
			// break;
		}
		else
		{
			m = n;
			n = mod;
		}
	}
	//return n;
}

int GCD2 (int m, int n)
{
	return n ? GCD(n, m%n) : m;
}

int main(void)
{
	int m, n, r;
	
	// 입력 받는 부분
	scanf("%d %d",&m, &n);
	
	// 큰수를 변수 m에 대입
	if (m < n)
	{
		r = m; 
		m = n; 
		n = r;
	}
	
	r = GCD(m,n);

	printf("%d\n",r);
}