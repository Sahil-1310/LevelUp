package ArrayDeque;

import java.util.*;

class LruCache {
    class pair {
        int key;
        int value;

        pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Deque<pair> cache;
    private Map<Integer, pair> map;
    private int capacity;

    public LruCache(int capacity) {
        cache = new ArrayDeque<>(capacity);
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        int val = -(int) 1e9;
        if (map.containsKey(key)) {
            pair g = map.get(key);
            cache.remove(g);
            cache.addFirst(g);
            val = g.value;
        }
        return val != -(int) 1e9 ? val : -1;
    }

    public void put(int key, int value) {
        pair np = new pair(key, value);
        if (map.containsKey(key)) {
            pair rmk = map.remove(key);

            if (rmk.key == key) {
                boolean flag = cache.contains(rmk);
                if (flag)
                    cache.remove(rmk);
            }
        }

        if (cache.size() == this.capacity) {
            pair rm = cache.removeLast();
            map.remove(rm.key);
        }

        cache.addFirst(np);
        map.put(key, np);
    }

    public static void main(String[] args) {
        LruCache c = new LruCache(2);
        c.put(1, 1);
        c.put(2, 2);
        System.out.println(c.get(1));
        c.put(3, 3);
        System.out.println(c.get(2));
        c.put(4, 4);
        System.out.println(c.get(1));
        System.out.println(c.get(3));
        System.out.println(c.get(4));
        
    }
}