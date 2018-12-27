/*
  - 백준 1149번: RGB거리 
  - 시간 초과 
*/
#include <stdio.h>

int rgbAry[1001][3];
int rgbUsed[1001]={-1,};
int minCost=1000000;
int N;


void getMinCost(int n, int cost);

int main()
{
	int i=0;
	scanf("%d",&N);
	for(i=1; i<=N; i++)
	{
		scanf("%d %d %d", &rgbAry[i][0], &rgbAry[i][1], &rgbAry[i][2]);
	}

	getMinCost(1, 0);
	printf("%d\n",minCost);
}

void getMinCost(int n, int cost)
{
	int i=0;
	if(n==N+1)
	{
		minCost = (cost<minCost)? cost : minCost;
		return;
	}
	else
	{
		for(i=0; i<3; i++)
		{
			if(rgbUsed[n-1]!=i)
			{
				cost+=rgbAry[n][i];
				rgbUsed[n] = i;
				getMinCost(n+1, cost);
				cost-=rgbAry[n][i];
				rgbUsed[n] = -1;
			}
		}

	}
}
