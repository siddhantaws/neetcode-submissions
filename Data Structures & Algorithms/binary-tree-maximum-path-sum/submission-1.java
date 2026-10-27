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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSum1(root);
        return max;
    }
    private int maxPathSum1(TreeNode root) {
        if(root==null)
            return 0;
        int left =  Math.max(maxPathSum1(root.left), 0) ;
        int right = Math.max(maxPathSum1(root.right), 0)  ;
        max = Math.max(max, left+ right + root.val);
        return Math.max(left, right) + root.val;  
    }
    
}
