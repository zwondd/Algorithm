#include <iostream>
#include <vector>
#include<cstring>

using namespace std;

#if 0
int tc;
int nStudent;
int mPair;
int maxPair=0;

void countPair(int n, int* visited, const vector<pair<int,int>>& pairs, int k) {
    if ( n>=nStudent ) {
        maxPair+=1;
        return;
    } 
    for(int i=k; i<mPair; i++) {
        int ns1 = pairs[i].first;
        int ns2 = pairs[i].second;

        if ( *(visited+ns1)==1 || *(visited+ns2)==1 ) continue;

        *(visited + ns1) = 1;
        *(visited + ns2) = 1;

        countPair(n+2, visited, pairs, i+1);

        *(visited + ns1) = 0;
        *(visited + ns2) = 0;
    }
} 

void getPair() {
    vector<pair<int,int>> pairs;
    int visited[50]={0,};
    int count=0;

    cin>>nStudent>>mPair;

    for(int i=1; i<=mPair; i++) {
        int a,b;
        cin>>a>>b;
        pairs.push_back(make_pair(a,b));
    }
    countPair(0, visited, pairs, 0); 
    cout<<maxPair<<endl;
};


int main(void) {
    cin>>tc;

    for(int i=0; i<tc; i++) {
        maxPair=0;
        getPair();
    }
}
#endif


#if 1
// solution 
// initialize array memeory!!! memset//

int n;
bool areFriends[10][10];

int countPairings(bool taken[10]) {
    int firstFree = -1;

    for(int i=0; i<n; i++) {
        if( !taken[i] ) {
            firstFree = i;
            break;
        }
    }

    if ( firstFree == -1 ) return 1;
    int ret = 0;

    for(int pairWith=firstFree+1; pairWith<n; pairWith++) {
        if ( !taken[pairWith] && areFriends[firstFree][pairWith] ) {
            taken[firstFree] = taken[pairWith] = true;
            ret += countPairings(taken);
            taken[firstFree] = taken[pairWith] = false;
        }
    }
    return ret;
}

int main(void) {
    int tc;
    int nStudent, mPair;

    cin>>tc;
    for(int i=0; i<tc; i++) {
        cin>> nStudent>> mPair;
        n=nStudent;
        memset(areFriends, 0, sizeof(areFriends));
        for(int j=0; j<mPair; j++) {
            int x, y;
            cin>>x>>y;
            areFriends[x][y] = areFriends[y][x] = true;
        }
        bool taken[10];
        memset(taken, 0, sizeof(taken));
        cout<<countPairings(taken)<<endl;
    }
}


#endif