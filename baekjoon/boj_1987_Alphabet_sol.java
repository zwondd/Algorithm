/*
   2021-04-18
   Baekjoon 1987 알파벳
 */
package baekjoon;

import java.util.Scanner;

public class boj_1987_Alphabet_sol {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int r;
    static int c;
    static int cnt = 1;
    static int ans = 1;

    static int[][] map = new int[21][21];
    static boolean[] visit=new boolean[26];
    
    void input() {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();

        String str;
        for(int i=0; i<r; i++) {
            str = sc.next();
            for(int j=0; j<c; j++) {
                map[i][j] = str.charAt(j)-'A';
            }
        }
        sc.close();
    }

    void dfs(int x, int y) {
        int idx=map[x][y];

        visit[idx] = true;

        int nx, ny;
        for(int i=0; i<4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if ( -1<nx && nx<c && -1<ny && ny<r ) {
                int next = map[nx][ny];

                if ( !visit[next] ) {
                    ans = Math.max(++cnt, ans);
                    dfs(nx,ny);
                }
            }
        }

        --cnt;
        visit[idx] = false;
    }

    void dfs2(int x, int y, int count) {
        if ( visit[map[x][y]] ) {
            ans=Math.max(ans, count);
        } else {
            visit[map[x][y]] = true;

            int nx, ny;
            for(int i=0; i<4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if ( 0<=nx && nx<c && 0<=ny && ny<r ) {
                    dfs2(nx, ny, count+1);
            
                }
            }
            visit[map[x][y]] = false;
        }
    }

    void solve() {
        // solution 1)
        dfs(0,0);

        // solution 2)
        // dfs2(0,0,0);

        System.out.println(ans);
    }

    public static void main(String args[]) {
        // Main m=new Main();
        boj_1987_Alphabet_sol m=new boj_1987_Alphabet_sol();
        m.input();
        m.solve();
    }
    
}
