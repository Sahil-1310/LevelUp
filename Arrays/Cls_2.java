package Arrays;

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

            while (count > k) {
                if (nums[s.charAt(si)] == 1)
                    count--;
                nums[s.charAt(si)]--;
                si++;
            }
            len = Math.max(len, ei - si);
        }
        return len;
    }

    //..973. K Closest Points to Origin T.c O(K+N+2log(n))
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b)->{
            return -(a[0]*a[0]+a[1]*a[1])+(b[0]*b[0]+b[1]*b[1]);
        });
        for(int[] nums: points) {
            pq.add(nums);
            if(pq.size() > k) pq.poll();
        }

        int[][] num = new int[k][k];
        for(int i = 0; i < k; i++) {
               num[i] = pq.poll();
           }
        return num;
    }
    public static void main(String[] args) {

    }
}