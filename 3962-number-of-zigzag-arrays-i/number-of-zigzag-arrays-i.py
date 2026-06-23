class Solution:
    def zigZagArrays(self, n: int, l: int, r: int) -> int:
        MOD = 10**9 + 7
        K = r - l + 1
        
        if n == 1:
            return K % MOD
            
        dp_up = [0] * K
        dp_down = [0] * K
        
        for j in range(K):
            dp_up[j] = j
            dp_down[j] = K - 1 - j 
            
        for i in range(3, n + 1):
            new_dp_up = [0] * K
            new_dp_down = [0] * K
            
            running_sum_down = 0
            for j in range(K):
                new_dp_up[j] = running_sum_down
                running_sum_down = (running_sum_down + dp_down[j]) % MOD
                
            running_sum_up = 0
            for j in range(K - 1, -1, -1):
                new_dp_down[j] = running_sum_up
                running_sum_up = (running_sum_up + dp_up[j]) % MOD
                
            dp_up = new_dp_up
            dp_down = new_dp_down
            
        return (sum(dp_up) + sum(dp_down)) % MOD