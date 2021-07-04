package BitManupluation;
class Basic {

    public static int getBit(int n, int idx) {
        return (n & (1 << idx)) != 0 ? 1 : 0;
    }
    public static int setBit(int n, int idx) {
        return (n | (1 << idx));
    }
    public static int clearBit(int n, int idx) {
        return (n & (~(1 << idx)));
    }
    public static int updateBit(int n, int idx){
        int clearBit = clearBit(n, idx);
        return setBit(clearBit, idx);
    }
    public static void main(String[] args) {
        System.out.println(getBit(4, 0));
        System.out.println(setBit(5, 1));
        System.out.println(clearBit(5, 2));
        System.out.println(updateBit(5, 1));
    }
}