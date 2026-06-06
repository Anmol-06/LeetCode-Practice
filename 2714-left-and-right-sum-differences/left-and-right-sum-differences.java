class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] leftSum=new int[nums.length];
        int[] rightSum=new int[nums.length];
        int[] answers=new int[nums.length];
        int totalSum=0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }
        leftSum[0]=0;
        rightSum[nums.length-1]=0;
        for(int i=1;i<nums.length;i++){
            leftSum[i]=leftSum[i-1]+nums[i-1];
            rightSum[i-1]=totalSum-leftSum[i-1]-nums[i-1];
            answers[i-1]=Math.abs(leftSum[i-1]-rightSum[i-1]);
        }
        answers[nums.length-1]=Math.abs(leftSum[nums.length-1]-0);
        return answers;
    }
}