package HashMap_and_heap.LeetCode;

import java.util.*;

public class GFG {
    public static int findPairs(int arr[], int n) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];

                if (!map.containsKey(sum)) {
                    map.put(sum, 0);
                } else
                     map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int max = 0;
        for (Integer key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
            if (map.get(key) > max) {
                max = map.get(key);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findPairs(new int[] { 3, 4, 7, 1, 2, 9, 8 }, 7));
    }
}
