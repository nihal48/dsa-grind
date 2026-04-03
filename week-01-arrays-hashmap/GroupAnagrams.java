import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/**
 * Problem: GroupAnagrams(LeetCode #49)
 * Link: https://leetcode.com/problems/group-anagrams/
 * Pattern: HashMap / String manipulation
 * Difficulty: Medium
 * Time: O(n) | Space: O(n)
 *
 * Approach:
 * sort each as key and put originals as value in map
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs)
        {
           char[] s1 = s.toCharArray();
           Arrays.sort(s1);
            String key  = String.valueOf(s1);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
