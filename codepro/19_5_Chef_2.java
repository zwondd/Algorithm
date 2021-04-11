/*
   2021-04-11
   LG codepro - [19년도_5차] Chef
    12/12 : success
    (after seeing solution)
 */
package codepro;

import java.util.Scanner;

class Chef2 {
    int N;
    int P[] = new int[10000+10];
    int T[] = new int[10000+10];
    int reserved[] = new int[10000+10];
    int sum=0;

    public int solve() {
        int temp=0, price=0;
        int maxT = 0;
        for(int i=1; i<=N; i++) {
            maxT = Integer.max(maxT, T[i]);
        }
        for(int i=1; i<=N; i++) {
            price=P[i];
            // System.out.println("i : " + i + " price: " + price);

            for(int j=T[i]; j>=1; j--) {
                // System.out.println("== j : " + j + "  reserved[j] : " +  reserved[j]);

                if ( reserved[j]==0 ) {
                    reserved[j]=price;
                    break;
                } else if ( reserved[j]<price ) {
                    temp=reserved[j];
                    reserved[j]=price;
                    price=temp;
                }
                // System.out.println("== j : " + j + "  reserved[j] : " +  reserved[j]);
            }

        }

        for(int i=1; i<=maxT; i++) {
            // System.out.println(" /// " + reserved[i] );
            sum+=reserved[i];
        }
        return sum;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int ans=-1;

        Chef2 m=new Chef2();
        m.N = sc.nextInt();
        for(int i=1; i<=m.N; i++) {
            m.P[i]=sc.nextInt();
            m.T[i]=sc.nextInt();
        }
        ans = m.solve();
        System.out.println(ans);
    }
    
}
