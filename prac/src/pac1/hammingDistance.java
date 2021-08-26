package pac1;

public class hammingDistance {

    /**
     * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
     *
     * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
     *
     * 输入：x = 1, y = 4
     * 输出：2
     * 解释：
     * 1   (0 0 0 1)
     * 4   (0 1 0 0)
     *        ↑   ↑
     * 上面的箭头指出了对应二进制位不同的位置。
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {

        /**
         * 两个数异或 x ^ y
         *
         * 移位实现位计数
         */
//        int count = Integer.bitCount(x ^ y);
        return bitCount(x ^ y);
    }

    private static int bitCount(int x) {
        int bitCount = 0;
        while (x != 0) {
            bitCount += x & 1;
            x = x >> 1;
        }
        return bitCount;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 3));
    }
}
