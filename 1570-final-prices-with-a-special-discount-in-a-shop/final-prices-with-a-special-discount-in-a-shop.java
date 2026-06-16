class Solution {
    public int[] finalPrices(int[] prices) {
        int len=prices.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (prices[j] <= prices[i]) {
                    ans[i] = prices[i] - prices[j];
                    break;
                }else{
                    ans[i]=prices[i];
                }
            }
            ans[len-1]=prices[len-1];
        }
        return ans;
    }
}