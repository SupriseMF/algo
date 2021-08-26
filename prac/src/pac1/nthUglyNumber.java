package pac1;

public class nthUglyNumber {

    /**
     * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
     *
     * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
     * {1， 2， 3， 4， 5， 6， 8， 9， 10， 12， 15， 16， 18， 20， ...}
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        /**
         * 动态规划
         *
         *
         * 边界：
         * dp(1) = 1
         *
         * 定义三个指针 p2,p3,p5p 表示下一个丑数是当前指针指向的丑数乘以对应的质因数。
         * 初始时，三个指针的值都是 1。
         *
         * 状态转移：
         *  2=<i<=n:
         *  dp(i) = min {dp(p2)*2, dp(p3)*3, dp(p5)*5 }
         *  然后分别比较四者是否相等，如果相等，对应指针+1
         *
         *  时间复杂度O(N)， 空间复杂度O(N)
         *
         */


        int[] dp = new int[n + 1];
        // 边界
        dp[1] = 1;
        // 三个指针
        int p2 = 1, p3 = 1, p5 = 1;

        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }

        return dp[n];

    }

    public static void main(String[] args) {
        for (int i = 1; i < 15; i++) {
            System.out.println(nthUglyNumber(i));
        }
    }
}
