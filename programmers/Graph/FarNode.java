/*
    2021-10-12
    [Programmers][Graph][Lv3] 가장 먼 노드
*/
package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class FarNode {
    /*
        다익스트라
    */
    public int solution(int n, int[][] edge) {
        int[] dist = new int[n+1];
        boolean[][] map = new boolean[n+1][n+1];
        for(int i=0; i<edge.length; i++) {
            map[edge[i][0]][edge[i][1]] = map[edge[i][1]][edge[i][0]] = true;
        }

        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(1);

        int maxDist=0;
        while( !nodes.isEmpty() ) {
            int i=nodes.poll();

            for(int j=2; j<=n; j++) {
                if ( dist[j]==0 && map[i][j] ) {
                    dist[j]=dist[i]+1;
                    nodes.add(j);
                    maxDist=Math.max(maxDist, dist[j]);
                }
            }
        }
        int count=0;
        for(int d:dist) {
            if ( maxDist==d ) {
                count++;
            }
        }
        return count;
    }

    /*
        플로이드 워셜
        tc 7~8 메모리 초과로 실패
    */
    public int solution2(int n, int[][] edge) {
        int answer = 0;

        int[][] graph = new int[n+1][n+1];

        for(int i=0; i<edge.length; i++) {
            graph[edge[i][0]][edge[i][1]]=1;
            graph[edge[i][1]][edge[i][0]]=1;
        }

        for(int k=1; k<=n; k++) { // 기준점을 먼저 잡는것 기억하기
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if ( i==j || i==k || j==k ) continue;
                    // i -> k -> j
                    if ( graph[i][k]!=0 && graph[k][j]!=0 ) {
                        if ( graph[i][j]==0 ) {
                            graph[i][j] = graph[i][k]+graph[k][j];
                        } else {
                            graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j] );
                        }
                    }
                }
                // System.out.println("["+i+"]["+j+"]" +graph[i][j] );
            }
        }

        int maxValue = -1;
        int cnt = 0;
        for(int i=2; i<=n; i++) {
            if ( graph[1][i] == maxValue ) {
                cnt++; continue;
            }
            if ( graph[1][i] > maxValue ) {
                maxValue = graph[1][i];
                cnt=1;
            }
        }
        answer = (maxValue==-1) ? 0 : cnt;

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                System.out.print(graph[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        FarNode fn = new FarNode();
        int n=5;
        int[][] edge = { {3,4}, {2,3}, {1,3}, {1,2}, {2,4}, {5,2}};
        fn.solution(n, edge);
    }
    
}
