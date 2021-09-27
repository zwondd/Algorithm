import java.util.*;

import org.graalvm.compiler.nodes.java.NewMultiArrayNode;

/*
    2021-09-21 
    [Leetcode][Medium] 310. Minimum Height Trees
*/

/*
   https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/310-minimum-height-trees.html
   https://velog.io/@pyh8618/LeetCode-310.-Minimum-Height-Trees
   최소 높이를 구하기 위해 루트를 선택하는 것이 아닌 리프 노드 부터 삭제 해나가면 남아있는 노드를 통해 루트 노드를 구할 수 있다.
*/
class MinimumHeightTrees3 {
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
      HashMap<Integer, LinkedList<Integer>> adj = new HashMap<Integer, LinkedList<Integer>>();
      init(adj, n, edges);

      List<Integer> leaves = new LinkedList<>();
      for(Integer i : adj.keySet() ) {
          if ( adj.get(i).size() == 1 ) {
              leaves.add(i);
          }
      }

      if ( leaves.size()==0 ) {
          return leaves;
      }

      while( n>2 ) {
          n = n -leaves.size();
          List<Integer> newLeaves = new LinkedList<>();
          for(Integer i : leaves ) {
              int nb = adj.get(i).get(0);
              adj.get(nb).remove(i);
              if ( adj.get(nb).size() ==1  ) {
                  newLeaves.add(nb);
              }
          }
          leaves = newLeaves;
        }
        return leaves;
    }

    private void init(HashMap<Integer, LinkedList<Integer>> adj, int n, int[][] edges) {
        for (int i = 0; i < n; i ++) {
            adj.put(i, new LinkedList<Integer>());
        }
        for (int i = 0; i < edges.length; i ++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
    }

    public static void main(String[] args) {
        MinimumHeightTrees2 mh = new MinimumHeightTrees2();
        
        int n = 6;
        // int[][] edges = {{0,1}, {0,2}, {0,3}, {3,4}, {4,5}};

        n=4;
        int[][] edges = {{1,0}, {1,2}, {1,3}};
        List<Integer> res = mh.findMinHeightTrees(n, edges);
    }
}
