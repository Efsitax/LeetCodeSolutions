/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3. Notice that the answer must be
 * a substring, "pwke" is a subsequence and not a substring.
 */
import java.util.HashSet;

public class P_3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int longestLength = 0;
        int left = 0;
        HashSet<Character> seen = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {

            while (seen.contains(s.charAt(right))) {

                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(s.charAt(right));
            longestLength = Math.max(longestLength, right - left + 1);
        }

        return longestLength;
    }
}
