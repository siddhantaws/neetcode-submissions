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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l  =  new ArrayList<>();
        rightSideView(root, l , 0);
        return l;
    }

    private void rightSideView(TreeNode root, List<Integer> l , int level) {
        if(root==null)
            return ;
        if(level == l.size())
            l.add(root.val);
        if (root.right!=null)     
            rightSideView(root.right, l, level+1);
        if (root.left!=null)     
            rightSideView(root.left, l, level+1);
    }   
}
