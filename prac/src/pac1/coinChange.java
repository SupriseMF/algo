package pac1;

import java.util.Arrays;

public class coinChange {

    /**
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     *
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
     *
     * 你可以认为每种硬币的数量是无限的。
     *
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3 
     * 解释：11 = 5 + 5 + 1
     * 示例 2：
     *
     * 输入：coins = [2], amount = 3
     * 输出：-1
     * 示例 3：
     *
     * 输入：coins = [1], amount = 0
     * 输出：0
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        /**
         * 硬币可重复使用
         * 动态规划
         * f(n) = min{ f(n), 1 + f(n - i)} 其中i ∈ coins[xxx]
         *
         * 时间复杂度O(N * M)  amount * coins.length
         * 空间复杂度O(N)
         */
        if (amount == 0) {
            return 0;
        }
        int[] f = new int[amount + 1];
        // 初始化值，便于判断是否-1
        Arrays.fill(f, amount + 1);
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    f[i] = Math.min(f[i], f[i - coins[j]] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(f));
        return f[amount] > amount ? -1 : f[amount];
    }

    public static void main(String[] args) {
        int[] coins = {4, 2, 6};
        int amount = 11;
        System.out.println(coinChange(coins, amount));

    }
}
