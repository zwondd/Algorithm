/*
    2021-03-31
    LG codepro - 심리학 실험
	30min
	Resolution1) prev 저장안했을 때 : 4/10 pass (6개 Timeout) - O(N^2)
    Resolution2) prev 저장했을 때 : 5/10 pass (5개 Timeout)
 */
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;


class Main {
    Scanner sc;
    int N;
    int[] comp;
    int[][] dp;

    class Companion {
        int first;
        int second;
        int min;
    };

    public void solve() {
        Companion res = new Companion();
        res.min = 987654321;

        int right=N-1;
        for(int i=0; i<N; i++) {
            int cur=0, prev=987654321;
            while( i<right ) {
                
                cur = Math.abs(comp[i]+comp[right]);
                if ( cur>prev ) break;

                if ( cur<res.min ) {
                    res.min = cur;
                    res.first = i;
                    res.second = right;
                }
                prev=cur;
                right--;
            }
            right=N-1;
        }
        System.out.println(res.first + " " + res.second);
    }
	public static void main(String[] args) throws Exception {
        Main m= new Main();
        m.sc = new Scanner(System.in);
        m.N = m.sc.nextInt();

        m.comp = new int[m.N];
        for(int i=0; i<m.N; i++) {
            m.comp[i] = m.sc.nextInt();
        }
        m.solve();
	}
}