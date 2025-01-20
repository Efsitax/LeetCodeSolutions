import java.util.Stack;

public class ValidParantheses_20 {
    public boolean isValid(String s) {
        Stack<Character> open = new Stack<>();

        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                open.push(c);
            }
            else if (open.isEmpty()){
                return false;
            }
            else{
                char op = open.pop();
                if(op == '{' && c == '}') {
                    continue;
                }
                else if(op == '[' && c ==']'){
                    continue;
                }
                else if(op == '(' && c ==')'){
                    continue;
                }
                else return false;
            }
        }
        if(!open.isEmpty()) return false;
        else return true;
    }
}
