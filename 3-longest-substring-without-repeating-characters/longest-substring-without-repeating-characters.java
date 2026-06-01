class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        int lastIndex=0;
        int longestLen=0;
        boolean mem[]=new boolean[128];
        while(right<s.length()){
            if(!(mem[s.charAt(right)])){
                mem[(int)(s.charAt(right))]=true;
                lastIndex++;
                right++;
                longestLen=Math.max(longestLen,right-left);
            }else{
                mem[(int)(s.charAt(left))]=false;
                left++;
            }
        }
        return longestLen;
    }
}