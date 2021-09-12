import java.util.*;

public class Interview {
    public static String frequencyOccurence(String st) {
        int i = -1;
        String ans = "";
        if(st.length() == 0)
            return "";
        HashMap<Character, Integer> hm = new HashMap<>();
        while (++i < st.length()) {
            hm.put(st.charAt(i), hm.getOrDefault(st.charAt(i), 0) + 1);
        }

        for (Character c : hm.keySet()) {
            int frqCount = hm.get(c);
            ans += c;
            ans+= frqCount;
        }
        return ans;
    }
    public static void main(String[] args) {
       String res =  frequencyOccurence("AABBCCDD");
       System.out.println(res);
    }
}
