/*
   2021-04-11
   LG codepro - [19년도_4차] 불우이웃돕기
    12/12 : success
    (after seeing solution)

    kind[0]~kind[9] 까지 전체 개수 더한 후 빼야함.
 */
package codepro;

import java.util.Scanner;

class Neighbor2 {
    int N;
    int[] kind={1, 5, 10, 50, 100, 500, 1000, 3000, 6000, 12000};
    int[] box  = new int[10];
    int[] send = new int[10];

    public void Input() {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        for(int i=0; i<10; i++) {
            box[i]=sc.nextInt();
        }
        sc.close();
    }

    public void solve() {
        int i;
        int sumAll=0, remain=0, totalBox=0;
        for(i=0; i<10; i++) {
            // if ( sumAll>N ) break; ///
            sumAll+=(box[i]*kind[i]);
        }
        // System.out.println(" sumAll : " + sumAll);
        remain = sumAll-N;
        // System.out.println(" remain : " + remain);

        for(int j=9; j>=0; j--) {
            int cnt= remain/kind[j];
            // System.out.println(" cnt : " + cnt + " box[j] : " + box[j]);

            if ( cnt>box[j] ) cnt=box[j];

            remain -= kind[j]*cnt;
            send[j] = box[j]-cnt;
            totalBox += send[j];

            // System.out.println("==  remain : " + remain + " send[j] " + send[j]);

        }

        ///
        // for(int j=i-1; j>=0; j--) {
        //     if ( remain<kind[j] ) continue;

        //     send[j]=box[j]-remain/kind[j];
        //     remain%=kind[j];
        //     cnt+=send[j];
        // }
        System.out.println(totalBox);
        for(i=0; i<10; i++) 
            System.out.print(send[i] + " ");
    }

    public static void main(String[] args) throws Exception {
        // Neighbor nb=new Neighbor();
        Neighbor2 nb=new Neighbor2();
        nb.Input();
        nb.solve();
    }
    
}

/*
267
15 6 6 3 2 2 2 2 2 1

5
5 1 0 0 0 0 0 0 0 0
*/
