/*
    2022-03-23
    [Leetcode][Easy] 100. Same Tree
*/

/**
  Definition for a binary tree node.
*/
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

class SameTree_2 {
    /*
        Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
        Memory Usage: 41.5 MB, less than 46.22% of Java online submissions for Same Tree.
    */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p==null && q==null ) return true;
        if ( p==null && q!=null ) return false;
        if ( p!=null && q==null ) return false;

        // if ( p==null && q==null ) return true;
        // if ( p==null || q==null ) return false;



        if ( p.val != q.val ) return false;

        boolean leftTree = isSameTree(p.left, q.left);
        boolean rightTree = isSameTree(p.right, q.right);

        if ( leftTree && rightTree ) return true;
        return false;
    }
}
