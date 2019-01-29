/*
   - 백준 2156번 : 포도주 시식
   - DP 풀이
   - Case according to continuity of grape drink (0,1,2)

   - drink, dp 배열 index 1부터 시작시 N+1 개로 배열선언 해줘야함.
 */

#include <stdio.h>

int N;
int drink[10001];
int dp[10001];

void findMaxAmount()
{
	int i,j;
	int cont[3]={0,};

	dp[1] = drink[1];

	if( N > 1 )
	{
		dp[2] = drink[1] + drink[2];
	}

	if( N > 2 )
	{
		for( i=3; i<=N; i++ )
		{
			cont[0] = dp[i-1];
			cont[1] = dp[i-2] + drink[i];
			cont[2] = dp[i-3] + drink[i-1] + drink[i];

			int max_cont=cont[0];
			for( j=1; j<3; j++ )
			{
				if( cont[j] > max_cont )
					max_cont = cont[j];
			}

			dp[i] = max_cont;
		}
	}
}

int main()
{
	int i;
	scanf("%d",&N);
	for(i=1; i<=N; i++)
	{
		scanf("%d",&drink[i]);
	}
	findMaxAmount();
	printf("%d",dp[N]);
}
