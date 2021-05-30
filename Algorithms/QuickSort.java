package Algorithms;


public class QuickSort {

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
 static int count = 0;
  private static int segregation(int[] arr, int si, int ei, int pivot) {
    int p = si - 1, itr = si;
    swap(arr, pivot, ei);
    while (itr <= ei) {
      if (arr[itr] <= arr[ei]) {
         swap(arr, ++p, itr);
      }
      itr++;
    }
    return p;
  }

  private static void quickSort(int[] arr, int si, int ei) {
    if (si > ei) return;
    int pivot = ei;

    int pidx = segregation(arr, si, ei, pivot);
    quickSort(arr, si, pidx - 1);
    quickSort(arr, pidx + 1, ei);
  }
  public static void main(String[] args) {
    int[] arr = { 2, 4, 1, 3, 5 };
    quickSort(arr, 0, arr.length - 1);
    for (int val : arr) System.out.print(val + " ,");
    System.out.print("Count -> " + count);
  }
}
