class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] leftSum=new int[nums.length];
        int[] rightSum=new int[nums.length];
        int[] answers=new int[nums.length];
        leftSum[0]=0;
        rightSum[nums.length-1]=0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                leftSum[i]+=nums[j];
            }
            for(int k=nums.length-1;k>i;k--){
                rightSum[i]+=nums[k];
            }
            answers[i]=Math.abs(leftSum[i]-rightSum[i]);
        }
        return answers;
    }
}