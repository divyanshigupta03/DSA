/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p.val == root.val || q.val == root.val) return root;
        if(isExists(root.left, p.val) && isExists(root.right, q.val) || isExists(root.left, q.val) && isExists(root.right, p.val)) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if(left != null) return left;
        return lowestCommonAncestor(root.right, p, q);
    }


    public boolean isExists(TreeNode root, int p){
        if(root == null) return false;
        if(p == root.val) return true;
        return isExists(root.left,p) || isExists(root.right,p);
    }
}