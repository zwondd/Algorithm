/*
    2021-04-19
    Baekjoon 3055 탈출
    
    34min / wrong 
    분석 ) hedgedog 와 water의 움직임에 관한 Queue 를 각각 따로 정하여 trace 해야함?

*/
package baekjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class boj_3055_Escape_2 {
    static int r, c;
    static char map[][]      =new char[51][51];
    static char updateMap[][]=new char[51][51];

    static int minTime = 0;
    static int ans     =-1;

    static int dx[]= {0,-1,0,1};
    static int dy[]= {-1,0,1,0};

    static class pair{
        int x, y, time;
        pair(int a, int b){this.x=a;this.y=b;}
        pair(int a, int b, int c){this.x=a;this.y=b; this.time=c;}
    }

    public static void input() {
        Scanner sc=new Scanner(System.in);
        r=sc.nextInt();
        c=sc.nextInt();
        for(int i=0; i<r; i++) {
            map[i] = sc.next().toCharArray();
            for(int j=0; j<c; j++) {
                updateMap[i][j]=map[i][j];
            }
        }
        sc.close();
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if ( updateMap[i][j]== '*' ) water.add(new pair(i,j));
            }
        }
    }

    static LinkedList<pair> water=new LinkedList<>();
    public static void update() {
        // for(int i=0; i<r; i++) {
        //     for(int j=0; j<c; j++) {
        //         if ( updateMap[i][j]== '*' ) water.add(new pair(i,j));
        //     }
        // }
        int size=water.size();

        for(int k=0; k<size; k++) { // solution)
            pair temp=water.poll();
            for(int i=0; i<4; i++) {
                int nx, ny;
                nx=temp.x+dx[i];
                ny=temp.y+dy[i];

                if ( nx<0 || nx>=r || ny<0 || ny>=c ) continue;
                if ( updateMap[nx][ny] == 'D' || updateMap[nx][ny] == 'X' ) continue;

                // solution ) 

                if ( updateMap[nx][ny] == '.' )  updateMap[nx][ny] = '*';
                water.add(new pair(nx,ny));
            }
        }
    };

    static LinkedList<pair> l=new LinkedList<>();
    static boolean visit[][] = new boolean[51][51];
    public static void bfs(int x, int y) {

        visit[x][y]=true;
        pair np=new pair(x,y,0);
        l.add(np);

        while(l.size()>0) {
            np=l.pollFirst();

            // if ( updateMap[np.x][np.y] == 'D' ) break;

            // update water way
            update();

            int nx,ny;

            for(int i=0; i<4; i++) {
                nx = np.x + dx[i];
                ny = np.y + dy[i];

                if ( nx<0 || nx>=r || ny<0 || ny>=c ) continue;
                if ( visit[nx][ny] ) continue;
                if ( updateMap[nx][ny] == '*' || updateMap[nx][ny] == 'X' ) continue;

                if ( updateMap[nx][ny] == 'D' ) {
                    visit[nx][ny]=true;
                    l.add(new pair(nx,ny, np.time+1));
                    break;
                }

                visit[nx][ny]=true;
                updateMap[nx][ny] = 'S';
                l.add(new pair(nx,ny, np.time+1));
            }
            // visit[np.x][np.y]=false; // solution )
        }
        // if ( updateMap[np.x][np.y] == 'D' ) ans = np.time;
        if ( l.size()>0 ) {
            ans=l.poll().time;
        }
    }

    public static void solve() {
        int i,j;

        // find S position;
        for(i=0; i<r; i++) {
            for(j=0; j<c; j++) {
                if ( map[i][j] == 'S' ) {
                     bfs(i,j);
                }
            }
        }
        if ( ans==-1 ) System.out.println("KAKTUS");
        else System.out.println(ans);
    }

    public static void main(String args[]) {
        input();
        solve();
    }
}
