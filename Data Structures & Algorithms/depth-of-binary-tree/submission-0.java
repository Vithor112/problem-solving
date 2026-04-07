/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int findDepth(TreeNode root, int depth){
        if (root == null){
            return depth; 
        }
        depth++;
        int leftDepth = findDepth(root.left, depth);
        int rightDepth = findDepth(root.right, depth); 
        return leftDepth > rightDepth ? leftDepth : rightDepth; 
    }
    public int maxDepth(TreeNode root) {
        return findDepth(root, 0); 
    }
}
