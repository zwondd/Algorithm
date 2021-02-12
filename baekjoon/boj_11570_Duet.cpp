/*
    210212
   - 백준 #11570 : 환상의 듀엣
   두 명이 악보의 음을 두 집합으로 나누어 노래하는데 드는 힘의 최솟값.
   ex) {1, 3, 8, 12 ,13 } -> P1:{1, 3} , P2:{8,12,13} 부르게 되면 드는 힘이 최소가 됨.
   (노래부르는데 드는 힘 = 노래하는 음의 차이 값의 합 |8-12| + |12-13| )
*/

#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

/*
    Solution 1 ) 
    dp[i][j] 의 i,j는 두 사람이 바로 직전에 불렀던 음에 대한 정보 
    dp[next][j] = min( dp[next][j], dp[i][j] + abs(note[next]-note[i]) )
    dp[i][next] = min ( dp[i][next], dp[i][j] + abs(note[next]-note[j] )

    https://huiung.tistory.com/119

    결과 ) 메모리 : 17964KB / 시간 : 44ms
*/
#if 0

#define MAX 2020
#define INF 987654321

int note[MAX];
int dp[MAX][MAX];

int main(void) {
    int N;
    cin>>N; 
    for(int i=1; i<=N; i++) {
        cin>>note[i];
    }

    for(int i=0; i<=N; i++) {
        for(int j=0; j<=N; j++) {
            dp[i][j] = INF;
        }
    }

    dp[1][0] = 0;
    dp[0][1] = 0;

    for(int i=0; i<=N; i++) {
        for(int j=0; j<=N; j++) {
            if ( i==j ) continue;
            int next = max(i,j)+1;
            
            if ( i==0 || j==0 ) note[0]=note[next];
            dp[next][j] = min(dp[next][j] , dp[i][j]+ abs(note[next]-note[i]));
            dp[i][next] = min(dp[i][next] , dp[i][j]+ abs(note[next]-note[j]));
        }
    }

    int ans = INF;
    for(int i=0; i<=N-1; i++) {
        ans = min(ans, dp[N][i]);
        ans = min(ans, dp[i][N]);
    }
    cout<<ans<<endl;

    return 0;
}
#endif

/*
    Solution 2 ) 재귀함수
    한 명은 무조건 pos-1번째 음을 냈음. 따라서 바로 직전에 내지 않은 사람의 음만 가지고 있으면 된다.
    solve(pos, last) : pos번째 음부터 내야하며, 직전음을 내지 않은 사람의 마지막 음이 last일때 최소함

    https://sgc109.tistory.com/172

    결과 ) 메모리 : 17680 KB / 시간 : 76 ms 
*/
#if 0

int N;
int note[2002];
int dp[2002][2002];
const int MAX = 987654321;

int solve(int i, int j) {
    if ( i==N ) return 0;
    int& cache = dp[i][j+1];
    if ( cache!=MAX ) return cache;
    
    cache=min( cache, solve(i+1, j) + (!i ? 0: abs(note[i]-note[i-1]) ) );
    cache=min( cache, solve(i+1, i-1) + (j<0 ? 0: abs(note[i]-note[j]) ) );
    return cache;
}

int main(void) {
    cin >> N;
    for(int i=0; i<=N; i++) {
        for(int j=0; j<=N; j++) {
            dp[i][j] = MAX;
        }
    }
    for(int i = 0 ; i < N; i++) cin >> note[i];
    cout << solve(0,-1);
    return 0;
}
#endif

/*
    Solution 3 ) 재귀함수 (solution 2 변형)

    결과 ) 
*/
#if 0

#endif


// wrong solution
// int solve(int idx, int person) {
//     if ( idx==0 ) return 0;
    
//     int& ret = dp[idx][person];
//     if ( ret!= -1 ) return ret;

//     int findMin=-1;
//     int ans1= solve( idx-1,abs(person-1) );
//     int ans2= solve(idx-1, person) + abs(note[idx]-note[idx-1]);
//     if ( ans1==0 || ans2==0 ) {
//         findMin= (ans1==0) ? ans2:ans1;
//     } else {
//         findMin=min(ans1,ans2- note[idx-1]);
//     }
//     return dp[idx][person] = findMin;
    
// }

// int main(void) {
//     cin>>N;
//     memset( dp, -1, sizeof(dp) );
//     for(int i=0; i<N; i++) {
//         cin>>note[i];
//     }
//     solve(N, 0);
//     solve(N, 1);
//     cout<<min(dp[N][0], dp[N][1])<<endl;
//     // cout<<dp[N]<<endl;
// }