import java.util.*;

/*
    2021-09-21
    [Leetcode][Medium] 310. Minimum Height Trees
*/

/*
    -- 잘못된 풀이 : dfs 로 해당 root 의 마지막 leaf 까지 가기전에 min height 를 갱신 시켜버림.
*/
class MinimumHeightTrees {
    int N;
    boolean[] visited;
    int minHeight = Integer.MAX_VALUE;
    List<Integer> rootList = new ArrayList<>();
    int[][] E;
    
    public void dfs( int root, int height, int nodes ) {
        System.out.println("root : " + root + " / height : " + height + " / nodes : " + nodes );
        // 1. heigth == n  
        // 2. furthur node doesn't exits -> escape

        if ( height == N ) {
            if ( minHeight < height ) 
            if ( minHeight< height ) {
                return;
            }
            if ( minHeight > height ) {
                minHeight = height;
                rootList.removeAll(rootList);
            }
            if ( !rootList.contains(root) ) {
                rootList.add(root);
            }
            return;
        }

        boolean hasNextNode = false;
        for(int i=0; i<N; i++) {
            if ( visited[i] == true ) continue;

            if ( E[nodes][i] == 1 ) {
                hasNextNode = true;
                visited[i] = true;
                dfs( root, height+1, i );
                visited[i] = false;
            }
        }

        printList();

        if ( !hasNextNode ) {
            if ( minHeight< height ) {
                return;
            }
            if ( minHeight > height ) {
                minHeight = height;
                rootList.removeAll(rootList);
            }
            if ( !rootList.contains(root) ) {
                rootList.add(root);
            }
            return;
        }
    }

    public void printList() {
        System.out.println(" printList ");
        System.out.println(" minHEight : " + minHeight);
        for(int i=0; i<rootList.size();i++) {
            System.out.print(rootList.get(i) + " ");
        }
        System.out.println("  ");
    }

    public void clearVisited() {
        for(int i=0; i<N; i++) {
            visited[i] = false;
        }
    }
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        N = n;
        E = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<edges.length; i++) {
            E[edges[i][0]][edges[i][1]] = 1;
            E[edges[i][1]][edges[i][0]] = 1;
        }
        for(int i=0; i<n; i++) {
            visited[i] = true;
            dfs( i, 0, i );
            clearVisited();
        }
        return rootList;
    }

    public static void main(String[] args) {
        MinimumHeightTrees mh = new MinimumHeightTrees();
        
        int n = 6;
        int[][] edges = {{0,1}, {0,2}, {0,3}, {3,4}, {4,5}};
        List<Integer> res = mh.findMinHeightTrees(n, edges);
        mh.printList();
    }
}
