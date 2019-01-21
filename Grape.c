/*
   - 백준 2156번 : 포도주 시식
   - DP 풀이
 */
#include <stdio.h>

int N;
int grape[10000];
int used[10000][3];
int sum[3]={0,};
int max=0;

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

void findMaxAmount()
{
	int i,j;

	setUsed();

	for(i=1; i<=N; i++)
	{
		for(j=1; j<=3; j++)
		{
			if( used[i][j] == 1 )
			{
				sum[j] += grape[i];
			}
		}
	}

	for(i=1; i<=3; i++)
	{
		if(sum[i] > max)
			max = sum[i];

	}

}

int main()
{
	int i;
	scanf("%d",&N);
	for(i=1; i<=N; i++)
	{
		scanf("%d",&grape[i]);
	}
	findMaxAmount();
	printf("%d\n",max);
}

