/*
    2021-12-13
    [Leetcode][Easy] 234. Palindrome Linked List
*/
import java.util.*;

class BinaryTreeZigzag {
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
    Runtime: 1 ms, faster than 78.14% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
    Memory Usage: 39 MB, less than 84.97% of Java online submissions for Binary Tree Zigzag Level
    참고 ) https://bhsbhs235.github.io/algorithm/2020/03/14/leetcode103.html
  */

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) { 
      List<List<Integer>> ret = new ArrayList<>();
      if ( root == null ) return ret;

      boolean flag = true;
      Stack<TreeNode> stack = new Stack<>();
      stack.push(root);

      while( !stack.isEmpty() ) {
          int size = stack.size();

          Stack<TreeNode> newStack = new Stack<>();
          List<Integer> level = new ArrayList<>();
          for(int i=0; i<size; i++) {
              TreeNode node = stack.pop();
              level.add(node.val);

              if ( flag ) {
                  if ( node.left != null ) newStack.push(node.left);
                  if ( node.right != null ) newStack.push(node.right);
              } else {
                  if ( node.right != null ) newStack.push(node.right);
                  if ( node.left != null ) newStack.push(node.left);
              }
          }
          ret.add(level);
          stack = newStack;
          flag = !flag;
      }
      return ret;
  }
    
}
