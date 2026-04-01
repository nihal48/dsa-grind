/**
 * Problem: Pivot Index (LeetCode #2)
 * Link: https://leetcode.com/problems/find-pivot-index/
 * Pattern: Array / Prefix Sum
 * Difficulty: Easy
 * Time: O(n) | Space: O(n)
 *
 * Approach:
 * check prefix sum and suffix sum if both are equal
 */
public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }
    public static int pivotIndex(int[] nums) {
        int left=0;
        int sumArr=0;
        int right=0;
        for(int i: nums)
        {
            sumArr +=i;
        }
        for(int i = 0; i< nums.length;i++)
        {
            right = sumArr - nums[i] - left;
            if(left==right)
            {
                return i;
            }
            left +=nums[i-1];
        }
        return -1;
    }
}
