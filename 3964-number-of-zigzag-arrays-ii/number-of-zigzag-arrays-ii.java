class Solution {
    private static final int MOD = 1000000007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        // Edge case: length 1 can be any number in the range, no direction needed.
        if (n == 1) return m;

        int size = 2 * m;
        long[][] T = new long[size][size];

        // 1. Build the Transition Matrix T
        // State encoding: 2*i represents UP, 2*i + 1 represents DOWN
        for (int u = 0; u < m; u++) {
            for (int v = 0; v < m; v++) {
                if (v > u) {
                    // v > u is an UP move. It MUST follow a DOWN move at u.
                    // T[next_state][prev_state] = 1
                    T[2 * v][2 * u + 1] = 1; 
                } else if (v < u) {
                    // v < u is a DOWN move. It MUST follow an UP move at u.
                    T[2 * v + 1][2 * u] = 1;
                }
            }
        }

        // 2. Fast-forward the matrix to the power of (n - 2)
        // We use n - 2 because n=2 is our base vector V1.
        long[][] Tn_minus_2 = matrixPower(T, n - 2, size);

        // 3. Build the Initial Vector V1 (representing exactly n = 2)
        long[] V1 = new long[size];
        for (int i = 0; i < m; i++) {
            V1[2 * i] = i;                 // Number of valid 'u' where u < i (UP)
            V1[2 * i + 1] = (m - 1) - i;   // Number of valid 'u' where u > i (DOWN)
        }

        // 4. Multiply Tn_minus_2 by V1 to get the final state counts Vn
        long[] Vn = new long[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Vn[i] = (Vn[i] + Tn_minus_2[i][j] * V1[j]) % MOD;
            }
        }

        // 5. Sum all valid configurations in Vn
        long total = 0;
        for (int i = 0; i < size; i++) {
            total = (total + Vn[i]) % MOD;
        }

        return (int) total;
    }

    // Standard Binary Exponentiation for Matrices
    private long[][] matrixPower(long[][] base, int exp, int size) {
        long[][] res = new long[size][size];
        for (int i = 0; i < size; i++) res[i][i] = 1; // Identity matrix

        long[][] x = base;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = multiply(res, x, size);
            }
            x = multiply(x, x, size);
            exp /= 2;
        }
        return res;
    }

    private long[][] multiply(long[][] A, long[][] B, int size) {
        long[][] C = new long[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (A[i][k] == 0) continue; // Skip zero multipliers to save time
                for (int j = 0; j < size; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }
}