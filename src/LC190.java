public class LC190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int a = 0;
        for (int i = 0; i <= 31; i++) {
            a |= (1 & (n >>> i)) << (31 - i);
        }
        return a;
    }
}
