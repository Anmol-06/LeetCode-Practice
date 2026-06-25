class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int c=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                if(nums[j]==target)
                    sum+=1;
                else
                    sum-=1;
                if(sum>0)
                    c++;
            }
        }
        return c;
    }
}