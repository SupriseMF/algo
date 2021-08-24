package pac1;

public class minPathSum {

    /**
     * 给定一个包含非负整数的 mxn网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *
     * 示例 1：
     *
     * 输入：grid = [[1,3,1],
     *              [1,5,1],
     *              [4,2,1]]
     * 输出：7
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     * 示例 2：
     *
     * 输入：grid = [[1,2,3],
     *              [4,5,6]]
     * 输出：12
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        /**
         * 使用动态规划
         * 时间复杂度O(M * N)
         * 空间复杂度O(M * N)
         *
         */
        int[] row = grid[0];
        int[][] dp = new int[grid.length][row.length];
        dp[0][0] = row[0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < row.length; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < row.length; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][row.length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        };
        System.out.println(minPathSum(grid));
    }
}
