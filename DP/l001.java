import java.util.Arrays;

public class l001 {

	public static void print1D(int[] arr) {
		for (int ele : arr) {
			System.out.print(ele + " ");
		}
		System.out.println();
	}

	public static void print2D(int[][] arr) {
		for (int[] ar : arr) {
			print1D(ar);
		}
	}

	public static int fib_rec(int n) {
		if (n <= 1)
			return n;
		// System.out.println("before ---->"+ n);
		int ans = fib_rec(n - 1) + fib_rec(n - 2);
		// System.out.println("After------->"+ ans);
		return ans;
	}

	public static int fib_memo(int n, int[] dp) {
		if (n <= 1) {
			return dp[n] = n;
		}

		if (dp[n] != -1)
			return dp[n];

		int ans = fib_memo(n - 1, dp) + fib_memo(n - 2, dp);
		return dp[n] = ans;
	}

	public static int fib_DP(int N, int[] dp) {

		for (int n = 0; n <= N; n++) {
			if (n <= 1) {
				dp[n] = n;
				continue;
			}

			int ans = dp[n - 1] + dp[n - 2];// fib_01(n - 1, dp) + fib_01(n - 2, dp);

			dp[n] = ans;
		}

		return dp[N];
	}

	public static int fib_twoPointer(int N) {
		int a = 0, b = 1;
		for (int n = 0; n < N; n++) {
			// System.out.print(a + " ");

			int sum = a + b;
			a = b;
			b = sum;
		}

		return a;
	}

	public static void fibo() {
		int n = 8;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		System.out.println(fib_rec(n));
		System.out.println(fib_memo(n, dp));
		System.out.println(fib_DP(n, dp));
		System.out.println(fib_twoPointer(n));

		print1D(dp);
	}

	// Count MazePath
	public static int MazePathrec(int sr, int sc, int er, int ec, int count) {
		if (sr == er - 1 && sc == ec - 1) {
			return count++;
		}
		if (sr + 1 <= er - 1) {
			MazePathrec(sr + 1, sc, er, ec, count);
		}
		if (sc + 1 <= ec - 1) {
			MazePathrec(sr, sc + 1, er, ec, count);
		}
		if (sr + 1 <= er - 1 && sc + 1 <= ec - 1) {
			MazePathrec(sr + 1, sc, er, ec, count);
		}
		return count;
	}

	// LeetCode decode Way 91
	public static int numberofDecode(String s, int idx) {
		if (idx == s.length())
			return 1;
		if (s.charAt(idx) == '0')
			return 0;
		if (idx == s.length() - 1)
			return 1;

		int way = numberofDecode(s, idx + 1);
		return 0;
	}

	public static void main(String[] args) {
		fibo();
		System.out.println(MazePathrec(0, 0, 2, 2, 0));
		char ch = '1', ch2 = '2';
		System.out.println((ch - '0') * 10 + (ch2 - '0') + " " + ('0'));
	}
}