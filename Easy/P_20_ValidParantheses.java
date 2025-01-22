/**
 * 20. Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 * - Open brackets must be closed by the same type of brackets.
 * - Open brackets must be closed in the correct order.
 * - Every close bracket has a corresponding open bracket of the same type.
 *
 * Examples:
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Example 4:
 * Input: s = "([])"
 * Output: true
 */
import java.util.Stack;

public class P_20_ValidParantheses {
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
