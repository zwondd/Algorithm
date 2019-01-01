/*
   - 백준 11053번: 가장 긴 증가하는 부분 수열 
   - DP 
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int ary[1001];
int N;


int main()
{
	int i=0;
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
		printf("%d : %d\n", i, ary[i]);
	}

}

