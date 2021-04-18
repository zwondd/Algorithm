/*
   2021-04-18
   Baekjoon 1987 알파벳

   ok - 45min , 20104KB, 1148ms
 */
package baekjoon;

import java.util.*;

class Alphabet {
    int R,C;
    int maxCnt=1;
    char board[][] = new char[20+2][20+2];
    boolean visited[][] = new boolean[20+2][20+2];
    boolean checkAlphabet[] = new boolean[26+1];
    
    int dx[] = {0,-1,0,1};
    int dy[] = {-1,0,1,0};

    void input() {
        Scanner sc = new Scanner(System.in);
        R=sc.nextInt();
        C=sc.nextInt();

        String str;
        for(int i=0; i<R; i++) {
            str=sc.next();
            board[i] = str.toCharArray();
        }
        sc.close();
    }

    void dfs(int x, int y, int k) {
        // System.out.println("x : " + x + " y : " + y + " k : " + k);
        visited[x][y]=true;
        checkAlphabet[board[x][y]-'A']=true;

        if ( maxCnt<k ) maxCnt=k;

        int nx, ny;
        for(int i=0; i<4; i++) {
            nx=x+dx[i];
            ny=y+dy[i];
            if ( nx<0 || nx>=R || ny<0 || ny>=C ) continue;
            if ( visited[nx][ny] ) continue;
            if ( checkAlphabet[board[nx][ny]-'A']  ) continue;
            dfs(nx,ny,k+1);

            // solve) x, y -> nx, ny
            visited[nx][ny]=false;
            checkAlphabet[board[nx][ny]-'A']=false;
        }
    }

    void solve() {
        dfs(0,0,1);
        System.out.println(maxCnt);
    }

    public static void main(String args[]) {
        // Main m=new Main();
        Alphabet m=new Alphabet();
        m.input();
        m.solve();
    }
    
}
