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
    private void inOrder(TreeNode root, ArrayList<Integer> result){
        if(root.left!=null){
            inOrder(root.left,result);
        }
        result.add(root.val);
        if(root.right!=null){
            inOrder(root.right,result);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> result=new ArrayList<>();
        inOrder(root,result);
        return result.get(k-1);
    }
}