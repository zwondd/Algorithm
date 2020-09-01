/*
   200901
   백준 #1238 : 파티 (다익스트라)
 
    - 우선순위 큐를 사용한 다익스트라 구현
 */

#include <iostream>
#include <queue>
#include <vector>

#include<algorithm>

#define INF 987654321

using namespace std;

int N, M, X;
vector<pair<int,int>> adj[1000+10]; // adjacent list (vertex, cost)

void input() {
    cin>>N>>M>>X;
    for(int i=0; i<M; i++) {
        int s,e,t;
        cin>>s>>e>>t;
        adj[s].push_back({e,t});
    }
}
vector<int> dijkstra(int src) {
    // cout<<"src : "<<src<<endl;
    vector <int> dist(N+1, INF);
    dist[src] = 0;
    priority_queue<pair<int,int>> pq; // pair ( next distance, next vertex )
    pq.push(make_pair(0,src));

    while( !pq.empty() ) {
        // cout<<" === while === "<<endl;
        int cost = -pq.top().first; 
        int here = pq.top().second;
        pq.pop();
        // cout<<"cost : "<<cost<<" here : "<<here<<endl;

        if ( dist[here] < cost ) continue;

        for( int i=0; i<adj[here].size(); i++ ) {
            int there = adj[here][i].first;
            int nextDist = cost + adj[here][i].second; 
            // cout<<"there : "<<there<< " dist[there] "<<dist[there]<<" nextDist : "<<nextDist<<endl;

            if ( dist[there] > nextDist ) {
                dist[there] = nextDist;
                pq.push(make_pair(-nextDist, there));
            }
        }
        // cout<<"pq size : "<<pq.size()<<endl;
    }
    return dist;
}
int solve() {
   int sum[1000+10] = {0,};

// 풀이 1.
//    for(int i=1; i<=N; i++) {
//        vector<int> res = dijkstra(i);
//        if ( i==X ) {
//            for(int j=1; j<=N; j++) {
//                sum[j]+=res[j];
//            }
//        } else {
//             sum[i] += res[X];
//        }
//    }

// 풀이 2. (시간단축)
   for(int i=1; i<=N; i++) {
       vector<int> res = dijkstra(i);
       sum[i] = res[X];
   }
   vector<int> res = dijkstra(X);
   for(int j=1; j<=N; j++) sum[j]+=res[j];


// 풀이 1.
   int maxTime = 0 ;
   for(int i=1; i<=N; i++) {
       maxTime = (maxTime<sum[i]) ? sum[i] : maxTime;
   }
   return maxTime;
   
// 풀이 2. (sort 알고리즘으로 시간단축 x)
    // sort(sum+1, sum+N+1);
    // return sum[N];
}

int main() {
    input();
    int ans = solve();
    cout<< ans <<endl;

    return 0;
}