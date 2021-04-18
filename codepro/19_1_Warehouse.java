/*
    21-04-19
    LG codepro - [19년도_1차] 물류창고
    5/10 : success (30min)
*/
package codepro;

import java.util.*;

class Warehouse {
	static int N,M;
	static int dist[][] = new int[102][102];
	static int IMP = 10000;
		
	void input() {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if ( i==j ) {
					dist[i][j]=0;
				} else {
					dist[i][j]=IMP;					
				}
			}
		}
		int a, b, d;
		for(int i=0; i<M; i++) {
			a=sc.nextInt();
			b=sc.nextInt();
			d=sc.nextInt();
			dist[a][b]=d;
			dist[b][a]=d;
		}
		
		sc.close();
	}
	
	void findMinDist() {
		for(int k=1; k<=N; k++) {  // (1) 위치를 옮기고 나서 all success (Floyd Warshall)
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
                    // for(int k=1; k<=N; k++) {  // (1)
					if ( i==j ) continue; 
						int tmp = dist[i][k]+dist[k][j];
						if ( tmp < dist[i][j] ) dist[i][j] = tmp;
					}	
				}
			}
		
		// for(int i=1; i<=N; i++) {
		// 	for(int j=1; j<=N; j++) {
		// 		System.out.print(dist[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
	}
	
	void solve() {
		findMinDist();
		int minMaxDist=987654321;
		for(int i=1; i<=N; i++) {
			int maxDist=-1;
			for(int j=1; j<=N; j++) {
				if ( i==j ) continue;
				maxDist = Math.max(maxDist, dist[i][j] );		
			}
			minMaxDist=Math.min(minMaxDist, maxDist);
		}
		System.out.println(minMaxDist);
	}
	
	
	public static void main(String[] args) throws Exception {
		// Main m=new Main();
        Warehouse m = new Warehouse();
		m.input();
		m.solve();
	}
}