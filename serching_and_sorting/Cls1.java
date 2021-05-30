package serching_and_sorting;

public class Cls1 {

    public static int binarySearch_1(int arr[], int k, int first, int last) {
        if (arr[first] <= arr[last]) {
            int mid = (first + last) / 2;
            if (k == arr[mid]) {
                return mid;
            } else if (k < arr[mid]) {
                return binarySearch_1(arr, k, first, mid - 1);
            } else
                return binarySearch_1(arr, k, mid + 1, last);
        } else if (arr[first] >= arr[last]) {
            int mid = (first + last) / 2;

            if (k == arr[mid]) {
                return mid;
            } else if (k < arr[mid]) {
                return binarySearch_1(arr, k, mid + 1, last);
            } else
                return binarySearch_1(arr, k, first, mid - 1);
        } else
            return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int n = arr.length;
        int si = 0, ei = n - 1;

        while (si <= ei) {
            int mid = (si + ei) / 2; // si + (ei - si) / 2
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] >= target) {
                ei = mid - 1;
            } else
                si = mid + 1;
        }

        return -1;
    }

    // Find closest number in array -> GeeksForGeeks
    public static int findClosest(int arr[], int target) {
        int si = 0, ei = arr.length - 1;
        if (target < arr[0] || target > arr[ei])
            return target < arr[0] ? arr[0] : arr[ei];

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (arr[mid] >= target)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        return target - arr[ei] <= target - arr[si] ? arr[ei] : arr[si];
    }

    public static int findIndex(int arr[], int target) {
        int si = 0, ei = arr.length - 1;

        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (arr[mid] < target)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return si;
    }

    public static int lastIndex(int arr[], int target) {
        int si = 0, ei = arr.length - 1;

        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (arr[mid] <= target)
                si = mid + 1;
            else
                ei = mid - 1;
        }
        return --si;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] arr = { -1, -1 };
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                arr[0] = mid;
                hi = mid - 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        lo = 0;
        hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                arr[1] = mid;
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return arr;
    }
    //153. Find Minimum in Rotated Sorted Array
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == nums[high])
                high--;

            else if (nums[mid] > nums[high])
                low = mid + 1;
            else
                high = mid;
        }
        return nums[high];
    }

    public static void main(String[] args) throws Exception {
        // int arr[] = { 1, 2, 3, 3, 3, 4, 4, 5, 6, 7, 8, 8, 8, 12, 14, 16 };
        int arr[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

        int target = 3;
        System.out.println(binarySearch_1(arr, target, 0, 9));
        // System.out.println(findClosest(arr, target));
        // System.out.println(findIndex(arr, target));
        // System.out.println(lastIndex(arr, target));

    }
}
