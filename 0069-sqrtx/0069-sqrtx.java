class Solution {
    public int mySqrt(int x) {
        if(x==0)
            return 0;
        for(long i=0;i<x;i++){
            if((i*i)>x)
                return (int)i-1;
            else if((i*i)==x)
                return (int)i;
        }
        return 1;
    }   
}