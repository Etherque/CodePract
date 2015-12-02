//Given a binary tree, return the inorder traversal of its nodes' values.

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
    public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> result = new ArrayList<> ();
       if(root == null) return result;
       
       Stack<TreeNode> stk = new Stack<> ();
       TreeNode node = root;
       
       while(node != null || !stk.isEmpty()) {
          if(node != null) {
            stk.push(node);
            node = node.left;
          }
          else {
            node = stk.pop();
            result.add(node.val);
            node = node.right;
          }
       }
       return result;
    }
}