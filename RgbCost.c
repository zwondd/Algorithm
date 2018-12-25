#include <stdio.h>

#define R 0
#define G 1
#define B 2

int rgbAry[1001][3];
int rgbUsed[1001];
int minCost=1000000;
int costs[4];
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
	printf("***********minCost: %d\n", minCost);
}

void getMinCost(int n, int cost)
{
	int i=0;
	printf(" n: %d, cost: %d\n", n, cost);
	if(n==N+1)
	{
		minCost = (cost<minCost)? cost : minCost;
		printf("compare -> minCost: %d\n", minCost);
		return;
		//		getMinCost(n-1, minCost);
	}
	else
	{
		for(i=0; i<3; i++)
		{
			if(n==1 || n==N || (rgbUsed[n-1]!=i && rgbUsed[n]!= rgbUsed[n-1]))
			{
				int j=0;
				cost+=rgbAry[n][i];
				rgbUsed[i] = i;
				getMinCost(n+1, cost);
				cost-rgbAry[n][i];
			}
		}

	}
}
