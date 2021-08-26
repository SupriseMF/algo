package pac1;

import java.util.ArrayList;
import java.util.List;

public class numSquares {

    /**
     * 给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     * <p>
     * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
     * <p>
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     * <p>
     * 输入：n = 12
     * 输出：3
     * 解释：12 = 4 + 4 + 4
     * <p>
     * 输入：n = 13
     * 输出：2
     * 解释：13 = 4 + 9
     *
     * @param n  平方和为n
     * @return 最少的个数
     */
//    private static List<Integer> list = new ArrayList<>();
    public static int numSquares(int n) {
        /**
         * 平方和可重复使用
         * 方法1、动态规划
         * i ∈ [1, floor(sqrt(n))]
         * f(n) = 1 + min(i∈[1:n-1]) {f(n - i * i)}
         *
         * 时间复杂度O(N * sqrt(N))
         * 空间复杂度O(N)
         */
        int[] f = new int[n + 1];
        // 由于N未知，故需要从1开始构造，直到N
        for (int i = 1; i <= n; i++) {
            int minPrev = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
//                if (minPrev >= f[i - j * j]) {
                    minPrev = Math.min(minPrev, f[i - j * j]);
//                }
            }
            f[i] = 1 + minPrev;
        }
        return f[n];
    }

    public static int numSquares1(int n) {
        /**
         *
         * 方法2、数学
         * 四平方和定理证明了:
         * 任意一个正整数都可以被表示为至多四个正整数的平方和
         * 当且仅当 n ≠  4^k × (8m+7)时，n 可以被表示为至多三个正整数的平方和
         * 因此，当 n = 4^k × (8m+7)时，n 只能被表示为四个正整数的平方和
         *
         */
        if (isPerfectSqrt(n)) {
            return 1;
        }
        if (isNFourAns(n)) {
            return 4;
        }
        // 答案为 3 时，我们很难在一个优秀的时间复杂度内解决它，但我们只需要检查答案为 1 或 2 的两种情况，即可利用排除法确定答案
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSqrt(j)) {
                return 2;
            }
        }
        return 3;
    }

    /**
     * 是否完全平方数
     * @param n
     * @return
     */
    private static boolean isPerfectSqrt(int n) {
        int a = (int) Math.sqrt(n);
        return n ==  a * a;
    }

    /**
     * 判断是否能表示为 4^k*(8m+7)
     */
    private static boolean isNFourAns(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }
        return n % 8 == 7;
    }


    public static void main(String[] args) {
        int a = 12;
        System.out.println(numSquares(a));
//        System.out.println(list.toString());
    }
}
