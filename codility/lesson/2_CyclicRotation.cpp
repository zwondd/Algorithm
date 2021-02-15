#include <vector>
using namespace std;

// 21-02-15
// My Solution (87%)
// empty arry error
vector<int> solution(vector<int> &A, int K) {
    if ( A.size() <=0 ) return A; // (100%)
    if ( K%A.size()==0 ) return A;

    for(unsigned int i=0; i<K%A.size(); i++) {
        int num=A.back();
        A.pop_back();
        A.insert(A.begin(),num);
    }
    return A;
}