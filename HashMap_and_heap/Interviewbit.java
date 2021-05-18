package HashMap_and_heap;

import java.util.*;

public class Interviewbit {

    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    //...252 Meeting Room
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 0)
            return true;
        // Write your code here
        Collections.sort(intervals, (a, b) -> {
            return a.start - b.start;
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < pq.peek())
                return false;
            else
                pq.poll();

            pq.add(intervals.get(i).end);
        }
        return true;
    }

    // .... 253 Meeting rooms Leetcode and Interviewbit ->
    // amazon,apple,flipkart,microsoft,ajio,fab [I.M]
    public int solve(int[][] A) {
        // Write your code here
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            // Compare values according to columns
            public int compare(final int[] entry1, final int[] entry2) {

                // To sort in descending order revert
                // the '>' Operator
                if (entry1[0] > entry2[0])
                    return 1;
                else
                    return -1;
            }
        }); // End of f);
        int count = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(A[0][1]);
        for (int i = 1; i < A.length; i++) {
            if (A[i][0] < pq.peek())
                count++;
            else
                pq.poll();

            pq.add(A[i][1]);
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
