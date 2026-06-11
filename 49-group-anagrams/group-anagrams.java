import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hm=new HashMap<>();
        List<List<String>> result=new ArrayList<>();
        
        for(String str : strs){
            List<String> lst=new ArrayList<>();
            char[] chArr=str.toCharArray();
            Arrays.sort(chArr);
            String s=new String(chArr);
            if(hm.containsKey(s)){
                hm.get(s).add(str);
            }else{
                lst.add(str);
                hm.put(s,lst);
            }
        }

        for(String key : hm.keySet()){
            result.add(hm.get(key));
        }
        
        return result;
    }
}