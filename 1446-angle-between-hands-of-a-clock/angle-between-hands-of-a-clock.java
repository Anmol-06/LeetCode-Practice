class Solution {
    public double angleClock(int hour, int minutes) {
        double nexthour=(double)hour+1;
        double mins=(double)minutes;
        if(hour==12)
            nexthour=1;
        double angle=Math.abs((30-(mins/60)*30)+(mins-(nexthour*5))*6);
        double other_angle=Math.abs(360-angle);
        return Math.min(angle,other_angle);
    }
}