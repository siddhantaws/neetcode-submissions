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
    public boolean isValidBST(TreeNode root) {
        if (root ==null || (root.left==null && root.right==null ))
            return true;
        return isBST(root, null,null);
    }

    private boolean isBST(TreeNode root , Integer left, Integer right) {
        if (root == null)
            return true;
        if (left!=null && root.val >=left) 
            return false;
        if (right!=null && right >= root.val) 
            return false;
        return   isBST(root.left, root.val, right) &&   isBST(root.right, left, root.val);   
    } 
}
