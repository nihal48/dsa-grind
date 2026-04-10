import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = " ";
        System.out.println(s.length());
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        int maxCount = 1;
        if(s.isEmpty()) return 0;
        Set<Character> set = new LinkedHashSet<>();
        set.add(s.charAt(0));
        for(int i=1; i<s.length(); i++)
        {
            int j = i;
            while( j!= s.length() && set.contains(s.charAt(i)))
            {

                set.clear();
                j++;
            }
            set.add(s.charAt(i));
            maxCount = Math.max(set.size(), maxCount);
        }
        return maxCount;
    }
}
