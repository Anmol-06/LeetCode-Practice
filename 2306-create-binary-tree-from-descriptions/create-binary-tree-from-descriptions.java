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
        // Map to store value -> actual TreeNode object
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        // Set to track every node that is a child
        Set<Integer> children = new HashSet<>();

        // Pass 1: Create nodes and build relationships
        for (int[] d : descriptions) {
            int parent = d[0];
            int child = d[1];
            int isLeft = d[2];

            // Create nodes if they don't exist yet
            nodeMap.putIfAbsent(parent, new TreeNode(parent));
            nodeMap.putIfAbsent(child, new TreeNode(child));

            // Link them
            if (isLeft == 1) {
                nodeMap.get(parent).left = nodeMap.get(child);
            } else {
                nodeMap.get(parent).right = nodeMap.get(child);
            }

            // Mark as a child
            children.add(child);
        }

        // Pass 2: Find the root (the only node in the map not in the children set)
        for (int[] d : descriptions) {
            if (!children.contains(d[0])) {
                return nodeMap.get(d[0]);
            }
        }

        return null;
    }
}