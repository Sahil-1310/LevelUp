package Recursion;

import java.util.*;

public class MazePath {

    public static ArrayList<String> mazePath_HVD(int sr, int sc, int er, int ec) {
        if (sr == ec && sc == ec) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        ArrayList<String> myans = new ArrayList<>();
        if (sr + 1 <= er) {
            ArrayList<String> res = mazePath_HVD(sr + 1, sc, er, ec);
            for (String st : res)
                myans.add(st + 'V');

        }
        if (sc + 1 <= ec) {
            ArrayList<String> res = mazePath_HVD(sr, sc + 1, er, ec);
            for (String st : res)
                myans.add(st + 'H');
        }
        if (sr + 1 <= er && sc + 1 <= ec) {
            ArrayList<String> res = mazePath_HVD(sr + 1, sc + 1, er, ec);
            for (String st : res)
                myans.add(st + 'D');

        }
        return myans;
    }

    // Bottom to Top
    public static int mazePath_HVD(int sr, int sc, int er, int ec, String st, ArrayList<String> res) {
        // Base Case
        if (sr == er && sc == ec) {
            res.add(st);
            return 1;
        }

        int count = 0;
        if (sr + 1 <= er)
            count += mazePath_HVD(sr + 1, sc, er, ec, st + "V", res);
        if (sr + 1 <= er && sc + 1 <= ec)
            count += mazePath_HVD(sr + 1, sc + 1, er, ec, st + "D", res);
        if (sc + 1 <= ec)
            count += mazePath_HVD(sr, sc + 1, er, ec, st + "H", res);

        return count;
    }

    // public static ArrayList<String> mazePath_HVD_multi(int sr, int sc, int er,
    // int ec) {

    // }
    public static void printMazePaths2(int sr, int sc, int dr, int dc, String psf) {
        if (sr == dr - 1 && sc == dc - 1) {
            System.out.println(psf);
            return;
        }

        for (int jump = 1; sc + jump < dc; jump++) {
            printMazePaths(sr, sc + 1, dr, dc, psf + 'h' + jump);
        }

        for (int jump = 1; sr + jump < dr; jump++) {
            printMazePaths(sr + 1, sc, dr, dc, psf + 'v' + jump);
        }
    }

    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if (sr == dr - 1 && sc == dc - 1) {
            System.out.println(psf);
            return;
        }

        if (sc + 1 < dc) {
            printMazePaths(sr, sc + 1, dr, dc, psf + 'h');
        }

        if (sr + 1 < dr) {
            printMazePaths(sr + 1, sc, dr, dc, psf + 'v');
        }
    }

    public static void main(String[] args) {
        // ArrayList<String> res = new ArrayList<>();
        // int val = mazePath_HVD(0, 0, 2, 2, "", res);
        // System.out.println(val + "---->" + res);
        // System.out.print(mazePath_HVD(0, 0, 2, 2));
        Scanner scr = new Scanner(System.in);
        int dr = scr.nextInt();
        int dc = scr.nextInt();
        printMazePaths2(0, 0, dr, dc, "");
        scr.close();

    }
}
