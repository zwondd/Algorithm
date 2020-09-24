/*
    200923
    Leetcode Easy 
    7 Reverse Integer
*/
#include <cmath>

class Solution {
public:
    int reverse(int x) {
        int rev = 0;
        while( x!= 0 ) {
            int pop = x%10;
            x /= 10;

            // 계산 다 하면 overflow 됨.
            // if ( rev*10 + pop > pow(2,31) - 1 ) return 0;
            // if ( rev*10 + pop < (-1)*pow(2,31) ) return 0;
            
            // 4바이트 정수의 범위는 -2,147,483,648 ~ 2,147,483,647
            if ( (rev>INT_MAX/10) || (rev==INT_MAX/10 && pop>7 ) ) return 0;
            if ( (rev<INT_MIN/10) || (rev==INT_MIN/10 && pop<-8) ) return 0;
            rev = rev*10 + pop;
        }
        return rev;
        
    }
};