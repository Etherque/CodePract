# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        result, queue, curr_node = [], [], root
        while curr_node or queue:
            while curr_node :
                queue.append(curr_node)
                curr_node = curr_node.left
            curr_node = queue.pop()
            result.append(curr_node.val)
            curr_node = curr_node.right
        
        return result
