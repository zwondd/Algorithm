#include <iostream>
#include <cstring>

using namespace std;

int tc = 0;
int dp[10010];
const int MOD = 10007;

void initDp() {
    memset(dp, -1, sizeof(dp));
}

int countTile(int n) {
    if (n <= 1) return 1;

    int& ret = dp[n];
    if (ret != -1) return ret;
    return ret = (countTile(n - 1) + countTile(n - 2)) % MOD;
}


int main(void) {
    cin >> tc;
    initDp();
    cout<<countTile(tc);
}