package Recursion.LeetCode;

import java.util.*;

public class Day1 {
    public static int numberOfMatches(int n) {
        if (n == 1)
            return 0;
        int Matches, advance;

        if ((n % 2) == 0) {
            System.out.print("even");
            Matches = n / 2;
            advance = n / 2;
        } else {
            Matches = (n - 1) / 2;
            advance = ((n - 1) / 2) + 1;
        }
        return Matches + CountMatches(Matches, advance);
    }

    public static int CountMatches(int Matches, int advance) {
        if (Matches == 1 && advance == 1)
            return 1;

        if ((advance % 2) == 0) {
            Matches = advance / 2;
            advance = advance / 2;
            // CountMatches(Matches, advance);
        } else {
            Matches = (advance - 1) / 2;
            advance = ((advance - 1) / 2) + 1;
            // CountMatches(Matches, advance);
        }

        int count = 0;
        CountMatches(Matches, advance);
        return count += Matches;
    }

    // 567 LeetCode
    public static boolean checkInclusion(String s1, String s2) {
        ArrayList<String> res = new ArrayList<>();
        permutation(s1, "", res);
        for (String st : res)
            if (s2.contains(st))
                return true;

        return false;
    }

    public static int permutation(String s1, String ans, ArrayList<String> res) {
        if (s1.length() == 0) {
            res.add(ans);
            return 1;
        }
        char prev = '$';
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (prev != ch) {
                String ros = s1.substring(0, i) + s1.substring(i + 1);
                count += permutation(ros, ans + ch, res);
            }
            prev = ch;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("prosperity", "properties"));
    }
}
