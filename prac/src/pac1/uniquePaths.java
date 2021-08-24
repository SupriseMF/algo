package pac1;

public class uniquePaths {

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     *
     * 问总共有多少条不同的路径？
     *
     * 输入：m = 3, n = 2
     * 输出：3
     * 解释：
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向下
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        /**
         * 1、递归实现
         * 时间、空间复杂度高
         *
         */
        // 结束条件
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }


    public static int uniquePaths1(int m, int n) {
        /**
         * 2、动态规划，重复利用较小的结果
         * 时间复杂度O(N*M)
         * 空间复杂度O(N*M)
         * 当i = 0，或j = 0不符合题意，忽略
         */
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        // 最终位置即ans
        return f[m - 1][n - 1];
    }

    public static int uniquePaths2(int m, int n) {
        /**
         * 3、组合数学
         * 从起点到终点，其中移动行数为(m -1)次，移动列数为(n -1)次，一共要移动(m - 1 + n - 1)次
         * 因此，组合数学：
         *  (m - 1)         (m + n − 2)(m + n − 3) ... n         (m + n − 2)!
         * C            =  ————————————————————————————   =   ————————————————
         *  ( m + n - 2)        (m - 1)!                       (m - 1)!(n - 1)!
         */
        long ans = 1;
        // 计算次数：1 ... (m - 1)
        for (int x = n, y = 1; y < m; x++, y++) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(50, 100));
    }
}
