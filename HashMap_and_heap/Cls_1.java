package HashMap_and_heap;
import java.util.*;

public class Cls_1 {

    public static void display(int[] nums) {
        if (nums.length > 0) {
            for (int val : nums) {
                System.out.print(val + " ");
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 215. Kth Largest Element in an Array T.C = Nlog(k)
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }

    // 215. Kth Largest Element in an Array T.C = O(N)
    // k < N
    public static void downheapify(int[] nums, int pi, int li) {
        int maxID = pi, lci = 2 * pi + 1, rci = 2 * pi + 2;
        if (lci <= li && nums[lci] > nums[maxID])
            maxID = lci;
        if (rci <= li && nums[rci] > nums[maxID])
            maxID = rci;

        if (maxID != pi) {
            swap(nums, pi, maxID);
            downheapify(nums, maxID, li);
        }
    }

    public static int findKthLargest2(int[] nums, int k) {
        int li = nums.length - 1;
        for (int i = li; i >= 0; i--)
            downheapify(nums, i, li);

        while (k-- > 1) {
            swap(nums, 0, li--);
            downheapify(nums, 0, li);
        }
        return nums[0];
    }

    // 347. Top K Frequent Elements T.c
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return hm.get(a) - hm.get(b);
        });
        for (int val : nums) {
            hm.put(val, hm.getOrDefault(val, 0) + 1); // insertion O(1)
        }
        for (Integer v : hm.keySet()) {
            pq.add(v);
            if (pq.size() > k)
                pq.poll();
        }
        int[] arr = new int[k];
        int i = 0;
        while (pq.size() > 0) {
            arr[i++] = pq.poll();
        }
        return arr;
    }

    //Maximize The Array ->GeeksForGeeks
    public static ArrayList<Integer> maximizeArray(int[] arr1, int[] arr2, int n) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        for (int val : arr1)
            pq1.add(val);
        for (int val : arr2)
            pq2.add(val);

        while (pq1.size() != 0) {
            pq2.add(pq1.poll());
            if (pq2.size() > n)
                pq2.poll();
        }

        ArrayList<Integer> nums = new ArrayList<>();
        while (pq2.size() != 0) {
            int val = pq2.poll();
            nums.add(val);
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int[] Arr1 = {7, 4, 8, 0, 1};
        int[] Arr2 = {9, 7, 2, 3, 6};
        int k = 2;
        // System.out.println(findKthLargest2(nums, k));
        // display(topKFrequent(nums, k));
        System.out.println(maximizeArray(Arr1, Arr2, 5));

    }
}
