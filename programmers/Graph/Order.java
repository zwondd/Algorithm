/*
    2021-10-12
    [Programmers][Graph][Lv3] 순위
*/
package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Order {
    class Player{
        int num;
        int totalToGetOrder;
        Player(){
            num=-1;
            totalToGetOrder=-1;
        }
        Player(int x, int y) {
            num = x;
            totalToGetOrder = y;
        }
    }

    public int solution(int n, int[][] results) {
        boolean[][] game = new boolean[n][n];
        int answer = 0;
        for(int i=0; i<results.length; i++) {
            game[results[i][0]-1][results[i][1]-1]=true;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    if ( game[j][i] && game[i][k] ) {
                        game[j][k] = true;
                    }
                }
            }
        }
        for(int i=0; i<n; i++) {
            int result = 0;
            for(int j=0; j<n; j++) {
                if ( game[i][j] || game[j][i] ) result++;
            }
            if ( result==n-1 ) answer++;
        }
        return answer;
    }

    /*
        TC 2/10 통과
        다익스트라
    */
    public int solution2(int n, int[][] results) {
        int answer = 0;
        int[][] winCnt = new int[n+1][2];

        for(int i=0; i<results.length; i++) {
            int win=results[i][0];
            int loose = results[i][1];
            winCnt[win][0]+=1;
            winCnt[loose][1]+=1;
        }

        // for(int i=1; i<=n; i++) {
        //     for(int j=0; j<2; j++) {
        //         System.out.print( winCnt[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        Queue<Player> q = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            if ( winCnt[i][0] + winCnt[i][1] == n-1 ) {
                q.add(new Player(i, n-1));
            }
        }

        while( !q.isEmpty() ) {
            Player p = q.poll();

            for(int i=0; i<results.length; i++) {
                int nPlayer=-1, nTotal=-1;

                // win
                if ( results[i][0] == p.num ) {
                    nPlayer = results[i][1];
                    nTotal = winCnt[p.num][0]-1;                   
                }
                // loose
                if ( results[i][1] == p.num ) {
                    nPlayer = results[i][0];
                    nTotal = winCnt[p.num][1]-1;
                }

                // System.out.println(" nPlayer : " + nPlayer + "  nTotal : " + nTotal );
                if ( nPlayer == -1 ) continue;

                if ( winCnt[nPlayer][0] + winCnt[nPlayer][1] == nTotal ) {
                    answer++;
                    q.add( new Player(nPlayer, nTotal) );
                } else if ( p.totalToGetOrder == 0 ) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Order od = new Order();
        int n=5;
        int[][] results = {{4,3}, {4,2}, {3,2}, {1,2}, {2,5} };
        System.out.println(od.solution(n, results));
    }
    
}
