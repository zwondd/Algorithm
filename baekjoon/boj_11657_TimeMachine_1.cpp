/*
   - 백준 #11657 : 타임머신
   - 그래프 최단거리탐색 ( 벨만포드 ) : 음의 가중치 있을 때의 최단경로
   - 소스출처 : https://yabmoons.tistory.com/380
 */

#include <iostream>
#include <vector>

#define endl "\n"
#define MAX 510
#define INF 987654321
using namespace std;

int N, M;
long long dist[MAX];
vector<pair<pair<int,int>,int>> edge;

void Input() {
    cin>>N>>M;
    for(int i=1; i<=N; i++) dist[i] = INF;
    for(int i=0; i<M; i++) {
        int from, to, cost;
        cin>>from>>to>>cost;
        edge.push_back(make_pair(make_pair(from,to), cost));
    }
}

void Solution() {
    dist[1] = 0;
    for(int i=1; i<=N-1; i++) {
        for(int j=0; j< edge.size(); j++) {
            int from = edge[j].first.first;
            int to = edge[j].first.second;
            int cost = edge[j].second;

            if ( dist[from] == INF ) continue;
            if ( dist[to] > dist[from] + cost ) {
                dist[to] = dist[from] + cost;
            }
        }
    }

    for(int i=0; i<edge.size(); i++) {
        int from = edge[i].first.first;
        int to = edge[i].first.second;
        int cost = edge[i].second;

        if ( dist[from] == INF ) continue;
        if ( dist[to] > dist[from] + cost ) {
            cout<< -1 <<endl;
            return;
        }
    }

    for(int i=2; i<=N; i++) {
        if ( dist[i] == INF ) {
            cout<<-1<<endl;
        } else {
            cout<<dist[i]<<endl;
        }
    }
}

void Solve()
{
    Input();
    Solution();
}
 
int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
 
    //freopen("Input.txt", "r", stdin);
    Solve();
 
    return 0;
}

