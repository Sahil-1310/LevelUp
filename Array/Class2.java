import java.util.*;
public class Cls_2 {

    // 3. Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), si = 0, ei = 0, count = 0, len = 0;
        int[] nums = new int[128];

        while (ei < n) {
            if (nums[s.charAt(ei)] > 0)
                count++;
            nums[s.charAt(ei)]++;
            ei++;

            while (count > 0) {
                if (nums[s.charAt(si)] == 1)
                    count--;
                nums[s.charAt(si)]--;
                si++;
            }
            len = Math.max(len, ei - si);
        }
        return len;
    }

    // Longest Substring with At Most Two Distinct Characters
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length(), si = 0, ei = 0, count = 0, len = 0;
        int[] nums = new int[128];

        while (ei < n) {
            if (nums[s.charAt(ei)] == 0)
                count++;
            nums[s.charAt(ei)]++;
            ei++;

            while (count > 2) {
                if (nums[s.charAt(si)] > 1)
                    count--;
                nums[s.charAt(si)]--;
                si++;
            }
            len = Math.max(len, ei - si);
        }
        return len;
    }

    // 386 Longest Substring with At Most K Distinct Characters
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length(), si = 0, ei = 0, count = 0, len = 0;
        int[] nums = new int[128];

        while (ei < n) {
            if (nums[s.charAt(ei)] == 0)
                count++;
            nums[s.charAt(ei)]++;
            ei++;

            while (count > 2) {
                if (nums[s.charAt(si)] == 1)
                    count--;
                nums[s.charAt(si)]--;
                si++;
            }
            len = Math.max(len, ei - si);
        }
        return len;
    }

    public static void main(String[] args) {

    }
}