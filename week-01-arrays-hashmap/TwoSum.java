/**
 * Problem: Two Sum (LeetCode #1)
 * Link: https://leetcode.com/problems/two-sum/
 * Pattern: HashMap / Frequency Map
 * Difficulty: Easy
 * Time: O(n) | Space: O(n)
 *
 * Approach:
 * Store complement in map as you iterate.
 * If current number exists in map → found the pair.
 */
public class TwoSum {
    //nums = [2,7,11,15], target = 9
    //Output: [0,1]

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++ )
        {
            if(map.containsKey(target- nums[i] ))
            {
                ans[1]=i;
                ans[0] = map.get(target-nums[i]);

            }
            else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}
