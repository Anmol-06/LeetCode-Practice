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
    public TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode[] map = new TreeNode[100001];
        boolean[] isChild = new boolean[100001];
        for (int[] d : descriptions) {
            int parent = d[0];
            int child = d[1];
            int isLeft = d[2];
            if (map[parent] == null) map[parent] = new TreeNode(parent);
            if (map[child] == null) map[child] = new TreeNode(child);
            if (isLeft == 1) {
                map[parent].left = map[child];
            } else {
                map[parent].right = map[child];
            }
            isChild[child] = true;
        }
        for (int[] d : descriptions) {
            if (!isChild[d[0]]) {
                return map[d[0]];
            }
        }
        return null;
    }
}