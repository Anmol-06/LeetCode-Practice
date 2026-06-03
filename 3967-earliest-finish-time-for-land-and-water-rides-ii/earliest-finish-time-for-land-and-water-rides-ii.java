class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        //Land FIRST
        int minLandFinish=Integer.MAX_VALUE;
        int minLandToWater=Integer.MAX_VALUE;
        for(int i=0;i<landStartTime.length;i++){
            minLandFinish=Math.min(minLandFinish,(landStartTime[i]+landDuration[i]));
        }
        int boardingWater=Integer.MIN_VALUE;
        for(int i=0;i<waterStartTime.length;i++){
            boardingWater=Math.max(waterStartTime[i],minLandFinish);
            minLandToWater=Math.min(minLandToWater,boardingWater+waterDuration[i]);
        }
        //Water FIRST
        int minWaterFinish=Integer.MAX_VALUE;
        int minWaterToLand=Integer.MAX_VALUE;
        for(int i=0;i<waterStartTime.length;i++){
            minWaterFinish=Math.min(minWaterFinish,(waterStartTime[i]+waterDuration[i]));
        }
        int boardingLand=Integer.MIN_VALUE;
        for(int i=0;i<landStartTime.length;i++){
            boardingLand=Math.max(landStartTime[i],minWaterFinish);
            minWaterToLand=Math.min(minWaterToLand,boardingLand+landDuration[i]);
        }
        //compare min of water first and land first
        return Math.min(minWaterToLand,minLandToWater);
    }
}