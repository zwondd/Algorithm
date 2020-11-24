#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> h;

int solve(int left, int right) {
    if ( left==right ) return h[left];

    int m=(left+right)/2;
    int ret = max(solve(left, m), solve(m+1,right));
    int lo=m, hi=m+1;
    int height=min(h[lo], h[hi]);

    ret=max(ret, height*2);

    while( left<lo || hi<right ) {
        if ( hi<right && ( lo==left || h[hi+1]>h[lo-1] ) ) {
            ++hi;
            height=min(height, h[hi]);
        } else {
            --lo;
            height=min(height,h[lo]);
        }
        ret=max(ret,height*(hi-lo+1));
    }
    return ret;
}

int main(void) {
    int tc;
    cin>>tc;
    while(tc--) {
        int fence=0;
        cin>>fence;
        h.clear();
        for(int i=0; i<fence; i++) {
            int a;
            cin>>a;
            h.push_back(a);
        }
        cout<<solve(0, fence-1)<<endl;
    }

    return 0;
}