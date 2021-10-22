/*
    2021-10-22
    Baekjoon 1300 K번째 수
*/
package baekjoon;
import java.util.*;

public class boj_1300_Kth {
    /*
        Soltion 참조 - 이진 탐색
        https://kbw1101.tistory.com/29
        https://jaimemin.tistory.com/988
    */
    static int N, K;

    static void input() {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        K=sc.nextInt();
        sc.close();
    }


    public static void main(String[] args) {
        input();

        int low =1, high=K;
        int res=0;

        while( low<=high ) {
            int cnt = 0;
            int mid = (low+high)/2;

            for(int i=1; i<=N; i++) {
                cnt += Math.min( mid/i, N );
            }

            if ( cnt<K ) {
                low = mid+1;
            } else {
                res = mid;
                high = mid-1;
            }
        }

        System.out.println(res);

    }
    
}
