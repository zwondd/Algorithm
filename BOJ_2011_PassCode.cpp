// 191015
// 백준 #2011 : 암호코드 
// DP

#include <iostream>
using namespace std;

int passwd[5001];
int dp[5001];

int main(void) {
    int cnt=0, i=0, j=3;
    char temp_pass[5001];

    cin>>temp_pass;
    while(temp_pass[cnt] != '\0') {
        passwd[cnt] = temp_pass[cnt]-'0';
        cnt++;
    }
    printf("cnt: %d\n",cnt);

    dp[1] = 1;
    dp[2] = 2;

    for(i=0; i<cnt; i++) {
        if( passwd[j-1]*10 + passwd[j] >=10 && passwd[j-1]*10 + passwd[j]<=26 ) {
            dp[j] = dp[j-1] + dp[j-2];
        } else {
            dp[j] = dp[j-1];
        }
        printf("\n dp[%d] : %d \n",j,dp[j]);
        dp[j] = dp[j]%1000000;
        j++;
    }

    cout<<dp[cnt];
}