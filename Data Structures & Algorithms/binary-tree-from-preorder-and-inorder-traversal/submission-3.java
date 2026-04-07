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
    int[] preorder;
    int[] inorder;

    private int findArrayIndex(int val, int[] array){
        for (int i = 0; i < array.length; i++){
            if (array[i] == val){
                return i;
            }
        }
        throw new RuntimeException("Couldn't find val in array: " + val); 
    }

    private TreeNode buildTreeRecursive(int indexInitialPre, int indexFinalPre, int indexInitialIn, int indexFinalIn){
        if (indexInitialPre == indexFinalPre || indexInitialIn == indexFinalIn){
            return null; 
        }
        TreeNode root = new TreeNode(preorder[indexInitialPre]); 
        int indexRootIn = findArrayIndex(root.val, inorder);
        boolean hasRightTree = indexRootIn < indexFinalIn - 1; 
        boolean hasLeftTree = indexRootIn > indexInitialIn; 
        int sizeLeftTree = indexRootIn - indexInitialIn;
        if (hasLeftTree){
            root.left = buildTreeRecursive(indexInitialPre + 1, sizeLeftTree + indexInitialPre + 1, indexInitialIn,indexRootIn);
        }
        if (hasRightTree){
            int sizeRightTree = indexFinalIn - (indexRootIn + 1);
            root.right = buildTreeRecursive(indexInitialPre + sizeLeftTree + 1, indexFinalPre, indexRootIn + 1, indexFinalIn);
        }
        return root; 
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder; 
        return buildTreeRecursive(0, preorder.length, 0, inorder.length);
    }
}
