import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
// class Solution {
//     public int[] intersection(int[] nums1, int[] nums2) {
//         ArrayList<Integer> intersection=new ArrayList<>();
//         HashMap<Integer,Boolean> hashTable=new HashMap<>();
//         for(int i : nums1){
//             hashTable.put(i,true);
//         }
//         for(int j : nums2){
//             if(hashTable.containsKey(j)){
//                 intersection.add(j);
//                 hashTable.remove(j);
//             }
//         }
//         int[] resIntersection=intersection.stream().mapToInt(Integer::intValue).toArray();
//         return resIntersection;
//     }
// }

import java.util.HashSet;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersect = new HashSet<>();
        
        // Add all of nums1 to a Set
        for (int i : nums1) {
            set.add(i);
        }
        
        // If the number is in our first set, add it to our intersect set
        for (int j : nums2) {
            if (set.contains(j)) {
                intersect.add(j);
            }
        }
        
        // Manually convert to array (Much faster than Streams!)
        int[] result = new int[intersect.size()];
        int index = 0;
        for (int num : intersect) {
            result[index++] = num;
        }
        
        return result;
    }
}