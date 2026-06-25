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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q  = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(q.size() > 0){
            int size = q.size();
            level++;
            List<Integer> currLevel = new ArrayList<>();
            while(size-- > 0){
                TreeNode curr = q.poll();
                currLevel.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }

            if(level % 2 == 0){
                Collections.reverse(currLevel);
            }

            ans.add(currLevel);
        }
        return ans;
    }
}