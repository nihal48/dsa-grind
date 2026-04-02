import java.util.HashMap;
import java.util.Map;
/**
 * Problem: SubarraySum (LeetCode #560)
 * Link: https://leetcode.com/problems/subarray-sum-equals-k/
 * Pattern: Hashmap / Prefix Sum
 * Difficulty: Medium
 * Time: O(n) | Space: O(n)
 *
 * Approach:
 * prefixSum[j] - prefixSum[i] = subarray sum from i to j-1
 * So if prefixSum[j] - k = prefixSum[i], a valid subarray exists.
 * Instead of recomputing all prefix sums, store them in a map as we go.
 * map(0:1) handles the case where the subarray starts from index 0.
 */
public class SubarraySum {
    public static void main(String[] args) {
        int[] nums = {3,1,-4,6,-3,5,-2};
        int k = 3;
        System.out.println(subarraySum(nums, k));

    }
    public static int subarraySum(int[] nums, int k){
        int sum =0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i: nums)
        {
            sum +=i;
            int ques = sum-k;
            if(map.containsKey(ques))
            {
                count = count + map.get(ques);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
    public static int subarraySum2(int[] nums, int k) {
        int count = 0;

        for(int i=0; i<nums.length; i++)
        {
            int sum=0;
            for(int j=i; j<nums.length; j++)
            {
                sum +=nums[j];
                if(sum==k)
                {
                    count++;
                }
            }
        }
        return count;
    }
}
