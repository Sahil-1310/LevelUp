package HashMap_and_heap;

import java.util.*;

public class Cls_4 {
    HashMap<Integer, Integer> hm;
    ArrayList<Stack<Integer>> arr;
    int max = 0;

    public void FreqStack() {
        hm = new HashMap<>();
        arr = new ArrayList<>();
        arr.add(new Stack<>());
    }

    public void push(int val) {
        hm.put(val, hm.getOrDefault(val, 0) + 1);
        max = Math.max(max, hm.get(val));

        if (arr.size() == max)
            arr.add(new Stack<>());

        arr.get(hm.get(val)).push(val);
    }

    public int pop() {
        int rv = arr.get(max).pop();

        if (arr.get(max).size() == 0)
            arr.remove(max--);

        hm.put(rv, hm.get(rv) - 1);

        if (hm.get(rv) == 0)
            hm.remove(rv);
        return rv;
    }

    public static void main(String[] args) {

    }
}
