class Solution {
    private long[] dp(int pos, int prevPrev, int prev,
            boolean tight, boolean started,
            int[] digits, long[][][] memoSum, long[][][] memoCount, boolean[][][] visited) {

        // Base Case: We hit the end of the number. 
        // We generated 0 waviness at this exact terminal point, but completed 1 valid number path.
        if (pos == digits.length) {
            return new long[] { 0, 1 };
        }

        // Cache Read: Only read if we are loose AND we have actually started building a number.
        if (!tight && started) {
            if (visited[pos][prevPrev + 1][prev + 1]) {
                return new long[] { memoSum[pos][prevPrev + 1][prev + 1], memoCount[pos][prevPrev + 1][prev + 1] };
            }
        }

        int maxDigit = tight ? digits[pos] : 9;
        long totalWaviness = 0;
        long totalCount = 0;

        for (int d = 0; d <= maxDigit; d++) {
            int newWaviness = 0;

            // Check for Peak or Valley
            if (started && prevPrev != -1) {
                if ((prev > prevPrev && prev > d) || (prev < prevPrev && prev < d)) {
                    newWaviness = 1;
                }
            }

            boolean newTight = tight && (d == digits[pos]);

            long[] childResult;
            if (!started && d == 0) {
                // Leading zero: pass the -1 placeholders forward, we haven't started.
                childResult = dp(pos + 1, -1, -1, newTight, false, digits, memoSum, memoCount, visited);
            } else {
                // Normal placement: shift the historical digits.
                childResult = dp(pos + 1, prev, d, newTight, true, digits, memoSum, memoCount, visited);
            }

            // THE MATHEMATICAL FIX
            // Add the waviness found deeper in the tree, PLUS the current peak/valley 
            // multiplied by the number of valid suffixes that use it.
            totalWaviness += childResult[0] + (newWaviness * childResult[1]);
            totalCount += childResult[1];
        }

        // Cache Write
        if (!tight && started) {
            visited[pos][prevPrev + 1][prev + 1] = true;
            memoSum[pos][prevPrev + 1][prev + 1] = totalWaviness;
            memoCount[pos][prevPrev + 1][prev + 1] = totalCount;
        }

        return new long[] { totalWaviness, totalCount };
    }

    private long f(long n) {
        if (n <= 0)
            return 0;
        String s = Long.toString(n);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = s.charAt(i) - '0';
        }

        // Splitting into parallel arrays avoids Object allocation overhead.
        long[][][] memoSum = new long[16][11][11];
        long[][][] memoCount = new long[16][11][11];
        boolean[][][] visited = new boolean[16][11][11];

        return dp(0, -1, -1, true, false, digits, memoSum, memoCount, visited)[0];
    }

    public long totalWaviness(long num1, long num2) {
        return f(num2) - f(num1 - 1);
    }
}