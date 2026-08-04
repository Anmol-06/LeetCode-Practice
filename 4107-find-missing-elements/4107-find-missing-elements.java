import java.util.*;
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> set=new HashSet<>();
        List<Integer> lst=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int n:nums){
            set.add(n);
            min=Math.min(min,n);
            max=Math.max(max,n);
        }
        for(int i=min;i<=max;i++){
            if(!set.contains(i)){
                lst.add(i);
            }
        }
        return lst;
    }
}