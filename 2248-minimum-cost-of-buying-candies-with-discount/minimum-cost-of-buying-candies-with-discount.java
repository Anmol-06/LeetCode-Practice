import java.util.*;
class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum=0;
        if(cost.length==1){
            return cost[0];
        }
        for(int i=cost.length-1;i>=0;i-=3){
            if(i!=0){
                sum+=cost[i]+cost[i-1];
            }else{
                sum+=cost[i];
            }
        }
        return sum;
    }
}