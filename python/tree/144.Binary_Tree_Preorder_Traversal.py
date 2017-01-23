# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#iterative
class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        result, queue = [], [root]
        while queue:
            curr_node = queue.pop()
            if curr_node :
                result.append(curr_node.val)
                queue.append(curr_node.right)
                queue.append(curr_node.left)
        
        return result

#Morris:
class Solution(object):
