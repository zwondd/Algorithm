/*
    2023-01-15
    [Leetcode][Easy] 326. Power of Three
*/

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    bool isPowerOfThree(int n) {
        if ( n<=0 ) return false;
        while( n%3 == 0 )
        {
            n /= 3;
        }
        return n==1;
    }

    // recursive
     bool isPowerOfThree2(int n) {
        return n == 1 || n>0 && n%3==0 && isPowerOfThree2(n/3);
    }
};
