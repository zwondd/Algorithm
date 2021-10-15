/*
    2021-10-15
    [Programmers][Graph][Lv2] 네트워크

    check) 단방향 네트워크
    1->2->3
    3->2
    => 각각 네트워크 2개인 상황임.
*/
package DfsBfs;

public class Network {
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if ( visited[i]==false ) {
                dfs(i, n, computers);
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int k, int n, int[][] computers) {
        System.out.println("k : " + k + " visited[k] : " + visited[k]);
        visited[k] = true; 
    
        // fail
        // if ( k>=n-1 ) {
        //     return;
        // }
        for(int i=0; i<n; i++) {
            if ( k==i ) continue;
            if ( computers[k][i] == 1 && visited[i] == false ) {
                // visited[i] = true;  // fail - 여기서 체크 하면 solutoin() 에서 처음 dfs 진입할 때 visited check 안됨.
                dfs(i, n, computers);
            }
        }
    }

    public static void main(String[] args) {
        Network network=new Network();

        int n=3;
        // int[][] computers = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        // int[][] computers = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

        // n=4;
        // int[][] computers = {{1, 1, 1, 0}, {1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}};

        n=5;
        // int[][] computers = {{1, 1, 1, 1,0}, {1, 1, 1, 0,0}, {1, 1, 1, 0,0}, {1, 0, 0, 1,0},  {0, 0, 0, 0, 1}};
        // int[][] computers = {{1, 1, 0, 0,1}, {1, 1, 1, 0,0}, {0, 1, 1, 1,0}, {0, 0, 1, 1,0},  {1, 0, 0, 0, 1}};

        n=1;
        // int[][] computers = {{1}};

        n=2;
        // int[][] computers = {{1,0}, {0,1}};

        n=4;
        // int[][] computers = {{1, 1, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0,0,0,1}};
        
        n=3;
        // int[][] computers = {{1, 0, 0}, {1, 1, 0}, {1, 0, 1}};
        n=5;
        int[][] computers = {{1, 0,  0,  0, 0}, {0, 1,  0,  0, 0}, {0,0,1,0,0}, {0, 0, 0, 1,0},  {1, 0, 0, 0, 1}};


        System.out.println(network.solution(n, computers));
    }
    
}
