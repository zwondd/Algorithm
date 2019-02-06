/*
   - 백준 1463번 : 1로 만들기
   - DP 풀이
*/

#include <stdio.h>

int N;
int dp[1000001];

void findMinCal()
{
    int i;
    
    dp[0] = 0;
    dp[1] = 0;

    for(i=2; i<=N; i++)
    {
        dp[i] = dp[i-1] + 1;
        if( i%3 == 0 )
        {
            dp[i] = ( dp[i/3] + 1 ) < dp[i] ? ( dp[i/3] + 1 ) : dp[i];
        }
        if( i%2 == 0 )
        {
            dp[i] = ( dp[i/2] + 1 ) < dp[i] ? ( dp[i/2] + 1 ) : dp[i];
        }
    }


}

int main()
{
	int i;
	scanf("%d",&N);
	findMinCal();
	printf("%d\n",dp[N]);
}
