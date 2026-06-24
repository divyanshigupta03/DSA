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
    static boolean flag;
    public boolean isBalanced(TreeNode root) {
        flag = true;
        if(root == null){
            return true;
        }
        levels(root);
        return flag;
    }

    public int levels(TreeNode root){
        if(root == null) return 0;
        int left = levels(root.left);
        int right = levels(root.right);
        if(Math.abs(left-right) > 1) flag = false;
        return 1 + Math.max(left,right);
    }
}