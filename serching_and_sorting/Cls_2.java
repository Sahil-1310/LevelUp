package serching_and_sorting;

import java.util.*;

public class Cls_2 {
    public static  int mergeSort(ArrayList<Integer> A, int si, int ei, ArrayList<Integer> arr) {
        if (si >= ei) return 0;
        int ic = 0;
            int mid = (si + ei) / 2;
            ic += mergeSort(A, si, mid, arr);
            ic += mergeSort(A, mid + 1, ei, arr);
            ic += merge(A, si, mid, ei, arr);

        return ic;
    }

    public static int merge(ArrayList<Integer> A, int si, int mid, int ei, ArrayList<Integer> arr) {
        int i = si;
        int mid = mid;
        int j = mid + 1;
        int ei = ei;

        int k = 0;
        int count = 0;

        while(i <= mid && j <= ei) {

            if(A.get(i) > A.get(j)) {
                count += (mid - i + 1);
                arr.add(k++,A.get(j++));
            } else
               arr.add(k++,A.get(i++));
        }

        while (i <= mid)
            arr.add(k++,A.get(i++));
        while (j <= ei)
            arr.add(k++,A.get(j++));

        k = 0;
        for (int a = si; a <= ei; a++) {
            A.set(a, arr.get(k++));
        }
        return count;
    }

    public static int countInversions(ArrayList<Integer> A) {
        int n = A.size() - 1;
        ArrayList<Integer> arr = new ArrayList<>();
        return mergeSort(A, 0, n, arr);
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(59,29));
        System.out.print(countInversions(A));
    }
}
