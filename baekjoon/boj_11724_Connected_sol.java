/*
   2021-04-18
   Baekjoon 11724 연결요소개수
 */
package baekjoon;

import java.util.*;

public class boj_11724_Connected_sol {
    static int[][] graph = new int[1001][1001];
    static int V;
    static int E;
    static boolean[] visited=new boolean[1001];
    static int result=0;
    
    void dfs(int index) {
        if ( visited[index] ) return;

        visited[index] = true;
        for(int i=1; i<=V; i++) {
            if ( graph[index][i] == 1 ) {
                dfs(i);
            }
        }
    }

    void solve() {
        for(int i=1; i<=V; i++) {
            if ( visited[i]==false ) {
                dfs(i);
                result++;
            }
        }

    }

    void input() {
        Scanner sc =new Scanner(System.in);
        V=sc.nextInt();
        E=sc.nextInt();
        
        int v1,v2;
        for(int i=0; i<E; i++) {
            v1=sc.nextInt();
            v2=sc.nextInt();

            graph[v1][v2]=graph[v2][v1]=1;
        }
        sc.close();
    }

    public static void main(String args[]) {
        boj_11724_Connected_sol m=new boj_11724_Connected_sol();
        m.input();
        m.solve();
        System.out.println(result);
    }
    
}
