#include <iostream>
#include <cstring>

#define endl "\n"
#define MAX 30 + 1
using namespace std;
 
int N, M;
int dp[MAX][MAX];

void Initialize()
{
    memset(dp, 0, sizeof(dp));
}

void Input() {
    //scanf("%d %d", &n, &m); 
    cin>>N>>M;
}

// Solution int -> void 로 했더니 runtime error 해결됨ㅠㅠ
void Solution() {
    for(int i=1; i<=M; i++) 
    {
        dp[1][i] = i;
    }
        
    for (int i = 2; i <= N; i++)
    {
        for (int j = i; j <= M; j++)
        {
            for (int k = j; k >= i; k--)
            {
                dp[i][j]= dp[i][j] + dp[i-1][k-1];
            }
        }
    }
    //printf("%d\n",d[n][m]);
    cout<<dp[N][M]<<endl;
}


void Solve(){
   int TC;
    cin>>TC;
   //scanf("%d",&T);
   for(int T=1; T<=TC; T++) 
   {
        Initialize();
        Input();       
        Solution();
        
    } 
}

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    Solve();
    
    return 0;
}