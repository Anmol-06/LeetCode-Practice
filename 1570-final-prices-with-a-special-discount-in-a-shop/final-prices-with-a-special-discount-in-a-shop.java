class Solution {
    public int[] finalPrices(int[] prices) {
        int len=prices.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i]=prices[i];
            for (int j = i + 1; j < len; j++) {
                if (prices[j] <= prices[i]) {
                    ans[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return ans;
    }
}