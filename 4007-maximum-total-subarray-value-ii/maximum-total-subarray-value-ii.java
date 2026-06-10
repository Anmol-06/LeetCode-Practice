class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int[] logTable = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            logTable[i] = logTable[i / 2] + 1;
        }

        int[][] maxST = new int[16][n];
        int[][] minST = new int[16][n];

        for (int i = 0; i < n; i++) {
            maxST[0][i] = nums[i];
            minST[0][i] = nums[i];
        }

        for (int j = 1; j < 16; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                maxST[j][i] = Math.max(maxST[j - 1][i], maxST[j - 1][i + (1 << (j - 1))]);
                minST[j][i] = Math.min(minST[j - 1][i], minST[j - 1][i + (1 << (j - 1))]);
            }
        }

        long[] heap = new long[n + 1];
        int heapSize = n;

        for (int l = 0; l < n; l++) {
            int len = n - l;
            int g = logTable[len];
            int maxVal = Math.max(maxST[g][l], maxST[g][n - (1 << g)]);
            int minVal = Math.min(minST[g][l], minST[g][n - (1 << g)]);
            long v = (long) maxVal - minVal;
            heap[l + 1] = (v << 32) | ((long) l << 16) | (n - 1);
        }

        for (int i = heapSize / 2; i >= 1; i--) {
            int cur = i;
            while (2 * cur <= heapSize) {
                int j = 2 * cur;
                if (j + 1 <= heapSize && heap[j + 1] > heap[j]) j++;
                if (heap[cur] >= heap[j]) break;
                long temp = heap[cur];
                heap[cur] = heap[j];
                heap[j] = temp;
                cur = j;
            }
        }

        long totalValue = 0;

        for (int step = 0; step < k; step++) {
            long packed = heap[1];
            totalValue += (packed >>> 32);

            int l = (int) ((packed >>> 16) & 0xFFFF);
            int r = (int) (packed & 0xFFFF);

            if (r > l) {
                int nextR = r - 1;
                int len = nextR - l + 1;
                int g = logTable[len];
                int maxVal = Math.max(maxST[g][l], maxST[g][nextR - (1 << g) + 1]);
                int minVal = Math.min(minST[g][l], minST[g][nextR - (1 << g) + 1]);
                long nextV = (long) maxVal - minVal;
                
                heap[1] = (nextV << 32) | ((long) l << 16) | nextR;
            } else {
                heap[1] = heap[heapSize--];
            }

            int curPop = 1;
            while (2 * curPop <= heapSize) {
                int j = 2 * curPop;
                if (j + 1 <= heapSize && heap[j + 1] > heap[j]) j++;
                if (heap[curPop] >= heap[j]) break;
                long temp = heap[curPop];
                heap[curPop] = heap[j];
                heap[j] = temp;
                curPop = j;
            }
        }

        return totalValue;
    }
}