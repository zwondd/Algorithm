/*
    201228 
    원주율 외우기
    3~5 단위로 나눌 수 있는 원주율의 난이도 합 최소 구하기
*/

#include <iostream>
#include <string>
#include <cstring>
#include <algorithm>
using namespace std;

const int INF = 987654321;
string N;

int TC;
int cache[10010];                                             

int classify (int a, int b) {
    string M = N.substr(a, b-a+1);

    if ( M == string(M.size(), M[0])) return 1;

    bool progressive = true;
    for(int i=0; i<M.size()-1; i++) {
        if ( M[i+1]-M[i] != M[1]-M[0] ) {
            progressive = false;
        }
    }

    if ( progressive && abs(M[1]-M[0]) == 1 ) return 2;

    bool alternating = true;
    for(int i=0; i<M.size(); i++) {
        if ( M[i] != M[i%2] ) {
            alternating = false;
        }
    }

    if ( alternating ) return 4;
    if ( progressive ) return 5;
    return 10;
}

int memorize(int begin) {
    if ( begin == N.size() ) return 0;

    int& ret = cache[begin];
    if (ret!=-1) return ret;

    ret = INF;
    for(int len=3; len<=5; len++) {
        if ( begin+len > N.size() ) {
            break;
        }
        ret = min(ret, memorize(begin+len) + classify(begin, begin+len-1) );
    }
    return ret;
}

int main(void) {

    cin>>TC;
    while(TC--) {
        cin>>N;
        memset(cache,-1,sizeof(cache));
        cout<<memorize(0)<<endl;
    }

    return 0;
}