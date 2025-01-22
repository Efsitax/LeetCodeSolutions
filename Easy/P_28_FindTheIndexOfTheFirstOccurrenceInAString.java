/**
 * 28. Find the Index of the First Occurrence in a String
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle
 * in haystack, or -1 if needle is not part of haystack.
 *
 * Examples:
 *
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6. The first occurrence is at index 0, so we return 0.
 *
 * Example 2:
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */
public class P_28_FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        int r = -1;
        char[] haystackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        char first = needleChar[0];
        if(needleChar.length > haystackChar.length) return -1;
        for(int i = 0; i < haystackChar.length; i++){
            if(haystackChar[i] == first){
                r = i;
                if(needleChar.length>(haystackChar.length - i)) return -1;
                else {
                    for(int j = 1; j < needleChar.length; j++){
                        if(haystackChar[i+j] == needleChar[j]) continue;
                        else {
                            r = -1;
                            break;
                        }
                    }
                }
            }
            if(r != -1) break;
        }
        return r;
    }
}
