/*
   2021-04-17
   LG codepro - [18년도_2차] 산책
   7/10: success (8min)
*/
package codepro;

import java.util.*;

class Stroll {
    int N;
    long T;
	long p[]=new long[100010];
	long s[]=new long[100010];
	
	public void input() {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		T=sc.nextLong();
		for(int i=0; i<N; i++) {
			p[i]=sc.nextLong();
			s[i]=sc.nextLong();
		}
		sc.close();
	}
	
	public long solve() {   // solve) 데이터타입 long으로 바꾼 후 10/10 success
		long prevPos=p[N-1]+T*s[N-1];
		int group=1;
		
		for(int i=N-2; i>=0; i--) {
			if ( prevPos > p[i]+T*s[i] ) {
				prevPos=p[i]+T*s[i];
				group++;
			}
		}
		
		return group;
	}
	
	public static void main(String[] args) throws Exception {
		// Main m=new Main();
        Stroll m = new Stroll();
		m.input();
		long ans=-1;
		ans=m.solve();
		System.out.println(ans);
	}
    
}
