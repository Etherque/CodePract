/* Given a binary tree
    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. 
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
       if(root == null) return;
       Queue<TreeLinkNode> queue = new LinkedList<> ();
       queue.offer(root);
       
       while(!queue.isEmpty()) {
          int size = queue.size();
          for(int i = 0; i < size; i++) {
            TreeLinkNode node = queue.poll();
            if(i != size - 1) node.next = queue.peek();
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
          }
       }
    }   
}