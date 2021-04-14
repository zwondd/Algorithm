/*
   2021-04-14
   LG codepro - [18년도_4차] 마리오게임
   5/10 : success (35min)
 */
package codepro;

import java.util.Scanner;

class Mario {

    int N;
	int h[]=new int[200000];
	
	public int solve() {
		int isOdd=1,sum=0;
		int prev=h[0];
		sum+=prev;
		
		for(int i=1; i<N; i++) {
			if ( isOdd==1 ) {
				if ( prev < h[i] ) {
					sum=sum-prev+h[i];
					prev=h[i];
				} else {
					sum-=h[i];
					prev=h[i];
					isOdd*=(-1);
				}
			} else {
				if ( prev > h[i] ) {
					sum=sum+prev-h[i];
					prev=h[i];
				} else {
					sum+=h[i];
					prev=h[i];
					isOdd*=(-1);
				}
				
			}
		}
        if ( isOdd!=1 ) sum+=prev;  // solve) 추가 했더니 10/10 pass
		return sum;
		
	};


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // Main m=new Main();
        Mario m=new Mario();
        m.N = sc.nextInt();
        for(int i=0; i<m.N; i++) {
            m.h[i] = sc.nextInt();
        }
        sc.close();
        int ans = m.solve();
        System.out.println(ans);
    }
    
}
