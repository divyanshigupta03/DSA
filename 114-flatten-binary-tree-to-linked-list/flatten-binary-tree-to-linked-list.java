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
    public void flatten(TreeNode root) {
        List<TreeNode> arr = new ArrayList<>();
        dfs(root,arr);
        for(int i=1; i<arr.size(); i++){
            root.right = arr.get(i);
            root.left = null;
            root = root.right;
        }

    }

    public void dfs(TreeNode root, List<TreeNode> arr){
        if(root == null) return;

        arr.add(root);
        dfs(root.left , arr);
        dfs(root.right, arr);
    }
}