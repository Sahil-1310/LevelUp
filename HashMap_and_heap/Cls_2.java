package HashMap_and_heap;
import java.util.*;
public class Cls_2 {

    //Asked in amazon Game with String
    static int GamewithString(String s, int k){ //we have to remove K character from the string
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
          return b - a;
        });
        int l =s.length(), count = 0;
        int[] frq = new int[26];

        for(int i = 0; i < l; i++) {
            frq[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(frq[i] != 0) pq.add(frq[i]);
        }
        while(k != 0){
            pq.add(pq.poll() - 1);
            k--;
        }
        while(!pq.isEmpty()) {
            count+=pq.peek() * pq.poll();
        }

        return count;
    }

    //Rearrange characters -> asked in Amazon And Microsoft
    public static class key {
        int freq;
        char ch;
        key(int freq, char ch){
            this.freq = freq;
            this.ch = ch;
        }
    }
	public static String rearrangeCharacters(String s) {
      	int l = s.length();
        int[] freq = new int[26];
        PriorityQueue<key> pq = new PriorityQueue<>((a,b)->{
            return b.freq - a.freq;
        });
        for(int i = 0; i < l; i++){
            freq[s.charAt(i) - 'a']++;
        }

        for(char c = 'a'; c <= 'z'; c++){
            int idx = c - 'a';
            if (freq[idx] > 0)
              pq.add(new key(freq[idx], c));
        }

        key previous = new key(-1, '*');
        String str = "";
        while(pq.size() != 0) {
            key cur = pq.peek();
            pq.poll();
            str+=cur.ch;

            if(previous.freq > 0){
                pq.add(previous);
            }
            (cur.freq)--;
            previous = cur;
        }
        return str.length() == s.length() ? str : "-1";
	}

    ///451. Sort Characters By Frequency
        public static String frequencySort(String s) {
            HashMap<Character,Integer> hm = new HashMap<>();
            PriorityQueue<key>pq = new PriorityQueue<>((a,b)->{
                return b.freq - a.freq;
            });
            for(int i = 0; i < s.length(); i++) {
                hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0) + 1);
            }
            for(Character c : hm.keySet()){
                int f = hm.get(c);
                pq.add(new key(f, c));
            }
            StringBuilder str = new StringBuilder();
            while(!pq.isEmpty()){
                key k = pq.poll();
                for(int i = 0; i < k.freq; i++) {
                    str.append(k.ch);
                }
            }
            return str.toString();
        }


    public static void main(String[] args) {

    }
}
