// 21-02-17
// 4_CountingElements_FrongRiverOne

#include <vector>
#include <algorithm>
#include <cstring>
#include <limits>
using namespace std;

// My Solution 1  33min (81%) O(N)
// wrong answer 2/12
int solution(int X, vector<int> &A) {
    int visited[100002]={0,};
    memset(visited,-1,sizeof(visited));

    int i=0;
    int minTime=987654321;
    for(i=0; i<A.size(); i++) {
        if ( visited[A[i]]==-1 ) {
            minTime=max(i,minTime);
            visited[A[i]]=i;
        } else {
            if ( minTime>i ) {
                minTime=i;
                visited[A[i]]=i;
            } 
        }
    }
    for(int i=1; i<=X; i++) {
        if ( visited[i]==-1 ) {
            minTime=-1;
            break;
        }
    }
    return minTime;
}

// My Solution 2  4min (100%) O(N)
int solution(int X, vector<int> &A) {
    const int INF=numeric_limits<int>::max();;
    int visited[100002]={0,};
    memset(visited,-1,sizeof(visited));

    int i=0;
    int minTime=INF;

    for(i=0; i<A.size(); i++) {
        if ( visited[A[i]]==-1 ) {
            if ( minTime==INF ) minTime=i;
            else minTime=max(i,minTime);
            visited[A[i]]=i;
        } else {
            if ( minTime>i ) {
                minTime=i;
                visited[A[i]]=i;
            } 
        }
    }
    for(int i=1; i<=X; i++) {
        if ( visited[i]==-1 ) {
            minTime=-1;
            break;
        }
    }
    return minTime;
}

// Other Solution 1 (100%) O(N)
int solution(int X, vector<int> &A) {
    int retVal=-1;
    int tmpArr[100002]={0,};
    int cnt=0;

    for(int i=0; i<A.size(); i++) {
        if ( tmpArr[i]==0 ) {
            tmpArr[A[i]]=A[i];
            cnt++;
        }
        if ( cnt==X ) {
            retVal=i;
            break;
        }
    }
    return retVal;
}
