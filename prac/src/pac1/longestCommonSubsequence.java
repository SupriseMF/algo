package pac1;

import java.util.*;

public class longestCommonSubsequence {

    /**
     * 给定两个字符串text1 和text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
     *
     * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     *
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
     *
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace" ，它的长度为 3 。
     *
     * 输入：text1 = "abc", text2 = "abc"
     * 输出：3
     * 解释：最长公共子序列是 "abc" ，它的长度为 3 。
     *
     * 输入：text1 = "abc", text2 = "def"
     * 输出：0
     * 解释：两个字符串没有公共子序列，返回 0 。
     *
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
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
         * text1[i-1] != text2[j-1]时，dp[i][j] = Math.max{dp[i][j-1], dp[i-1][j]}
         *
         * text1 = "abcddab"
         * text2 = "bdcaba"
         */

        int m = text1.length();
        int n = text2.length();
        StringBuilder str = new StringBuilder();
        String r = "";
        Map<Integer, String> map = new TreeMap<>();
        map.put(0, "");

        // 初始化即默认均为0
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char ci = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char cj = text2.charAt(j - 1);
                if (ci == cj) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    map.put(dp[i][j], map.get(dp[i - 1][j - 1]) + ci);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        System.out.println(map);
        return dp[m][n];
    }

    public static void main(String[] args) {
        String a = "abcddab";
        String b = "bdcaba";
        System.out.println(longestCommonSubsequence(a, b));
    }
}
