class Solution:
    def countMajoritySubarrays(self, nums: List[int], target: int) -> int:
        # Constraints: N is up to 10^5. 
        # The prefix sum can range from -100,000 (all non-targets) to +100,000 (all targets).
        # We use an array of size 200005 to safely store all possible frequencies.
        # We shift all indices by an offset of 100,000 to prevent negative array indexing.
        offset = 100000
        freq = [0] * 200005
        
        # Base case: Before processing any numbers, we have seen a prefix sum of 0 exactly once.
        freq[offset] = 1 
        
        curr_sum = 0
        smaller_count = 0  # Tracks how many previous prefix sums are strictly LESS than curr_sum
        total_subarrays = 0
        
        for num in nums:
            if num == target:
                # Target found (+1). The sum will increase.
                # Every prefix sum that was EXACTLY equal to the old curr_sum 
                # is now strictly less than the NEW curr_sum.
                smaller_count += freq[curr_sum + offset]
                curr_sum += 1
            else:
                # Non-target found (-1). The sum will decrease.
                # Every prefix sum that is EXACTLY equal to the NEW curr_sum 
                # is no longer strictly less than it; they are now equal.
                curr_sum -= 1
                smaller_count -= freq[curr_sum + offset]
            
            # Add the number of valid starting points (i) for our current ending point (j)
            total_subarrays += smaller_count
            
            # Record the current prefix sum in our frequency map
            freq[curr_sum + offset] += 1
            
        return total_subarrays