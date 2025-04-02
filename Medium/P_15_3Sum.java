/**
 * 15. 3Sum
 *
 * Given an integer array nums, return all unique triplets [nums[i], nums[j], nums[k]] such that:
 * - i != j, i != k, and j != k
 * - nums[i] + nums[j] + nums[k] == 0
 * - The solution set must not contain duplicate triplets.
 *
 * Approach:
 * 1. Sort the array to handle duplicates efficiently.
 * 2. Iterate through the array, fixing one number and using a two-pointer approach for the other two.
 * 3. Skip duplicate values to ensure unique triplets.
 * 4. Return the list of unique triplets.
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 *
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 *
 * Constraints:
 * - 3 <= nums.length <= 3000
 * - -10^5 <= nums[i] <= 10^5
 */
public class P_15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                }
            }
        }

        return res;
    }
}