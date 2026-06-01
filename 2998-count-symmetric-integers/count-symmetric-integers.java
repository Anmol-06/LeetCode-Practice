class Solution {
    public int sumOfDigits(int n){
        int sum=0;
        while(n!=0){
            int d=n%10;
            sum+=d;
            n/=10;
        }
        return sum;
    }
    public int countSymmetricIntegers(int low, int high) {
        int c=0;
        for(int n=low;n<=high;n++){
            String num=String.valueOf(n);
            if(num.length()%2==0){
                String First=num.substring(0,num.length()/2);
                String Second=num.substring(num.length()/2,num.length());
                if(sumOfDigits(Integer.parseInt(First))==sumOfDigits(Integer.parseInt(Second))){
                    c++;
                }
            }
        }
        return c;
    }
}