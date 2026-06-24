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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int rootDia = levels(root.left) + levels(root.right);
        int LSTdia = diameterOfBinaryTree(root.left);
        int RSTdia = diameterOfBinaryTree(root.right);
        return Math.max(rootDia,(Math.max(LSTdia,RSTdia)));
    }

    public int levels(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left),levels(root.right));
    }
}