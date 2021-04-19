/*
    2021-04-19
    Baekjoon 3055 탈출
    
    ok / 18512 KB / 236 ms 
*/
package baekjoon;

import java.util.*;

public class boj_3055_Escape_sol_1 {
    static char[][] map;
    static int r, c;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static Queue<Point> water = new LinkedList<>();
    static Queue<Point> hedgehog = new LinkedList<>();

    static class Point {
        int x;
        int y;
     
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void input() {
        Scanner sc=new Scanner(System.in);
        r=sc.nextInt();
        c=sc.nextInt();
        map = new char[r][c];
        for(int i=0; i<r; i++) {
            map[i] = sc.next().toCharArray();
            for(int j=0; j<c; j++) {
                if ( map[i][j] == '*') {
                    water.add(new Point(i,j));
                }

                if ( map[i][j] == 'S') {
                    hedgehog.add(new Point(i,j));
                }
            }
        }
        sc.close();
    }

    public static void extendWater() {
        int size = water.size();
        for(int i=0; i<size; i++) {
            Point p = water.poll();

            int nx, ny;
            for(int j=0; j<4; j++) {
                nx = p.x + dx[j];
                ny = p.y + dy[j];

                if ( 0<=nx && nx<r && 0<=ny && ny<c ) {
                    if ( map[nx][ny] == '.' ) {
                    // if ( map[nx][ny] == '.' || map[nx][ny] == 'S' ) {  // 결과 값음??
                        map[nx][ny] = '*';
                        water.add(new Point(nx, ny));
                    }
                }
            }
        }
    }

    public static boolean extendHedgeDog() {
        int size = hedgehog.size();

        for(int i=0; i<size; i++) {
            Point p = hedgehog.poll();

            int nx, ny;
            for(int j=0; j<4; j++) {
                nx = p.x + dx[j];
                ny = p.y + dy[j];

                if ( 0<=nx && nx<r && 0<=ny && ny<c ) {
                    if ( map[nx][ny] == 'D' ) {
                        hedgehog.add(new Point(nx, ny));
                        return true;
                    }
                    if ( map[nx][ny] == '.' ) {
                        map[nx][ny] = 'S';
                        hedgehog.add(new Point(nx, ny));
                    }
                }
            }
        }
        return false;
    }

    public static void solve() {
        int ans=0;

        while(true) {
            ++ans;
            if( hedgehog.size() ==0 ) {
                System.out.println("KAKTUS");
                return;
            }

            extendWater();
            if ( extendHedgeDog() ) {
                System.out.println(ans);
                return;
            }
        }
    }

    public static void main(String args[]) {
        input();
        solve();
    }
}
