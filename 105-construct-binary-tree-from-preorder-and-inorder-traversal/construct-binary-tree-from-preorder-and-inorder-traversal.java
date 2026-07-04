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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return build(0,n-1,0,n-1,preorder,inorder);
    }

    public TreeNode build(int preLow, int preHigh, int iLow, int iHigh, int[] preorder, int[] inorder){
        if (preLow > preHigh) return null;
        int val = preorder[preLow];
        int r = -1;
        TreeNode root = new TreeNode(val);
        for(int i = iLow; i<=iHigh; i++){
            if(inorder[i] == val){
                r = i;
                break;
            }
        }

        int cnt = r - iLow;
        root.left = build(preLow+1, preLow+cnt, iLow , r-1, preorder, inorder);
        root.right = build(preLow+cnt+1, preHigh, r+1 , iHigh, preorder, inorder);
        return root;
    }
}