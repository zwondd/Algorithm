/*
    2022-01-04
    [Leetcode][Medium] 98. Validate Binary Search Tree
*/
import java.util.*;

class ValidateBST {
    
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
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
        Memory Usage: 38.3 MB, less than 88.39% of Java online submissions for Validate Binary Search Tree.

        두 레벨 이상의 node 끼리는 BST임이 보장되지 않음-> max, min 값 전달해줘야함.
        ref) https://duck67.tistory.com/17
    */
    public boolean search(TreeNode root, long max, long min) {
        if ( root==null ) return true;
        if ( max<=root.val || min>=root.val ) return false;

        boolean left = search(root.left, root.val, min);
        boolean right = search(root.right, max, root.val);
        
        return left&&right;
    }
    public boolean isValidBST(TreeNode root) {
        return search(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
}
