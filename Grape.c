/*
   - 백준 2156번 : 포도주 시식
   - DP 풀이
   - Case according to continuity of grape drink (0,1,2)
 */
#include <stdio.h>

int N;
int drink[10000];
int used[10000][3];
int sum[3]={0,};
int max=0;

int dp[10000];

/*
void setUsed()
{
	int i,j;

	used[1][1] = 1;
	used[1][2] = 1; 
	used[1][3] = 0;

	if( N>=2 )
	{
		used[2][1] = 1;
		used[2][2] = 0; 
		used[2][3] = 1;


		for(i=3; i<=N; i++)
		{
			for(j=1; j<=3; j++)
			{
				if( used[i-2][j] == used[i-1][j] )
				{
					used[i][j] = 0;
				}
				else
				{
					used[i][j] = 1;
				}
			}
		}
	}
}
*/

void findMaxAmount()
{
	int i,j;
	int cont[3]={0,};

	dp[0] = 0;
	dp[1] = drink[1];

	if( N >= 2 )
	{
		dp[2] = dp[1] + drink[2];
	
		for( i=3; i<=N; i++ )
		{
			int max_cont=0;

			cont[0] = dp[i-1];
			cont[1] = dp[i-2] + drink[i];
			cont[2] = dp[i-3] + drink[i-1] + drink[i];

			printf("cont 0 : %d \n", cont[0]);
			printf("cont 1 : %d \n", cont[1]);
			printf("cont 2 : %d \n", cont[2]);

			for( j=0; j<3; j++ )
			{
				if( cont[j] > max_cont )
					max_cont = cont[j];
			}

			dp[i] = max_cont;
			printf(" dp[%d] : %d \n", i, dp[i]);
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
	printf("%d\n",dp[N]);
}

