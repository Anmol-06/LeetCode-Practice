class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1||numRows>=s.length())
            return s;

        StringBuilder[] rows=new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            rows[i]=new StringBuilder();
        }

        int currRow=0;
        int direction=1;
        for(char c:s.toCharArray()){
            rows[currRow].append(c);
            if(currRow==0)
                direction=1;
            else if(currRow==numRows-1)
                direction=-1;
            currRow+=direction;
        }

        StringBuilder res=new StringBuilder();
        for(StringBuilder row:rows){
            res.append(row);
        }
        return res.toString();
    }
}