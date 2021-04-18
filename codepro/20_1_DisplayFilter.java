/*
   2021-04-17
   LG codepro - [20년도_1차] 디스플레이 필터
   10/10: success (47min)
*/
package codepro;

import java.util.*;

class DisplayFilter {
    int N;
	int r[] = new int[10+2];
	int p[] = new int[10+2];
	
	void input() {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		for(int i=0; i<N; i++) {
			r[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}
		sc.close();
	}
	
	int check[] = new int[10+2];
	long minDiff=Long.MAX_VALUE;
	int cnt=1;
	
	void dfs(int pickNum, int k, int next) {
		// System.out.println(pickNum + " " + k + " "+ next);
		long tmpDiff=-1;
		long tmpR=1;
		long tmpP=0;
		if ( k==pickNum ) {
			
            for(int i=0; i<N; i++) {
				if ( check[i]==1 ) {
					// System.out.println(" =========== check : " + i);
					// System.out.println(" =========== r[i] : " + r[i] + "  // p[i] : " + p[i] );

					tmpR = tmpR*r[i];
					tmpP = tmpP+p[i];
				}
			}
			tmpDiff = Math.abs(tmpR-tmpP);
			
			if ( tmpDiff<minDiff ) {
				minDiff = tmpDiff;
				cnt = pickNum;
			}
			// System.out.println("=== minDiff : " + minDiff);
			return;
		};
		
		for(int i=next+1; i<N; i++) {
			// System.out.println(" /// next : " + next);
			check[i]=1;
			dfs(pickNum, k+1, i);
			check[i]=0;
		}
	}
	
	int solve() {
		
		for(int i=1; i<=N; i++) {
			Arrays.fill(check, 0);
			dfs(i, 0, -1);
		}
		
		return N-cnt;
	}
	
	public static void main(String[] args) throws Exception {
		// Main m=new Main();
        DisplayFilter m=new DisplayFilter();
		m.input();
		int ans = m.solve();
		System.out.println(ans);
	}
    
}
