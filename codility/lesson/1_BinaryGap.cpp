// 21-02-15
// My Solution (100%)
int solution(int N) {
    bool started=false;
    int maxSeq=0, temp=0;
    int converted=1;
    
    while(1) { 
        if ( N%2==1 ) {
            if ( started==false ) {
                started=true;
            } else {
                maxSeq=(maxSeq<temp) ? temp:maxSeq;
                temp=0;
            }
        } 
        if ( N%2==0 ){
            if ( started==true ) {
                temp++;
            }
        }
        converted=converted*10+N%2;
        N/=2;

        if (N==0) break;
    }
    return maxSeq;
}

// Other Solution 1
int solution2 (int N) {
    int maxBinaryGap=0;
    int countBinaryGap=0;
    bool isCounting=false;
    
    while(true) { 
        if ( (N&1)==1 ) {
            if ( !isCounting ) {
                isCounting=true;
            } else {
                if ( countBinaryGap>maxBinaryGap ) maxBinaryGap=countBinaryGap;
            }
            countBinaryGap=0;
        } else {
            countBinaryGap++;
        }
        N=N>>1;
        if(N==0) break;
    }
    return maxBinaryGap;
}