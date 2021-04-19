/*
    2021-04-19
    Baekjoon 1654 랜선자르기
    
    solve1) 37076KB, 456ms
*/
package baekjoon;
import java.util.*;

class LanCable {
    static int K;
    static int N;
    static long len[];
    static long maxLen=-1;


    void input1() {
        Scanner sc=new Scanner(System.in);
        K=sc.nextInt();
        N=sc.nextInt();
        len=new long[K+1];
        for(int i=0; i<K; i++) {
            len[i]=sc.nextLong();
            maxLen=Math.max(maxLen, len[i]);  // solve1)
        }
        sc.close();
    }

    void solve1() {
        long left = 1;
        long right=maxLen;
        while(left<=right) {
            long mid=(left+right)/2;
            long sum=0;

            for(int i=0; i<K; i++) {
                sum+=(len[i]/mid);
            }
            if ( sum>=N ) left=mid+1;
            else right=mid-1;
        }
        System.out.println(right);
    }


    public static void main (String args[]) {
        LanCable m=new LanCable();

        // solution1
        m.input1();
        m.solve1();
    }
}
