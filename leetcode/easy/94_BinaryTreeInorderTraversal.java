/*
    2022-01-24
    [Leetcode][Easy] 94. Binary Tree Inorder Traversal
*/
import java.util.*;

class BinaryTreeInorderTraversal {

   public class TreeNode {
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
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
        Memory Usage: 37.5 MB, less than 52.91% of Java online submissions for Binary Tree Inorder Traversal.
   */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        
        if ( root == null ) return list;
        traverse(list, root);
        return list;
    }

    public void traverse(List<Integer> list, TreeNode root) {
        if ( root == null ) return;

        traverse(list, root.left);
        list.add(root.val);
        traverse(list, root.right);
        return;
    }
}
