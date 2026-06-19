class Solution {
    public int largestAltitude(int[] gain) {
        int highest=0;
        int currHeight=0;
        for (int height: gain){
            currHeight+=height;
            highest=Math.max(highest,currHeight);
        }
        return highest;
    }
}