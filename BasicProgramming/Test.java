package BasicProgramming;

import java.util.*;

public class Test {
    public static boolean isPrime(int n) {
        if (n % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void checkPrime(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(isPrime(arr[i]))
                System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int i = 0;
        while (i != n) {
            int val = sc.nextInt();
            if (val < 2 || val > 99)
                System.out.println("invalid input");
            else
                arr[i++] = val;
        }

        sc.close();
    }
}
