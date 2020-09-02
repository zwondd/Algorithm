/*
   - 백준 #11657 : 타임머신
   - 그래프 최단거리탐색 ( 벨만포드 ) : 음의 가중치 있을 때의 최단경로
   - 재풀이
 */

#include <iostream>
#include <vector>
#include <algorithm>

#define endl "\n"
#define MAX_N 500+10
#define INF 987654321
using namespace std;

int N, M;
vector<pair<int,int>> adj [MAX_N];
long long upper[MAX_N];

void input() {
  // scanf("%d %d \n", &N, &M);
  cin>>N>>M;
  for(int i=0; i<M; i++) {
    int s, e, t;
    // scanf("%d %d %d", &s, &e, &t);
    cin>>s>>e>>t;
    adj[s].push_back(make_pair(e,t));
  }
}

void bellman (int src) {
  upper[src] = 0;
  bool updated;
  for(int i=1; i<=N-1; i++) {
    updated = false;
    for(int here=1; here<=N; here++) {
        for(int j=0; j<adj[here].size(); j++) {
          int there = adj[here][j].first;
          int cost = adj[here][j].second;

          if ( upper[here] == INF ) continue;
          if ( upper[there] > upper[here] + cost ) {
            upper[there] = upper[here] + cost;
            updated = true;
          }
        }
    }

    // printf("Round [%d] ", i);
    // for(int k=1; k<=N; k++) {
    //   printf("%d ", upper[k]);
    // }
    // printf("\n");

    // if ( updated ) {
    //   printf("%d", -1); return;
    // }
  }

  // V 번째 탐색
  for(int here=1; here<=N; here++) {
      for(int j=0; j<adj[here].size(); j++) {
        int there = adj[here][j].first;
        int cost = adj[here][j].second;

        if ( upper[here] == INF ) continue;
        if ( upper[there] > upper[here] + cost ) {
          // printf("-1"); return;
          cout<<-1<<endl;
          return;
        }
      }
  }

  // updated = false;
  // for(int here=1; here<=N; here++) {
  //     for(int j=0; j<adj[here].size(); j++) {
  //       int there = adj[here][j].first;
  //       int cost = adj[here][j].second;
  //       if ( upper[there] > upper[here] + cost ) {
  //         upper[there] = upper[here] + cost;
  //         updated = true; break;
  //       }
  //     }
  // }

  // if (updated == true) {
  //   printf("%d", -1); return;
  // }
  for(int i=2; i<=N; i++) {
    if ( upper[i] == INF ) {
      // printf("%d", -1);
      cout<<-1<<endl;
    } else {
      // printf("%d\n", upper[i]);
      cout<<upper[i]<<endl;
    }
  }
}

int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);

  input();
  fill( upper+1, upper+N+1, INF);

  // printf("Round [%d] ", 0);
  // for(int k=1; k<=N; k++) {
  //   printf("%d ", upper[k]);
  // }
  // printf("\n");


  bellman(1);
  // printf("\n");
  // for(int i=1; i<=N; i++) {
  //   printf("size : %d \n", adj[i].size());
  //   for(int j=0; j<adj[i].size(); j++) {
  //     printf("%d %d %d", i, adj[i][j].first, adj[i][j].second );
  //   }
  //   printf("\n");
  // }

  return 0;
}