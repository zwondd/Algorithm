#include <cstdio>
#define MAX_SIZE 10000
#define INF 0x7fffffff
#define ll long long
int data[MAX_SIZE];
int k, n;
int ret;
 
int binary_search(int key, ll left, ll right)
{
    if(left > right) return -1;
 
    ll mid = (left + right) / 2;
 
    int cnt = 0;
    for(int i = 0; i < k; i++) cnt += data[i] / mid;
 
 
    if(cnt >= key)
    {
        ret = mid > ret ? mid : ret;
        return binary_search(key, mid + 1, right);
    }
    else if(cnt < key) return binary_search(key, left, mid - 1);
 
}
 
int main()
{
 
    scanf("%d %d", &k, &n);
 
    for(int i = 0; i < k; i++) scanf("%d", data + i);
 
    binary_search(n, 1, INF);
 
    printf("%d", ret);
 
    return 0;
}