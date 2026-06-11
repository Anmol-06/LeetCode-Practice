import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int[] res=new int[2];
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i])){
                return new int[]{hm.get(target-nums[i]),i};
                // res[0]=hm.get(target-nums[i]);
                // res[1]=i;
            }else{
                hm.put(nums[i],i);
            }
        }
        return new int[0];
        // return res;
    }
}