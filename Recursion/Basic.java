package Recursion;

public class Basic {

    public static void printIncreasing(int a, int b) {
        if (a > b)
            return;
        System.out.print(a + " ");
        printIncreasing(a + 1, b);
    }

    public static void printDecreasing(int a, int b) {
        if (b < a)
            return;

        System.out.print(b + " ");
        printDecreasing(a, b - 1);

    }

    public static int maximum(int[] arr, int idx) {
        if (arr.length == idx)
            return 0;
        int max = 0;
        max = maximum(arr, idx + 1);
        return max = Math.max(arr[idx], max);
    }

    public static int minimum(int[] arr, int idx) {
        if (arr.length == idx)
            return -1;
        int max = 0;
        max = maximum(arr, idx + 1);
        return max = Math.min(arr[idx], max);
    }

    public static int find(int[] arr, int idx, int data) {
        if (arr.length == idx)
            return -1;
        if (arr[idx] == data)
            return idx;
        return find(arr, idx + 1, data);
    }

    public static int firstIndex(int[] arr, int idx, int data) {
        return find(arr, idx, data);
    }

    public static int lastIndex(int[] arr, int idx, int data) {
        if (arr.length == idx)
            return idx - 1;
        int val = 0;
        val = lastIndex(arr, idx + 1, data);
        if (arr[val] != data)
            return val - 1;
        else
            return val;
    }

    public static void main(String[] args) {
        // printIncreasing(5, 9);
        // printDecreasing(5, 9);
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10 };
        System.out.println(maximum(arr, 0));
        System.out.println(minimum(arr, 0));
        // System.out.println(find(arr, 0, 9));
        System.out.println(firstIndex(arr, 0, 9));
        System.out.println(lastIndex(arr, 0, 9));

    }
}
