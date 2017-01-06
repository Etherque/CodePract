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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<> ();
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<> ();
        q.add(root);
        
        while(!q.isEmpty()) {
            List<Integer> level = new LinkedList<> ();
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                TreeNode visit = q.remove();
                level.add(visit.val);
                if(visit.left != null) q.add(visit.left);
                if(visit.right != null) q.add(visit.right);
            }
            res.add(0,level);//add(int position, E) insert in a given index position
        }
        return res;
    }
}
