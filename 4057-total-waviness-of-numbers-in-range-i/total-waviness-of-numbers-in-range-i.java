class Solution {
    public int totalWaviness(int num1, int num2) {
        int waviness=0;
        for(int num=num1;num<=num2;num++){
            int temp=num;
            while(temp>=100){
                int left=(temp%1000)/100;
                int mid=(temp%100)/10;
                int right=temp%10;
                if((mid<left&&mid<right)||(mid>left&&mid>right)){
                    waviness+=1;
                }
                temp/=10;
            }
        }
        return waviness;
    }
}