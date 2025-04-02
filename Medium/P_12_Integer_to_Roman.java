/**
 * 12. Integer to Roman
 *
 * Convert an integer to a Roman numeral using the following rules:
 * - Append the highest possible Roman symbol and subtract its value.
 * - Use subtractive notation for values starting with 4 or 9.
 * - Only I, X, C, and M can be repeated up to 3 times.
 * - Use subtractive forms: IV (4), IX (9), XL (40), XC (90), CD (400), CM (900).
 *
 * Example 1:
 * Input: num = 3749
 * Output: "MMMDCCXLIX"
 *
 * Example 2:
 * Input: num = 58
 * Output: "LVIII"
 *
 * Example 3:
 * Input: num = 1994
 * Output: "MCMXCIV"
 *
 * Constraints:
 * - 1 <= num <= 3999
 */
public class P_12_Integer_to_Roman {
    public String intToRoman(int num) {
        String result = "";
        Stack<Integer> digits = new Stack<>();
        int ten = 1;

        while(num > 0) {
            int digit = num % 10;
            digits.push(digit * ten);
            ten = ten * 10;
            num = num / 10;
        }

        while(!digits.isEmpty()) {
            int val = digits.pop();

            if(val < 10) {
                if(val > 0 && val < 4) {
                    for(int i = 0; i < val; i++) {
                        result = result + "I";
                    }
                } else if(val == 4) {
                    result = result + "IV";
                } else if(val == 5) {
                    result = result + "V";
                } else if(val > 5 && val < 9) {
                    result = result + "V";
                    for(int i = 0; i < val - 5; i++) {
                        result = result + "I";
                    }
                } else if(val == 9) {
                    result = result + "IX";
                }
            } else if (val >= 10 && val < 100) {
                int tens = val / 10;
                if(tens > 0 && tens < 4) {
                    for(int i = 0; i < tens; i++) {
                        result = result + "X";
                    }
                } else if(tens == 4) {
                    result = result + "XL";
                } else if(tens == 5) {
                    result = result + "L";
                } else if(tens > 5 && tens < 9) {
                    result = result + "L";
                    for(int i = 0; i < tens - 5; i++) {
                        result = result + "X";
                    }
                } else if(tens == 9) {
                    result = result + "XC";
                }
            } else if (val >= 100 && val < 1000) {
                int hundreds = val / 100;
                if(hundreds > 0 && hundreds < 4) {
                    for(int i = 0; i < hundreds; i++) {
                        result = result + "C";
                    }
                } else if(hundreds == 4) {
                    result = result + "CD";
                } else if(hundreds == 5) {
                    result = result + "D";
                } else if(hundreds > 5 && hundreds < 9) {
                    result = result + "D";
                    for(int i = 0; i < hundreds - 5; i++) {
                        result = result + "C";
                    }
                } else if(hundreds == 9) {
                    result = result + "CM";
                }
            } else if (val >= 1000 && val < 4000) {
                int thousands = val / 1000;
                for(int i = 0; i < thousands; i++) {
                    result = result + "M";
                }
            }
        }

        return result;
    }
}