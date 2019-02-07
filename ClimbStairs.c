/*
   - 백준 2579번 : 계단오르기 
   - DP 풀이
*/


#include <stdio.h>

int N;
int score[301]={0,};
int dp[301];

void findMaxScore()
{
    int i;
    int comp1, comp2, comp3;

    dp[0] = 0;
    dp[1] = score[1];
    
    if(N>=2)
    {
        dp[2] = score[1] + score[2];  
    }
    if(N>=3)
    {
        dp[3] = ((score[1] > score[2]) ? score[1] : score[2]) + score[3];
    }
    if(N>=4)
    {
        dp[4] = (score[2] > score[3] ? score[2] : score[3]) + score[1] + score[4];
    }

    if(N>=5)
    {
        for(i=5; i<=N; i++)
        {
            comp1 = dp[i-3] + score[i-1] + score[i]; 
            comp2 = dp[i-4] + score[i-2] + score[i];
            comp3 = dp[i-5] + score[i-3] + score[i-2] + score[i];

            dp[i] = (comp1 > comp2) && (comp1 > comp3) ? comp1 : ((comp2 > comp3) ? comp2 : comp3);
        }
    }
}

int main()
{
    int i;
    scanf("%d",&N);
    for(i=1; i<=N; i++)
    {
        scanf("%d",&score[i]);
    }
    findMaxScore();
    printf("%d\n", dp[N]);
}
