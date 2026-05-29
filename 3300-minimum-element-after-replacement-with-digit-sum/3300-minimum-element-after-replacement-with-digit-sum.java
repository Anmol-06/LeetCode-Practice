class Solution {
    public int minElement(int[] nums) {
        int newNums[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int sum=0;
            while(nums[i]!=0){
                sum+=nums[i]%10;
                nums[i]=nums[i]/10;
            }
            newNums[i]=sum;
        }
        int smallest=newNums[0];
        for(int i=1;i<newNums.length;i++){
            if(smallest>newNums[i]){
                smallest=newNums[i];
            }
        }
        return smallest;
    }
}