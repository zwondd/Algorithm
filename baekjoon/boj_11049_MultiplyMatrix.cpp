/*
    210210
   - 백준 #11049 : 행렬곱셈 순서 
   N개 행렬 주어졌을 때, 모든 행렬 곱하는데 필요한 곱셈 연산 횟수 최솟값
 */

#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int N;
int matrix[510][2];
int dp[510][510];

int getMin(int s, int e) {
    if ( s==e ) return 0;

    int& ret = dp[s][e];
    if ( ret != -1 ) return ret;

    int tmp=-1;
    for(int i=s; i<e; i++) {
        if ( tmp==-1 )  {
            tmp = getMin(s,i)+getMin(i+1,e)+(matrix[s][0]*matrix[i+1][0]*matrix[e][1]);
        } 
        tmp = min( tmp, getMin(s,i)+getMin(i+1,e)+(matrix[s][0]*matrix[i+1][0]*matrix[e][1]) );
    }
    return ret=tmp;
}

int main(void) {
    cin>>N;
    for(int i=1; i<=N; i++) {
        cin>>matrix[i][0];
        cin>>matrix[i][1];
    }
    memset(dp, -1, sizeof(dp));
    cout<<getMin(1,N)<<endl;

    return 0;
}