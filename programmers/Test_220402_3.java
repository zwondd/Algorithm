import java.util.*;

public class Test_220402_3 {
    /*
        두 송전탑 A, B 사이에 전력을 공급하기 위한 송전 선로를 연결하려 합니다. 송전탑과 송전 선로는 그래프 형태로 표현이 가능하며, 각 노드는 송전탑, 송전탑과 송전탑을 연결하는 간선은 송전 선로를 나타냅니다. 모든 송전 선로(간선)의 가중치는 1 입니다. 
        당신은 아래 규칙을 지키며 송전 선로를 적절히 선택하여 A 송전탑에서 B 송전탑까지 연결하는 경로를 만들려 합니다.
        해당 경로에 포함되는 송전 선로의 가중치 합이 k 이하여야 합니다.
        같은 송전탑을 두 번 이상 지나면 안됩니다.
        다음은 송전탑 8개와 각 송전탑을 연결하는 송전 선로가 주어진 예시입니다. A 송전탑(0번 노드)에서 B 송전탑(3번 노드)으로 가는 경로에 포함된 송전 선로의 가중치 합은 4 이하여야 합니다(k = 4).

        n	edges	k	a	b	result
        8	[[0,1],[1,2],[2,3],[4,0],[5,1],[6,1],[7,2],[7,3],[4,5],[5,6],[6,7]]	4	0	3	7
    */

    public int solution(int n, int[][] edges, int k, int a, int b) {
        int answer = 0;
        int[][] conn = new int[n][n];
        for(int i=0; i<edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            conn[x][y] = conn[y][x] = 1;
        }
        boolean[] visited= new boolean[n];
        visited[a]=true;

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();

        for(int i=0; i<n; i++) {
            map.put(i, 0);
        }

        list.add(a);
        dfs(a,0, conn, b, k, visited, map, a);

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if ( conn[i][j]==1 && map.get(i)>0 && map.get(j)>0 ) {
                    System.out.println("i : " + i + " j : " + j);
                    answer++;
                }
            }
        }
        // for(int i=0; i<map.size(); i++) {
        //     if ( map.get(i)==0 ) answer-=1;
        // }
        return answer;
    }

    public int dfs(int num, int w, int[][] conn, int b, int k, boolean[] visited,  Map<Integer, Integer> map, List<Integer> list) {
        if ( w>k ) return 0;
        if ( num==b ) {
            
            for(int i=0; i<conn.length; i++) {
                if ( visited[i]==true ) map.put(i,map.get(i)+1);
            }
            return;
        }

        int cnt = 0;

        for(int i=0; i<conn.length; i++) {
            if ( conn[num][i]==0 || visited[i]==true ) continue;
            visited[i]=true;
            list.add(i);
            dfs(i, w+1, conn, b, k, visited, map, list);
            list.remove(list.size()-1);
            visited[i]=false;

        }
    }

    public static void main(String[] args) {
        Test_220402_3 sol = new Test_220402_3();
        int n = 8;
        int[][] edges = {{0,1},{1,2},{2,3},{4,0},{5,1},{6,1},{7,2},{7,3},{4,5},{5,6},{6,7}};
        int k = 4;
        int a =0;
        int b =3;

        int res = sol.solution(n, edges, k, a, b);
        System.out.println(res);
        
    }
    
}
