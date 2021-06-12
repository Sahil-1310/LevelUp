package Recursion;

import java.util.*;

public class MazePath {

    public static int mazePath_HVD(int sr, int sc, int er, int ec, String st, ArrayList<String> res) {
        // Base Case
        if (sr == er && sc == ec) {
            res.add(st);
            return 1;
        }
        int count = 0;
        if (sr + 1 <= er) {
            count += mazePath_HVD(sr + 1, sc, er, ec, st += "V", res);
        }
        if (sc + 1 <= ec) {
            count += mazePath_HVD(sr, sc + 1, er, ec, st += "H", res);
        }
        if (sc + 1 <= ec && sr + 1 <= er) {
            count += mazePath_HVD(sr + 1, sc + 1, er, ec, st += "D", res);
        }
        return count;

    }

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
            advance =((n - 1) / 2) + 1;
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

    public static void main(String[] args) {
        ArrayList<String> res = new ArrayList<>();
        // int val = mazePath_HVD(0, 0, 2, 2, "", res);
        // System.out.println(val + "---->" + res);
        System.out.println(numberOfMatches(7));
    }
}
