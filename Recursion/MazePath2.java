package Recursion;

public class MazePath2 {

    // public static int MazeLongestPath(int sr, int sc, int er, int ec, String psf,
    // int lenCount) {
    // if (sr == er && sc == ec) {
    // if ((er + ec) >= (sr + sc)) {
    // System.out.println(lenCount + " "+ psf);
    // }
    // }

    // return 0;
    // }
    public static int permutaion(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            String st = str.substring(0, i) + str.substring(i + 1);
            count += permutaion(st, ans + str.charAt(i));
        }
        return count;
    }

    public static void main(String[] args) {
        permutaion("aaa ","");
    }
}
