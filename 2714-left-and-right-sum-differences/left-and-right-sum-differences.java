class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] answers=new int[nums.length];
        int totalSum=0;
        for(int num : nums){
            totalSum+=num;
        }
        int currLeft=0;
        for(int i=0;i<nums.length;i++){
            int rightSum=totalSum-currLeft-nums[i];
            answers[i]=Math.abs(currLeft-rightSum);
            currLeft+=nums[i];
        }
        return answers;
    }
}