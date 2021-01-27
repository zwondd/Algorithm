#include <iostream>
#include <cstring>

using namespace std;

int tc=0;
int dp [260];
const int mod=10007;

void initDp() {
    memset(dp, -1, sizeof(dp));
}

int countTile (int n) {
    int & ret = dp[n];
    if (n<=1) return 1;

    if (ret != -1) return ret;
    return (countTile(n-1) + countTile(n-2)) % mod;
}


int main(void) {
    cin >> tc;
    initDp();
    countTile(tc);
    cout<<dp[tc];
}