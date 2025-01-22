/**
 * 13. Roman to Integer
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D, and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * For example:
 * - 2 is written as II (1 + 1).
 * - 12 is written as XII (10 + 1 + 1).
 * - 27 is written as XXVII (10 + 10 + 5 + 1 + 1).
 *
 * Roman numerals are generally written largest to smallest from left to right.
 * However, some exceptions involve subtraction:
 * - I before V (5) or X (10) makes 4 or 9.
 * - X before L (50) or C (100) makes 40 or 90.
 * - C before D (500) or M (1000) makes 400 or 900.
 *
 * Given a Roman numeral, convert it to an integer.
 *
 * Examples:
 *
 * Example 1:
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 *
 * Example 2:
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V = 5, III = 3.
 *
 * Example 3:
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90, IV = 4.
 */
import java.util.HashMap;

public class P_13_RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> roman = new HashMap<Character, Integer>();

        roman.put('I',1);
        roman.put('V',5);
        roman.put('X',10);
        roman.put('L',50);
        roman.put('C',100);
        roman.put('D',500);
        roman.put('M',1000);

        int res = 0;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(i>0 && roman.get(ch) > roman.get(s.charAt(i-1)))
            {
                res += roman.get(ch) - 2*roman.get(s.charAt(i-1));
            }
            else
                res += roman.get(ch);
        }
        return res;
    }
}
