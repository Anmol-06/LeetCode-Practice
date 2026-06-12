import java.util.*;

class Solution {
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        int MOD = 1000000007;
        int LOG = 20; // 2^20 is > 10^5
        
        // 1. Build Adjacency List
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        
        // 2. Binary Lifting Table and Depths
        int[][] up = new int[n + 1][LOG];
        int[] depth = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        
        // BFS to prevent StackOverflowError on deep unbalanced trees
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            
            // Populate the binary lifting table for the current node
            for (int i = 1; i < LOG; i++) {
                if (up[node][i - 1] != 0) {
                    up[node][i] = up[up[node][i - 1]][i - 1];
                } else {
                    break;
                }
            }
            
            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    depth[neighbor] = depth[node] + 1;
                    up[neighbor][0] = node; // 2^0 ancestor is the direct parent
                    q.add(neighbor);
                }
            }
        }
        
        // 3. Process Queries
        int[] ans = new int[queries.length];
        for (int qIdx = 0; qIdx < queries.length; qIdx++) {
            int u = queries[qIdx][0];
            int v = queries[qIdx][1];
            
            if (u == v) {
                ans[qIdx] = 0;
                continue;
            }
            
            int lca = getLCA(u, v, depth, up, LOG);
            int dist = depth[u] + depth[v] - 2 * depth[lca];
            
            // Combinatorics: 2^(dist - 1) % MOD
            ans[qIdx] = fastPower(2, dist - 1, MOD);
        }
        
        return ans;
    }
    
    // Lowest Common Ancestor Helper
    private int getLCA(int u, int v, int[] depth, int[][] up, int LOG) {
        if (depth[u] < depth[v]) {
            int temp = u; u = v; v = temp;
        }
        
        // Equalize depths
        int diff = depth[u] - depth[v];
        for (int i = 0; i < LOG; i++) {
            if (((diff >> i) & 1) == 1) {
                u = up[u][i];
            }
        }
        
        if (u == v) return u;
        
        // Jump upward together
        for (int i = LOG - 1; i >= 0; i--) {
            if (up[u][i] != up[v][i]) {
                u = up[u][i];
                v = up[v][i];
            }
        }
        
        return up[u][0]; // Parent of u is the LCA
    }
    
    // Fast Modular Exponentiation Helper
    private int fastPower(long base, int exp, int mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp % 2) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return (int) res;
    }
}