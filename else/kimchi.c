#include <stdio.h>

long long int kimchi(int n){
	long long int dp[1000]={0,1,1,1,};
	int i;
	for (i=4; i<=n; i++) {
		if (i%3 == 0)
			dp[i] = 3*dp[i-1] -2*dp[i-2]-dp[i-3];
		else if(i%3 ==1)
			dp[i] = 3*dp[i-1] -2*dp[i-2]+dp[i-3];
		else 
			dp[i] = 2*dp[i-1] -2*dp[i-2] + dp[i-3];
	}
}

int main(void){
	int T;
	scanf("%d", &T);
	printf("%lld", kimchi(T));
	return 0;
}
