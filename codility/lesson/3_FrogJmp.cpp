// 21-02-16

// My Solution 1 (11%)
// wrong answer
int solution(int X, int Y, int D) {
    // write your code in C++14 (g++ 6.2.0)
    int ans=0, sum=X;
    while(sum<Y) {
        sum+=D*ans;
        ans++;
    }
    return ans;
}

// My Solution 2 (55%) O(Y-X)
// Timeout Error  
int solution(int X, int Y, int D) {
    // write your code in C++14 (g++ 6.2.0)

    int cnt=0, sum=X;

    while(sum<Y) {
        cnt++;
        sum+=D;
    }

    return cnt;
}

// My Solution 3 (100%) O(1)
int solution(int X, int Y, int D) {
    // write your code in C++14 (g++ 6.2.0)

    if ( Y-X == 0 ) return 0;

    if ( (Y-X)%D == 0 ) return (Y-X)/D;
    else return (Y-X)/D+1;
}

// Other Solution 1 (100%) O(1)
int solution(int X, int Y, int D) {
    // write your code in C++14 (g++ 6.2.0)
    int time=(Y-X)/D;
    time+=((Y-X)%D >0 )? 1:0;
    return time;
}