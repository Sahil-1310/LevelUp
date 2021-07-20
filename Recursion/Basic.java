package Recursion;

import java.util.*;

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

  // Top to Bottom Approch (When my is make at Top)
  // public static ArrayList<String> subSeq(String str, String ans) {
  //   if (str.length() == idx) {
  //     ArrayList<String> base = new ArrayList<>();
  //     return base;
  //   }

  //   for(int i = 0; i < str.length(); i++) {
  //     char c = str.charAt(i);
  //     str = str.substring(i + 1);
  //   }
  //   ArrayList<String> res = subSeq(str, idx + 1);
  //   ArrayList<String> ts = new ArrayList<>(res);
  //   for (String st : res) {
  //     ts.add(st + str.charAt(idx));
  //   }
  //   return ts;
  // }

  public static int subseq(String str, int idx, ArrayList<String> res, String st) {
    if (str.length() == idx) {
      res.add(st);
      return 1;
    }

    int count = 0;
    count += subseq(str, idx + 1, res, st + str.charAt(idx));
    count += subseq(str, idx + 1, res, st);

    return count;
  }

  public static void printSS(String str, String ans, int idx) {
    if (str.length() == idx) {
      System.out.println(ans);
      return;
    }

    printSS(str, ans + str.charAt(idx), idx + 1);
    printSS(str, ans, idx + 1);
  }

  public static void main(String[] args) {
    // printIncreasing(5, 9);
    // printDecreasing(5, 9);
    // int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10 };
    // System.out.println(maximum(arr, 0));
    // System.out.println(minimum(arr, 0));
    // System.out.println(find(arr, 0, 9));
    // System.out.println(firstIndex(arr, 0, 9));
    // System.out.println(lastIndex(arr, 0, 9));
    ArrayList<String> res = new ArrayList<>();
    System.out.println(subseq("abc", 0, res, "") + " " + res);
    // printSS("yvTA", " ",0);
  }
}
