/*
   - 백준 #6603 : 로또
   - 문자열 처리, 백트래킹
 */
#include <iostream>
using namespace std;

int K;
int S[14][1000];
int visit[14][1000];
int setIdx=0;

void findSet(int setIdx, int num, int cnt) {
     if (cnt==6) {
          for(int i=1; i<=S[setIdx][0]; i++) {
               if (visit[setIdx][i])
                    cout<<S[setIdx][i]<<" ";
          }
          cout<<"\n";
          return;
     }
     if ( S[setIdx][0]-num<6-cnt )
          return;

     for(int i=num; i<=S[setIdx][0]; i++) {
          if ( !visit[setIdx][i] ) {
               visit[setIdx][i]=1;
               findSet(setIdx,i,cnt+1);
               visit[setIdx][i]=0;
          }
     }
}

int main(void) {
     K=-1;
     while(true) {
          cin>>K;
          if ( K==0 )
               break;

          S[setIdx][0]=K;

          for(int i=1; i<=K; i++) {
               cin>>S[setIdx][i];
          }
          setIdx++;
     }

     for(int i=0; i<setIdx; i++) {
          findSet(i,1,0);
          cout<<"\n";
     }
}