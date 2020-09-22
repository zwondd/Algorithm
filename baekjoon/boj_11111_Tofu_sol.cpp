#include<cstdio>
#include<queue>
#include<vector>
using namespace std;
const int MAX_N = 50, g[][5] = { { 10,8,7,5,1 },{ 8,6,4,3,1 },{ 7,4,3,2,1 },{ 5,3,2,2,1 },{ 1,1,1,1,0 } }, fx[] = { 0,0,1,-1 }, fy[] = { 1,-1,0,0 };
int n, m, from[MAX_N*MAX_N + 2], cst[MAX_N*MAX_N + 2], ck[MAX_N*MAX_N + 2], res;
char str[MAX_N][MAX_N + 1];
struct st {
    int x, w, c;
};
vector<st> adj[MAX_N*MAX_N + 2];
int main() {
    scanf("%d %d", &n, &m);
    for (int i = 0; i < n; i++) {
        scanf("%s", str[i]);
        for (int j = 0; j < m; j++) if (str[i][j] == 'F') str[i][j]--;
    }
    for (int i = 0; i <n; i++) {
        for (int j = 0; j < m; j++) {
            if ((i + j) % 2) {
                adj[i*m + j + 1].push_back({ n*m + 1,0,1 });
                continue;
            }
            adj[0].push_back({ i*m + j + 1,0,1 });
            for (int k = 0; k < 4; k++) {
                int tx = i + fx[k], ty = j + fy[k];
                if (tx >= 0 && tx < n && ty >= 0 && ty < m)
                    adj[i*m + j + 1].push_back({ tx*m + ty + 1,g[str[i][j] - 'A'][str[tx][ty] - 'A'],1 }),
                    adj[tx*m + ty + 1].push_back({ i*m + j + 1, -g[str[i][j] - 'A'][str[tx][ty] - 'A'],0 });
            }
        }
    }
    for (;;) {
        fill(cst, cst + n*m + 2, -1e9);
        queue<int> q;
        q.push(0); cst[0] = 0;
        while (!q.empty()) {
            int h = q.front();
            q.pop(); ck[h] = 0;
            for (auto it : adj[h]) {
                if (it.c && cst[h] + it.w>cst[it.x]) {
                    cst[it.x] = cst[h] + it.w;
                    from[it.x] = h;
                    if (!ck[it.x]) ck[it.x] = 1, q.push(it.x);
                }
            }
        }
        if (cst[n*m + 1] < 0) break;
        res += cst[n*m + 1];
        for (int i = n*m + 1; i; i = from[i]) {
            for (auto &it : adj[from[i]]) if (it.x == i) it.c--;
            for (auto &it : adj[i]) if (it.x == from[i]) it.c++;
        }
    }
    printf("%d", res);
    return 0;
}