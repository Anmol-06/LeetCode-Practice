class Solution {
    public int maxNumberOfBalloons(String text) {
        int b=0;
        int a=0;
        int l=0;
        int o=0;
        int n=0;
        for( char c:text.toCharArray()){
            if(c=='b')
                b++;
            if(c=='a')
                a++;
            if(c=='l')
                l++;
            if(c=='o')
                o++;
            if(c=='n')
                n++;
        }
        l=l/2;
        o=o/2;
        return Math.min(b,Math.min(Math.min(a,l),Math.min(o,n)));
    }
}