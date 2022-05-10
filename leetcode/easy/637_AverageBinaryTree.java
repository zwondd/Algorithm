/*
    2022-05-10
    [Leetcode][Easy] 637. Average of Levels in Binary Tree
*/
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
/*
    Runtime: 4 ms, faster than 33.11% of Java online submissions for Average of Levels in Binary Tree.
    Memory Usage: 47.3 MB, less than 60.08% of Java online submissions for Average of Levels in Binary Tree.
*/
class AverageBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avg = new LinkedList<>();
        if ( root==null ) return avg;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode cur;
        while( !q.isEmpty() ) {
            int size = q.size();
            double sum=0;

            for(int i=0; i<size; i++) {
                cur = q.poll();
                sum += cur.val;

                if ( cur.left !=null ) q.add(cur.left);
                if ( cur.right !=null ) q.add(cur.right);
            }
            avg.add(sum/size);

        }
        return avg;        
    }
}
