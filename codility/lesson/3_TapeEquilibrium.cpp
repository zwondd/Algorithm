// 21-02-16

#include <vector>
using namespace std;

// My Solution 1  23min (69%) O(N * N)
// timeout error 
int solution(vector<int> &A) {
    long sum1=0;
    long sum2=0;
    long minDiff=-1;

    for(unsigned int i=1; i<A.size(); i++) {
        unsigned int j=0;
        while(j<i) sum1+=A[j++];
        while(j<A.size()) sum2+=A[j++];

        if (minDiff==-1) {
            minDiff = abs(sum1-sum2);
        } else {
            minDiff = ( minDiff > abs(sum1-sum2) ) ? abs(sum1-sum2) : minDiff;
        }

        sum1=0; sum2=0;
    }
    return minDiff;
}

// My Solution 2  15min (46%) 
// wrong answer
// you can use includes, for example:
#include <algorithm>

int solution(vector<int> &A) {

    long P[100002];
    long sum; 
    unsigned int i;

    P[1]=A[0];
    for(i=1; i<A.size(); i++) P[1]-=A[i];
    P[1]=abs(P[1]);
    sum=P[1];

    for(int i=2; i<A.size(); i++) {
        P[i]=abs(P[i-1]-A[i-1]*2);
        sum=(P[i]<sum)?P[i]:sum;
    }
    return sum;
}

#include<limits>
// Other Solution 1 (100%) O(N)
int solution(vector<int> &A) {
    long leftSum=A[0];
    long rightSum=0;
    unsigned int i;
    for( i=1; i<A.size(); i++)
        rightSum+=A[i];

    long minDiff=abs(leftSum-rightSum);
    long diff;

    for (i=1; i<A.size(); i++) {
        diff = abs(leftSum-rightSum);
        minDiff = (diff<minDiff) ? diff:minDiff;
        leftSum+=A[i];
        rightSum-=A[i];
    }

    return minDiff;
}