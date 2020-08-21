/*
   - 백준 #9933 : 민균이의 비밀번호
   - 문자열 처리, 백트래킹
 */

#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int N;
// char word[101][15];
string word[101];

int main(void) {
     int len;
     char midChar;

     cin>>N;
     for(int i=0; i<N; i++)
          cin>>word[i];

     for(int i=0; i<N; i++) {
          for(int j=i; j<N; j++) {
               bool flag = true;
               if ( word[i].length() != word[j].length() ) {
                    flag=false;
                    continue;
               }
               for(int k=0; k<word[i].length(); k++) {
                    if ( word[i][k] != word[j][word[j].length()-k-1] ) {
                         flag = false;
                         break;
                    }
               }
               if ( flag == true ) {
                    len = word[i].length();
                    midChar = word[i][len/2];
                    cout<<len<<" "<<midChar<<"\n";
                    return 0;
               }
          }
     }
     return 0;
}
