package Arrays;

public class LeetCode {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int count = 0;
        boolean flag = false;
        for (int row[] : pieces) {
            for (int val : row) {
                flag = false;
                for (int i = 0; i < arr.length; i++)
                    if (arr[i] == val) {
                        count++;
                        flag = true;
                    }
            }
            if (count == arr.length)
                return false;
            count = 0;
        }
        return flag;
    }
    public static void main(String[] args) {
        
    }
}
