class Solution {
    public String processStr(String s) {
        StringBuffer sb=new StringBuffer("");
        for(int i=0;i<s.length();i++){
            switch(s.charAt(i)){
                case '*':
                    if(sb.toString().length()!=0)
                        sb.deleteCharAt(sb.toString().length()-1);
                    break;
                case '#':
                    sb.append(sb.toString());
                    break;
                case '%':
                    sb.reverse();
                    break;
                default:
                    sb.append(s.charAt(i));
                    break;
            }
        }
        return sb.toString();
    }
}