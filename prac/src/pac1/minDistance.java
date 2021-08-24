package pac1;

public class minDistance {


    /**
     * 给你两个单词word1 和word2，请你计算出将word1转换成word2 所使用的最少操作数。
     *
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * 
     *
     * 示例1：
     *
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     * 示例2：
     *
     * 输入：word1 = "intention", word2 = "execution"
     * 输出：5
     * 解释：
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     *
     * 最直观的方法是暴力检查所有可能的编辑方法，取最短的一个。
     * 所有可能的编辑方法达到指数级，但我们不需要进行这么多计算，
     * 因为我们只需要找到距离最短的序列而不是所有可能的序列。
     *
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        /**
         * 先找到最大相等子字符串
         * 在附近增、删、改字符
         *
         * 编辑距离算法：
         * D[i][j] = 1 + min(D[i][j − 1], D[i − 1][j], D[i − 1][j−1])
         *
         */
        int m = word1.length();
        int n = word2.length();
        // 由于两个字符对比时，已位于(1, 1)位置，故(m, n)需要分别多一位
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < n + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 左⬅️
                int left = dp[i - 1][j] + 1;
                // 下⤵️
                int down = dp[i][j - 1] + 1;
                // 左下 ↙️
                int left_down = dp[i - 1][j - 1];
                // 左和下的值不等时， 左下值需 + 1
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                // 求最小值
                dp[i][j] = Math.min(Math.min(left, down), left_down);
            }
        }
        return dp[m][n];

    }

    public static void main(String[] args) {
        String w1 = "horse";
        String w2 = "ros";
        System.out.println(minDistance(w1, w2));

    }
}
