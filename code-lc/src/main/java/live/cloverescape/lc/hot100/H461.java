package live.cloverescape.lc.hot100;

/**
 * 汉明距离，其实可以通过移位实现，有现成函数库 Integer.bitCount(x ^ y);
 * 当然自己造轮子也是应该的。通过异或后移位即可，也可以按转为二进制的方法实现。
 * @author weibb
 * @date 2023-10-13
 */
public class H461 {
    public static void main(String[] args) {
        H461 h461 = new H461();

        System.out.println(h461.hammingDistance(1, 4));
    }

    public int hammingDistance(int x, int y) {
        return moveBit(x, y);
//        return toBinary(x, y);
    }

    private int moveBit(int x, int y) {
        int t = x ^ y;
        int ans = 0;
        while (t != 0) {
            ans += t & 1;
            t >>= 1;
        }
        return ans;
    }

    private int toBinary(int x, int y) {
        int ans = 0;
        while (x != 0 || y != 0) {
            int tx = x % 2, ty = y % 2;
            x = x / 2;
            y = y / 2;
            if (tx != ty) {
                ans++;
            }
        }
        return ans;
    }
}
