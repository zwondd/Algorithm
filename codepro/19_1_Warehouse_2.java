/*
    21-04-19
    LG codepro - [19년도_1차] 물류창고
    BFS 로 풀이
*/
package codepro;

import java.util.*;

class Warehouse_2 {
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

    int bfs(int start) {
        LinkedList<Integer> q=new LinkedList<>();
        int visit[] = new int[110];
        int tmp, maxDist=-1;

        for(int i=1; i<=N; i++) {
            visit[i]=IMP;
        }

        visit[start]=0;  // solve) visit[start]=0 으로 초기화
        q.add(start);

        while( q.size() >0 ) {
            tmp=q.peekFirst();
            q.pollFirst();

            for(int i=1; i<=N; i++) {
                if ( visit[i] <= visit[tmp]+dist[tmp][i] ) continue;
                visit[i]=visit[tmp]+dist[tmp][i];
                q.add(i);
            }
        }
        for(int i=1; i<=N; i++) {
            if ( maxDist<visit[i] ) maxDist=visit[i];
        }
        return maxDist;
	}

    void solve() {
        int i, sol=IMP, ret;

        for(i=1; i<=N; i++) {
            ret = bfs(i);
            // System.out.println(ret);
            if ( sol>ret ) sol=ret;
        }
        System.out.println(sol);
	}

    public static void main(String[] args) throws Exception {
		// Main m=new Main();
        Warehouse_2 m = new Warehouse_2();
		m.input();
		m.solve();
	}
    
}
