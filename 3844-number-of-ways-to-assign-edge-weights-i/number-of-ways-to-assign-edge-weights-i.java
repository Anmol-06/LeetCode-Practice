class Solution {
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        int maxDepth = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n + 1];
        q.add(1);
        vis[1] = true;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                for (int neighbor : adj[curr]) {
                    if (!vis[neighbor]) {
                        vis[neighbor] = true;
                        q.add(neighbor);
                    }
                }
            }
            if (!q.isEmpty()) maxDepth++;
        }
        
        long ans = 1, base = 2;
        int power = maxDepth - 1;
        
        while (power > 0) {
            if ((power & 1) == 1) ans = (ans * base) % 1000000007;
            base = (base * base) % 1000000007;
            power >>= 1;
        }
        
        return (int) ans;
    }
}