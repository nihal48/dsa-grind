import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * Problem: Product of Array Except Self (LeetCode #238)
 * Link: https://leetcode.com/problems/product-of-array-except-self/
 * Pattern: Array / Prefix Sum
 * Difficulty: Easy
 * Time: O(n) | Space: O(n)
 *
 * Approach:
 * check prefix product and suffix product multiply both
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        productExceptSelf(nums);
    }
    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0]=1;
        right[nums.length-1]=1;

        for(int i=1; i< nums.length; i++)
        {
            left[i] = nums[i-1]*left[i-1];
        }
        for(int i= nums.length-2; i>=0; i--)
        {
            right[i]= right[i+1]*nums[i+1];
        }
        for(int j=0; j< nums.length; j++)
        {
            nums[j]=left[j]* right[j];
        }
        return nums;
    }
    public static int[] productExceptSelf2(int[] nums)
    {
        int[] result = new int[nums.length];

        // left pass — result mein store karo
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }

        // right pass — variable se multiply karo
        int right = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right *= nums[i+1];
            result[i] *= right;
        }

        return result;
    }
}
