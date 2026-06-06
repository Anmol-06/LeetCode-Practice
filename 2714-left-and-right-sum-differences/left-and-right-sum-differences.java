class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] answers = new int[nums.length];
        
        // Loop 1: Calculate total sum, but store it directly as our starting rightSum
        int rightSum = 0;
        for (int num : nums) {
            rightSum += num; 
        }
        
        int leftSum = 0;
        
        // Loop 2: Micro-optimized single-pass state updates
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i]; // Tear down the right immediately
            answers[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];  // Build up the left
        }
        
        return answers;
    }
}