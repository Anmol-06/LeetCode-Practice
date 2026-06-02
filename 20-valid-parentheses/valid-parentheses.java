import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        Deque<Character> type=new ArrayDeque<>();
        type.push(' ');
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                stack.push(s.charAt(i));
                if(c=='('){
                    type.push(')');
                }else if(c=='{'){
                    type.push('}');
                }else{
                    type.push(']');
                }
            }else{
                if(!stack.isEmpty()&&(type.peek()==s.charAt(i))){
                    stack.pop();
                    type.pop();
                }else if(!(type.peek()==s.charAt(i))){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}