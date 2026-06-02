class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minLand=Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++){
            minLand=Math.min(minLand,(landStartTime[i]+landDuration[i]));
        }
        int minWater=Integer.MAX_VALUE;
        for(int i=0;i<waterStartTime.length;i++){
            minWater=Math.min(minWater,(waterStartTime[i]+waterDuration[i]));
        }
        int landStart=0;
        int waterStart=0;
        int landTotal=Integer.MAX_VALUE;
        int waterTotal=Integer.MAX_VALUE;
        //Land then water
        for(int i=0;i<waterStartTime.length;i++){
            waterStart=Math.max(minLand,waterStartTime[i]);
            landTotal=Math.min(landTotal,waterStart+waterDuration[i]);
        }
        //Water then land
        for(int i=0;i<landStartTime.length;i++){
            landStart=Math.max(minWater,landStartTime[i]);
            waterTotal=Math.min(waterTotal,landStart+landDuration[i]);
        }
        if(waterTotal<landTotal){
            return waterTotal;
        }else{
            return landTotal;
        }
    }
}