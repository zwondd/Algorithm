/*
   - 백준 1149번: RGB거리 
   - DP로 재풀이 : 통과 
 */
#include <stdio.h>

int rgbAry[1001][3];
int costs[1001][3];
int minCost=1000000;
int N;


void getMinCost();

int main()
{
	int i=0;
	scanf("%d",&N);
	for(i=1; i<=N; i++)
	{
		scanf("%d %d %d", &rgbAry[i][0], &rgbAry[i][1], &rgbAry[i][2]);
	}

	getMinCost();
	printf("%d\n",minCost);
}

void getMinCost()
{
	int i=0;

	costs[1][0] = rgbAry[1][0];
	costs[1][1] = rgbAry[1][1];
	costs[1][2] = rgbAry[1][2];

	for(i=2; i<=N; i++)
	{
		costs[i][0] = (costs[i-1][1] < costs[i-1][2])? costs[i-1][1]:costs[i-1][2];
		costs[i][0] += rgbAry[i][0];

		costs[i][1] = (costs[i-1][0] < costs[i-1][2])? costs[i-1][0]:costs[i-1][2];
		costs[i][1] += rgbAry[i][1];

		costs[i][2] = (costs[i-1][0] < costs[i-1][1])? costs[i-1][0]:costs[i-1][1];
		costs[i][2] += rgbAry[i][2];

	}

	for(i=0; i<3; i++)
		minCost = (minCost < costs[N][i])? minCost:costs[N][i];
}
