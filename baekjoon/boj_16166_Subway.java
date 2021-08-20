/*
    2021-08-20
    Baekjoon 16166 서울의 지하철

    solution : https://red-pulse.tistory.com/217 // runtime error
    
*/
package baekjoon;
import java.util.*;

class Subway {
    int totalLine;
    int[][] line = new int[11][11];
    int[] dp = new int[11];
    ArrayList<Integer>[] link = new ArrayList[11];

    void input() {
        for(int i=0; i < line.length; i++) {
            Arrays.fill( line[i], -1 );
        }
        Scanner sc=new Scanner(System.in);
        totalLine = sc.nextInt();
        for(int i=1; i<=totalLine; i++) {
            int k;
            k = sc.nextInt();
            for(int j=0; j<k; j++) {
                line[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<11; i++) {
            link[i] = new ArrayList<>();
        }

        for(int i=1; i<=totalLine; i++) {
            for(int j=0; j<10; j++) {
                if ( line[i][j] == -1 ) {
                    break;
                }

                for( int x=i+1; x<=totalLine; x++) {
                    for(int y=0; y<10; y++) {
                        if ( line[x][y] == -1 ) break;
                        if ( line[i][j] == line[x][y] ) {
                            link[i].add(x);
                            link[x].add(i);
                        }
                    }
                }
            }
        }
    }

    void solve() {
        Queue<Integer> q = new LinkedList<>();
        Scanner sc=new Scanner(System.in);

        Arrays.fill( dp, -1 );
        for(int i=1; i<=totalLine; i++) {
            for(int j=0; j<10; j++) {
                if ( line[i][j] == -1 ) {
                    break;
                }
                if ( line[i][j] == 0 ) {
                    dp[i] = 0;
                    q.add(i);
                }
            }
        }

        while( !q.isEmpty() ) {
            int now = q.poll();
            for( int next : link[now] ) {
                if ( dp[next] == -1 || dp[next] > dp[now]+1 ) {
                    dp[next] = dp[now] + 1;
                    q.add(next);
                }
            }
        }

        int t;
        t = sc.nextInt();
        int ans = -1;
        for(int i=1; i<=totalLine; i++) {
            for(int j=0; j<10; j++) {
                if ( line[i][j] == -1 ) break;
                if ( line[i][j] == t ) {
                    if ( ans == -1 ) ans = dp[i];
                    else ans = Math.min( ans, dp[i]);
                }
            }
        }
        System.out.println(ans);
    }

    public static void main (String[] args) {
        Subway s = new Subway();
        s.input();
        s.solve();
    }
}