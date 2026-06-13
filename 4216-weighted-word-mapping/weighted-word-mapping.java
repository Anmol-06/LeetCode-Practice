class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String res="";
        
        for(String str : words){
            int sum=0;
            for(char ch : str.toCharArray()){
                int index=(int)ch-97;
                sum+=weights[index];
            }
            int place=(25-sum%26)+97;
            char c=(char) place;
            res+=c;
        }
        return res;
    }
}