import java.util.Arrays;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;
        int[][] pegs = new int[m + 2][2];
        
        for (int i = 0; i < m; i++) {
            pegs[i] = restrictions[i];
        }
        pegs[m] = new int[]{1, 0};
        pegs[m + 1] = new int[]{n, n - 1};
        
        Arrays.sort(pegs, (a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 1; i < pegs.length; i++) {
            int distance = pegs[i][0] - pegs[i - 1][0];
            pegs[i][1] = Math.min(pegs[i][1], pegs[i - 1][1] + distance);
        }
        
        for (int i = pegs.length - 2; i >= 0; i--) {
            int distance = pegs[i + 1][0] - pegs[i][0];
            pegs[i][1] = Math.min(pegs[i][1], pegs[i + 1][1] + distance);
        }
        
        int maxHeight = 0;
        for (int i = 0; i < pegs.length - 1; i++) {
            int distance = pegs[i + 1][0] - pegs[i][0];
            int peak = (pegs[i][1] + pegs[i + 1][1] + distance) / 2;
            maxHeight = Math.max(maxHeight, peak);
        }
        
        return maxHeight;
    }
}