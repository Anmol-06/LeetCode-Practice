import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> intersection=new ArrayList<>();
        HashMap<Integer,Boolean> hashTable=new HashMap<>();
        for(int i : nums1){
            hashTable.put(i,true);
        }
        for(int j : nums2){
            if(hashTable.containsKey(j)&&!intersection.contains(j))
                intersection.add(j);
        }

        int[] resIntersection=intersection.stream().mapToInt(Integer::intValue).toArray();
        return resIntersection;
    }
}