/*
   - 백준 11053번: 가장 긴 증가하는 부분 수열 
   - DP 
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int ary[1001];
int distArr[1001];
int N;
int maxDist;

void findLongestSeries(){
	int i;
	int j;

	for(i=1; i<=N; i++)
	{
		int dist=0;
		for(j=0; j<i; j++)
		{
			if(ary[i]>ary[j] && distArr[j]>dist){
				dist=distArr[j];	
			}
		}
		distArr[i] = dist+1;
	}

	for(i=1; i<=N; i++)
	{
		if(maxDist<distArr[i])
		{
			maxDist=distArr[i];
		}
	}
}

int main()
{
	int i=1;
	char str[10000];
	char * res;

	fgets(str, sizeof(str), stdin);
	str[strlen(str)-1]='\0';
	N = atoi(str);

	fgets(str, sizeof(str), stdin);
	str[strlen(str)-1] = '\0';

	res = strtok(str," ");
	while(res != NULL)
	{
		ary[i++] = atoi(res);
		res = strtok(NULL," ");
	}

	findLongestSeries();
	printf("%d",maxDist);
}

