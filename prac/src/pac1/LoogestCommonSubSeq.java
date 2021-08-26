package pac1;

public class LoogestCommonSubSeq {
    public int longestCommonSubsequence(String text1, String text2) {

        /**
         * 动态规划
         * dp[i][j] = text1[0:i]和text2[0:j]的最长公共子序列
         * text1:m
         * text2:n
         * 二维数组dp[m+1][n+1]
         *
         * 边界：
         * 1、i=0时，dp[0][j] = 0
         * 2、j=0时，dp[i][0] = 0
         *
         * 转移方程:
         *
         * dp[i-1][j-1]再增加一个公共字符后：
         * text1[i-1] == text2[j-1]时，dp[i][j] = dp[i-1][j-1]+1
         * text1[i-1] != text2[j-1]时，dp[i][j] = max {dp[i][j-1], dp[i-1][j]}
         *
         * text1 = "abcddab"
         * text2 = "bdcaba"
         *
         * 时间复杂度O(N*M)
         * 空间复杂度O(N*M)
         */
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
