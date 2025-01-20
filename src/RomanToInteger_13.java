import java.util.HashMap;

public class RomanToInteger_13 {
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
