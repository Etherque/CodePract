//Given a binary tree, return the preorder traversal of its nodes' values.

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<> ();
        if(root == null) return result;
        
        Stack<TreeNode> stk = new Stack<> ();
        stk.push(root);
        while(!stk.isEmpty()) {
           TreeNode node = stk.pop();
           result.add(node.val);
           if(node.right != null) stk.push(node.right);
           if(node.left != null) stk.push(node.left);
        }
        return result;
    }
}