import java.util.*;
/**
 * Problem: ThreeSum(LeetCode #15)
 * Link: https://leetcode.com/problems/3sum/
 * Pattern: HashMap / Two Pointers
 * Difficulty: Medium
 * Time: O(n²) | Space: O(n)
 *
 * Approach:
 * Fix one element, find complement pair using HashSet.
 * Sort triplet before adding to deduplicate via HashSet<List>.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int nums[] = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));

    }public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> list  =  new HashSet<>();
        for(int i=0; i<nums.length; i++)
        {
            Set<Integer> set = new HashSet<>();
            for(int j = i+1; j<nums.length; j++)
            {

                int third = -nums[i]-nums[j];
                if(set.contains(third))
                {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(triplet);
                    list.add(triplet);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(list);
    }
}
