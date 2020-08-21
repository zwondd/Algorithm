/*
   - 백준 #6603 : 로또 - 풀이2
   - 문자열 처리, 백트래킹
 */
#include <iostream>
using namespace std;

int K;
int S[14];
int lottoSet[6];

void dfs(int start, int depth) {
     if ( depth==6 ) {
          for(int i=0; i<6; i++)
               cout<<lottoSet[i]<<" ";
          cout<<"\n";
          return;
     }

     for(int i=start; i<K; i++) {
          lottoSet[depth]=S[i];
          dfs(i+1, depth+1);
     }
}

int main(void) {
     while(cin>>K && K) {
          for(int i=0; i<K; i++) {
               cin>>S[i];
          }

          dfs(0,0);
          cout<<"\n";
     }
     return 0;
}