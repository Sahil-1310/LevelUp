package serching_and_sorting.LeetCode;
public class Day_1 {

    // 33. Search in Rotated Sorted Array
    public int findmin(int[] nums, int si, int ei) {
        while (si < ei) {
            int mid = si + (ei - si) / 2;
            if (nums[mid] == nums[ei])
                ei--;

            else if (nums[mid] > nums[ei])
                si = mid + 1;
            else
                ei = mid;
        }
        return ei;
    }

    public int binarySearch(int[] nums, int si, int ei, int target) {
        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid])
                ei = mid - 1;
            else
                si = mid + 1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int idx = findmin(nums, 0, n - 1);
        System.out.print(idx);
        if (nums[idx] == target)
            return idx;
        int left = binarySearch(nums, 0, idx - 1, target);
        int right = binarySearch(nums, idx + 1, n - 1, target);
        return left == -1 ? right : left;

    }

    // 74. Search a 2D Matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        int idx = binaryPotentialRow(matrix, target);
        System.out.print(idx);
        return idx == -1 ? false : binarySearch(matrix, target, idx);
    }

    public int binaryPotentialRow(int[][] matrix, int target) {
        int si = 0;
        int ei = matrix.length - 1;
        int ldx = matrix[0].length - 1;

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (matrix[mid][0] <= target && target <= matrix[mid][ldx])
                return mid;
            else if (matrix[mid][0] > target)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        return -1;
    }

    public boolean binarySearch(int[][] matrix, int target, int idx) {
        int si = 0;
        int ei = matrix[0].length - 1;

        while (si <= ei) {
            int mid = (si + ei) / 2;

            if (matrix[idx][mid] == target)
                return true;
            else if (matrix[idx][mid] > target)
                ei = mid - 1;
            else
                si = mid + 1;
        }
        return false;
    }

    // 240. Search a 2D Matrix II
    public boolean searchMatrixII(int[][] matrix, int target) {
        int r = 0, c = matrix[0].length - 1;

        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target)
                return true;
            else if (matrix[r][c] > target)
                c--;
            else
                r++;
        }
        return false;
    }
}
