class Solution {
    public boolean isPalindrome(int x) {
        int rev=0,num=x;
        if(x<0){
            return false;
        }
        while(num!=0){
            int d=num%10;
            rev=rev*10+d;
            num/=10;
        }
        if(rev==x){
            return true;
        }else{
            return false;
        }
    }
}