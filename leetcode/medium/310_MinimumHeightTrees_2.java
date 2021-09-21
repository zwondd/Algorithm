import java.util.*;

/*
    2021-09-21 
    [Leetcode][Medium] 310. Minimum Height Trees
*/

/*
    - Wrong Answer
    - Time limit
    https://leetcode.com/submissions/detail/558439541/
*/
class MinimumHeightTrees2 {
    int N;
    boolean[] visited;
    int minHeight = Integer.MAX_VALUE;
    List<Integer> rootList = new ArrayList<>();
    int[][] E;

    Queue<Integer> q = new LinkedList<Integer>();
    
    public void bfs( int root, int height, int nodes ) {
        System.out.println("root : " + root + " / height : " + height + " / nodes : " + nodes );

        int nHeight = 0;
        int nNode = 0;
        while( !q.isEmpty() ) {
            nHeight = q.poll();
            nNode = q.poll();

           System.out.println("(" + nHeight + " ,  " + nNode + " )" );


            for(int i=0; i<N; i++) {
                if ( visited[i]==false && E[nNode][i]==1 ) {
                    q.add(nHeight+1);
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
        System.out.println("=== (" + nHeight + " ,  " + nNode + " )" );

        
        if( minHeight>nHeight ) {
            minHeight = nHeight;
            rootList.removeAll(rootList);
        }
        if ( minHeight>=nHeight ) {
            rootList.add(root);
        }
        printList();
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
            clearVisited();
            visited[i] = true;
            q.add(0);
            q.add(i);
            bfs( i, 0, i );
        }
        return rootList;
    }
    public void printList() {
        System.out.println(" printList ");
        System.out.println(" minHeight : " + minHeight);
        for(int i=0; i<rootList.size();i++) {
            System.out.print(rootList.get(i) + " ");
        }
        System.out.println("  ");
    }

    public static void main(String[] args) {
        MinimumHeightTrees2 mh = new MinimumHeightTrees2();
        
        int n = 6;
        // int[][] edges = {{0,1}, {0,2}, {0,3}, {3,4}, {4,5}};

        n=4;
        int[][] edges = {{1,0}, {1,2}, {1,3}};
        List<Integer> res = mh.findMinHeightTrees(n, edges);
        mh.printList();
    }
}
