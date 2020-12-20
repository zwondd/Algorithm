/*
    201220 
    합친 LIS - 수열 A, B 가 있을 때 합친 증가 부분수열 중 가장 긴 것 구하기
    오타를 잘보자..
*/

// solution 

// #include <algorithm>
// #include <limits>
// #include <iostream>
// #include <cstring>
// using namespace std;

#include<cstring>
#include<iostream>
#include<string>
#include<vector>
#include<limits>
using namespace std;

const long long NEGINF = numeric_limits<long long>::min();
int n, m, A[100], B[100];
int cache[101][101];

// indexA == indexB == -1 or A[indexA]!=B[indexB] 라고 가정
int jlis(int indexA, int indexB) {
    int& ret = cache[indexA+1][indexB+1];
    if ( ret != -1 ) return ret;

    // A[indexA], B[indexB] 가 이미 존재하므로 최소 2개는 항상 있음 
    ret = 2;
    long long a = (indexA == -1 ? NEGINF : A[indexA]);
    long long b = (indexB == -1 ? NEGINF : B[indexB]);
    long long maxElement = max(a,b);

    for(int nextA = indexA + 1; nextA < n; ++nextA)
		if(maxElement < A[nextA])
			ret = max(ret, jlis(nextA, indexB) + 1);
	for(int nextB = indexB + 1; nextB < m; ++nextB)
		if(maxElement < B[nextB])
			ret = max(ret, jlis(indexA, nextB) + 1);
        
    
    return ret;
}


int main(void) {
    int t;

    cin>>t;
    for(int i=0; i<t; i++) {
        // memset(A,0,sizeof(A));
        // memset(B,0,sizeof(B));
        cin>>n>>m;
        for(int nn=0; nn<n; nn++) {
            cin>>A[nn];
        }
        for(int mm=0; mm<m; mm++) {
            cin>>B[mm];
        }
        memset(cache, -1, sizeof(cache));
        cout<<jlis(-1,-1)-2<<endl;
    }
    return 0;
}

