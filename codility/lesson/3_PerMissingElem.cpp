// 21-02-16

// My Solution 1 13min (50%)
// wrong answer & runtime error

#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> &A) {
    sort(A.begin(), A.end());
    unsigned int i;
    for(i=0; i<A.size()-1; i++)
        if ( A[i]+1 != A[i+1] ) break;
    return A[i]+1;    
}

// My Solution 2 10min (10%)
// wrong answer & timout error
int solution(vector<int> &A) {
    sort(A.begin(), A.end());

    int s=0, e=A.size()-1;
    int mid=(s+e)/2;

    while(s!=e) {
        if ( A[mid] == mid+1 ) s=mid+1;
        else e=mid-1;

        mid=(s+e)/2;
    }
    return A[mid]-1;
}

// Other Solution 1  (80%)
// WRONG ANSWER (got -2147483647 expected 1)
int solution(vector<int> &A) {
    int n=A.size()+1;
    int total=(n*(n+1))/2;
    int sum=0; 

    for(unsigned int i=0; i<A.size(); i++)
        sum+=A[i];
    
    return (total-sum);
}

//  (100%)
int solution(vector<int> &A) {
    long long n=A.size()+1;
    long long total=(n*(n+1))/2;
    long long sum=0; 

    for(unsigned int i=0; i<A.size(); i++)
        sum+=A[i];
    
    return (int)(total-sum);
}