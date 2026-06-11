import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

//Method-1
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> intersection=new ArrayList<>();
        HashMap<Integer,Boolean> hashTable=new HashMap<>();
        for(int i : nums1){
            hashTable.put(i,true);
        }
        for(int j : nums2){
            if(hashTable.containsKey(j)){
                intersection.add(j);
                hashTable.remove(j);
            }
        }
        int[] resIntersection=intersection.stream().mapToInt(Integer::intValue).toArray();
        return resIntersection;
    }
}

//Method-2
// import java.util.HashSet;
// class Solution {
//     public int[] intersection(int[] nums1, int[] nums2) {
//         HashSet<Integer> set = new HashSet<>();
//         HashSet<Integer> intersect = new HashSet<>();
//         for (int i : nums1) {
//             set.add(i);
//         }
//         for (int j : nums2) {
//             if (set.contains(j)) {
//                 intersect.add(j);
//             }
//         }
//         int[] result = new int[intersect.size()];
//         int index = 0;
//         for (int num : intersect) {
//             result[index++] = num;
//         }
//         return result;
//     }
// }

//Method-3-most fast
// import java.util.Arrays;
// class Solution {
//     public int[] intersection(int[] nums1, int[] nums2) {
//         // Since max value is 1000, we make an array of size 1001
//         boolean[] seen = new boolean[1001];
//         for (int num : nums1) {
//             seen[num] = true; // Mark the number as seen
//         }
//         // Create an array to hold the maximum possible overlapping items
//         int[] result = new int[Math.min(nums1.length, nums2.length)];
//         int index = 0;
//         for (int num : nums2) {
//             if (seen[num]) {
//                 result[index++] = num;
//                 seen[num] = false; // Set to false so we don't add it again
//             }
//         }
//         // Trim the empty spaces off the array before returning
//         return Arrays.copyOf(result, index);
//     }
// }