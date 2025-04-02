/**
 * 11. Container With Most Water
 *
 * Given an integer array height of length n, find two lines that together
 * with the x-axis form a container that contains the most water.
 *
 * The container cannot be slanted.
 *
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The lines at indices 1 and 8 form a container with an area of 49.
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 *
 * Constraints:
 * - n >= 2
 * - 1 <= height[i] <= 10^4
 */
public class P_11_Container_With_Most_Water {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
