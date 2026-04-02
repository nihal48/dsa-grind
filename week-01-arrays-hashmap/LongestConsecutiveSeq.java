import java.util.*;
/**
 * Problem: LongestConsecutiveSeqence (LeetCode #128)
 * Link: https://leetcode.com/problems/subarray-sum-equals-k/
 * Pattern: HashSet
 * Difficulty: Medium
 * Time: O(n) | Space: O(n)
 *
 * Approach:
 * Only start counting from sequence beginning (num-1 not in set).
 * This ensures each sequence is traversed exactly once → O(n).
 */
public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));

    }
    public static int longestConsecutive(int[] nums)
    {
        Set<Integer> set = new HashSet<>(
                Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)));

        int maxCount = 0;
        for(int i: nums)
        {
            if(!set.contains(i-1))
            {
                int count = 1;
                while(set.contains(i+count))
                {
                    count++;
                }
                maxCount = Math.max(count,maxCount);
            }
        }
        return maxCount;
    }
    public static int longestConsecutiveOnlogn(int[] nums) {
        Set<Integer> set  = new TreeSet<>(); //sorting takes nlogn
        int count=1;
        int maxCount = 0;
        for(int i: nums)
        {
            set.add(i);
        }
        for(int j: set)
        {
            if(set.contains(j+1))
            {
                count++;
            }
            else {
                maxCount = Math.max(count,maxCount);
                count =1;
            }
        }
        return maxCount;
    }
}
