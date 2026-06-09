class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max=Integer.MIN_VALUE;
        long min=Integer.MAX_VALUE;
        for(int num:nums){
            max=(long)Math.max(max,num);
            min=(long)Math.min(min,num);
        }
        return (long)k*(max-min);
    }
}