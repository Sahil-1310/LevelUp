package Recursion;

public class NQueen {
    public static int queenCombination(int tnb, int tnq, int idx, int qno, String ans) {
        if (tnq == qno) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < tnb; i++) {
            count += queenCombination(tnb, tnq, idx + 1, qno + 1, ans + "b" + i + " " + "q" + qno + " ");
        }
        return count;
    }

    public static int queenPermutation(boolean[] box, int tnq, int idx, int q, String ans) {
        if (tnq == q) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = idx; i < tnq; i++) {
            if (!box[i]) {
                box[i] = true;
                count += queenPermutation(box, tnq, idx, q + 1, ans + "b" + i + " " + "q" + i + " ");
                box[i] = false;
            }
        }
        return count;
    }

    public static int queenCombination2D(boolean[][] box, int tnq, int idx, String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0, n = box.length, m = box[0].length;
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;

            count += queenCombination2D(box, tnq - 1, idx + 1, ans + "(" + r + c + ")" + " ");
        }
        return count;
    }

    public static int queenPermutation2D(boolean[][] box, int tnq, int idx, String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0, n = box.length, m = box[0].length;
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;

            if (!box[r][c]) {
                box[r][c] = true;
                count += queenPermutation2D(box, tnq - 1, 0, ans + "(" + r + c + ")" + " ");
                box[r][c] = true;
            }
        }
        return count;
    }

    //////////////////////////////////////////////////////////////////////
    public static boolean isSafeToPlaceQueen(boolean[][] board, int row, int col) {
        // vector<vector<int>> dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int[][] dir = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
        int n = board.length, m = board[0].length;
        for (int d = 0; d < dir.length; d++) {
            for (int rad = 1; rad < board.length; rad++) {
                int r = row + rad * dir[d][0];
                int c = col + rad * dir[d][1];

                if (r >= 0 && c >= 0 && r < n && c < m) {
                    if (board[r][c])
                        return false;
                } else
                    break;
            }
        }

        return true;
    }

    public static int nqueen_01_combi(boolean[][] board, int tnq, int idx, String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0, n = board.length, m = board[0].length;
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (isSafeToPlaceQueen(board, r, c)) {
                board[r][c] = true;
                count += nqueen_01_combi(board, tnq - 1, i + 1, ans + "(" + r + "," + c + ") ");
                board[r][c] = false;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // System.out.println(queenCombination(4, 4, 0, 0, ""));
        // System.out.println(queenPermutation(new boolean[4], 4, 0, 0, ""));
        // System.out.println(queenCombination2D(new boolean[4][4], 4, 0, ""));
        // System.out.println(queenCombination2D(new boolean[4][4], 4, 0, ""));
        System.out.println(nqueen_01_combi(new boolean[4][4], 4, 0, ""));
    }
}
