package Recursion;

public class CrossWorld {
    static char[][] box = { { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
            { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' }, { '+', '-', '-', '-', '-', '-', '-', '-', '+', '+' },
            { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' }, { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
            { '+', '-', '-', '-', '-', '-', '-', '+', '+', '+' }, { '+', '-', '+', '+', '+', '-', '+', '+', '+', '+' },
            { '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' }, { '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
            { '+', '+', '+', '+', '+', '+', '+', '+', '+', '+' } };

    public static boolean isPossibleToPlace_H(char[][] board, String word, int r, int c) {
        return true;
    }

    public static void place_H(char[][] board, String word, int r, int c) {

    }

    public static void unPlace_H(char[][] board, String word, int r, int c) {

    }

    public static boolean isPossibleToPlace_V(char[][] board, String word, int r, int c) {
        return true;
    }

    public static void place_V(char[][] board, String word, int r, int c) {

    }

    public static void unPlace_V(char[][] board, String word, int r, int c) {

    }

    public static int crossWord(char[][] board, String[] words, int idx) {
        if (idx == words.length) {
            return 1;
        }

        // String str = words[idx];
        int count = 0;

        return count;
    }

    public static void main(String[] args) {

    }
}
