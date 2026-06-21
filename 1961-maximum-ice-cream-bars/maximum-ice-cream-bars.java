class Solution {
    public int maxIceCream(int[] costs, int coins) {
        // Find the maximum cost to size the frequency array precisely
        int maxCost = 0;
        for (int cost : costs) {
            if (cost > maxCost) {
                maxCost = cost;
            }
        }

        // Create the frequency array (Counting Sort core logic)
        int[] count = new int[maxCost + 1];
        for (int cost : costs) {
            count[cost]++;
        }

        int iceCreams = 0;
        
        // Iterate from cheapest (1) up to the max cost
        for (int cost = 1; cost <= maxCost; cost++) {
            if (count[cost] == 0) continue;
            
            // If we can't afford even one of the current cheapest, we are entirely out of buying power
            if (coins < cost) break;

            // Calculate exactly how many we can afford at this price point
            // It's the smaller of: total available at this price, or what our wallet allows
            int buy = Math.min(count[cost], coins / cost);
            
            iceCreams += buy;
            coins -= buy * cost;
        }

        return iceCreams;
    }
}