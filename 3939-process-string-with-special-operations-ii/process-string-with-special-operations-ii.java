class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] sizes = new long[n];
        
        // Step 1: Forward pass to track exact lengths at each operation
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            long prevSize = (i == 0) ? 0 : sizes[i - 1];
            
            if (c == '*') {
                sizes[i] = Math.max(0, prevSize - 1);
            } else if (c == '#') {
                sizes[i] = prevSize * 2;
            } else if (c == '%') {
                sizes[i] = prevSize;
            } else {
                sizes[i] = prevSize + 1;
            }
        }
        
        // Step 2: Check 0-indexed bounds against the final string length
        if (k < 0 || k >= sizes[n - 1]) {
            return '.';
        }
        
        // Step 3: Backward pass to trace where index 'k' originated
        long currK = k;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            long prevSize = (i == 0) ? 0 : sizes[i - 1];
            
            if (c == '*') {
                // The deleted char was at the end. currK was valid, so it maps directly back.
                continue;
            } else if (c == '#') {
                // If currK is in the duplicated second half, shift it back to the first half
                if (currK >= prevSize) {
                    currK -= prevSize;
                }
            } else if (c == '%') {
                // String was reversed, so flip the target index
                currK = prevSize - 1 - currK;
            } else {
                // It's a standard character addition
                if (currK == prevSize) {
                    return c; // We found exactly where the character was added!
                }
                // Otherwise, currK belongs to the previous state, continue tracing backwards.
            }
        }
        
        return '.';
    }
}