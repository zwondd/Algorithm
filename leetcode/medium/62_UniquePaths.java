import java.util.*;


// 21-07-06

class Solution {
    int M, N;
    int[][] visit = new int[101][101];
    int cnt=0;

    public void dfs( int x, int y ) {
        // System.out.println("x : " + x + " y : " + y);
        if ( x==1 && y==N ) {
            visit[1][y]+=1;
            // System.out.println("// " + visit[1][y]);
            // cnt++;
            return;
        }

        visit[x][y] += 1;

        if ( x-1 >=1 ) {
            dfs(x-1,y);
        }
        if ( y+1 <=N ) {
            dfs(x, y+1);
        }
    }


    public void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(M); 
        q.add(1);

        while( !q.isEmpty() ) {
            int x = q.poll();
            int y = q.poll();

            // System.out.println("x : " + x + " y : " + y);

            visit[x][y]+=1;


            if ( x-1 >=1 ) {
                q.add(x-1);
                q.add(y);
            }

            if ( y+1 <=N ) {
                q.add(x);
                q.add(y+1);
            }
        }
        
    }


    public int uniquePaths(int m, int n) {
        M=m; N=n;

        // dfs timeout
        // dfs(m,1);
        // return visit[1][N];

        //bfs time limit exceeded
        bfs();
        return visit[1][n];
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.uniquePaths(3, 7);
        System.out.println(ans);

    }
}