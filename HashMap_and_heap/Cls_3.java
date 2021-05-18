package HashMap_and_heap;
import java.util.*;

public class Cls_3 {

    //349. Intersection of Two Arrays
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int val : nums1){
            set.add(val);
        }
        for(int val : nums2) {
            if(set.contains(val)){
                arr.add(val);
                set.remove(val);
            }
        }
        int[] nums = new int[arr.size()];
        int i = 0;
        for(int val : arr){
            nums[i++] = val;
        }
        return nums;
    }

    //350. Intersection of Two Arrays II
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int val : nums1){
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }
        for(int val : nums2) {
            if(hm.containsKey(val) && hm.get(val) > 0){
                hm.put(val, hm.getOrDefault(val, 0) - 1);
                arr.add(val);
            }
        }
        int[] nums = new int[arr.size()];
        int i = 0;
        for(int val : arr){
            nums[i++] = val;
        }
        return nums;
    }

    //....128. Longest Consecutive Sequence -> Hard O(nlon(n))
    class Solution {
        public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> hm = new HashMap<>();
            for(int val : nums){
                hm.put(val, false);
            }
            Arrays.sort(nums);
            int len = -(int)1e9, count =  0;

                for(int val : nums) {
                    count = 0;
                    while(hm.containsKey(val) == true && hm.get(val) == false){
                        hm.put(val, true);
                        val++;
                        count++;
                    }
                    len = Math.max(len, count);
                }
            return len == -(int)1e9 ? 0 : len;
        }

        //...Optimize version O(N)
        public int longestConsecutive_optimize(int[] nums) {
            int len = 0;
            HashSet<Integer> set = new HashSet<>();
            for(int val : nums) {
                set.add(val);
            }
            for(int val : nums) {
                if(!set.contains(val)) continue;

                int pre = val - 1;
                int fwd = val + 1;
                set.remove(val);

                while(set.contains(pre)) set.remove(pre--);
                while(set.contains(fwd)) set.remove(fwd++);

                len = Math.max(len, fwd - pre - 1);
            }
            return len;
        }
    }
}
