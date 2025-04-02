/**
 * 8. String to Integer (atoi)
 *
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
 *
 * Algorithm:
 * 1. Ignore leading whitespaces.
 * 2. Determine the sign ('+' or '-'), default is positive.
 * 3. Read and convert digits until a non-digit character is encountered.
 * 4. Clamp the result within the 32-bit integer range [-2^31, 2^31 - 1].
 * 5. Return the final integer.
 *
 * Example 1:
 * Input: s = "42"
 * Output: 42
 *
 * Example 2:
 * Input: s = "   -042"
 * Output: -42
 *
 * Example 3:
 * Input: s = "1337c0d3"
 * Output: 1337
 *
 * Example 4:
 * Input: s = "0-1"
 * Output: 0
 *
 * Example 5:
 * Input: s = "words and 987"
 * Output: 0
 *
 * Constraints:
 * - 0 <= s.length <= 200
 * - s consists of English letters, digits (0-9), spaces, '+', '-', and '.'.
 */
public class P_8_String_to_Integer_atoi {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        long num = 0;
        boolean isNegative = false;

        while (i < n && s.charAt(i) == ' ') i++;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') isNegative = true;
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');
            if (!isNegative && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (isNegative && -num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }

        return isNegative ? (int) -num : (int) num;
    }
}
