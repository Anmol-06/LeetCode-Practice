import java.util.*;
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> lst=new ArrayList<>();
        for(int i=nums[0];i<=nums[nums.length-1];i++){
            boolean found = false;
            for(int n:nums){
                if(n==i){
                    found=true;
                }
            }
            if(!found){
                lst.add(i);
            }
        }
        return lst;
    }
}