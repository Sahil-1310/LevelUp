package Recursion;

public class Day_6 {

    public static int FriendsPairing(String str, int idx, String ans) {
        if(str.length() == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for(int i = idx; i < str.length(); i++) {
            // System.out.println(str.substring(idx + 1));
           count += FriendsPairing(str.substring(idx + 1), idx, ans + str.charAt(idx) + ",");
           count += FriendsPairing(str, idx + 1, ans);
        }
        return count;
    }
    public static void main(String[] args) {
        FriendsPairing("ABCD" , 0, "");
    }
}
