#include <iostream>
#include <cstring>
using namespace std;

#define MOD 10007
int arr[1010];

int solve(int n) {
	if (n == 2) return 3;
	if (n == 1) return 1;
	if (n < 1) return 0;

	int& ret = arr[n];

	if (ret != -1) return ret;

	return ret = (solve(n-2)*2 + solve(n-1)) % MOD;
}

int main(void) {
	int tc;
	memset(arr, -1, sizeof(arr));
	cin >> tc;
	cout << solve(tc) << endl;
}