/*
   2021-04-12
   LG codepro - [20or21년도] 엘레베이터
    solution 보고 재풀이
 */
package codepro;

import java.util.Arrays;
import java.util.Scanner;

class Elevator {
    int N;
    int A[]=new int[100+10];
    int B[]=new int[100+10];

    public class LINE implements Comparable<LINE> {
        int a,b;
        LINE(){}
        LINE(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(LINE ln) {
            return this.b-ln.b;
        }

    }
    LINE list[];

    public int solve() {
       Arrays.sort(list);

       int low=list[0].b;
       int cnt=1;
       for(int i=0; i<N; i++) {
           if ( list[i].a > low ) {
               low = list[i].b;
               cnt++;
           }
       }
       return cnt;
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);

        N=sc.nextInt();
        list = new LINE[N];

        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
            list[i] = new LINE(A[i], B[i]);
        }
        sc.close();
    }

    public static void main(String[] args) {
        Elevator e=new Elevator();
        e.inputData();
        int ans = e.solve();
        System.out.println(ans);
    }
    
}
