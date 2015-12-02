//Given a binary tree, determine if it is a valid binary search tree (BST).

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
   public boolean isValidBST(TreeNode root) {
      return inorderTranverse(root);
   }
   
   private TreeNode pre;
   private boolean inorderTranverse(TreeNode node) {
       if(node == null) return true;
       if(!inorderTranverse(node.left)) return false;
       if(pre != null) {
          if(node.val <= pre.val) {
             return false;
          }
       }
       
       pre = node;
       if(!inorderTranverse(node.right)) return false;
       return true;
   }
}