import java.util.*;
class Test {
    static Scanner sc = new Scanner(System.in);
    static void goodNessString() {
        int T = sc.nextInt();
        while(T > 0) {
            int L1 = sc.nextInt();
            int C1 = sc.nextInt();
            String st = sc.next();
            goodness2(L1, C1, st);
            T--;
        }
    }
    static void goodness2(int l1, int c1, String str) {
        int count = 0;
        for(int i = 0;i < l1/2;i++) {
            if(str.charAt(i) != str.charAt(l1-i-1))
                count++;
        }
        int i = 0;
        System.out.println("Case #"+i++ +":  "+ count);
    }
    public static void main(String []args) {
        goodNessString();
    }
}