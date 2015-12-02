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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<> ();
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<> ();
        q.add(root);
        
        while(!q.isEmpty()) {
            List<Integer> level = new LinkedList<> ();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode visited = q.remove();
                level.add(visited.val);
                if(visited.left != null) q.add(visited.left);
                if(visited.right != null) q.add(visited.right);
            }
            res.add(level);
        }
        return res;
    }
}
