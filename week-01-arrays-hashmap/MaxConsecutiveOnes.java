import java.util.LinkedList;
import java.util.Queue;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums ={1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums,k));
    }
    public static int longestOnes(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int left = 0;
        int maxLen = 0;

        for(int right=0; right < nums.length; right++)
        {
            if(nums[right] == 0)
            {
                queue.add(right);
            }
            if(queue.size()>k)
            {
                Integer lastZeroIndex = queue.poll();
                left = lastZeroIndex + 1;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }

}
