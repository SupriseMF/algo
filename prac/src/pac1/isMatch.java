package pac1;

public class isMatch {


    /**
     * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
     *
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
     *
     * 输入：s = "aa" p = "a"
     * 输出：false
     * 解释："a" 无法匹配 "aa" 整个字符串。
     *
     * 输入：s = "aa" p = "a*"
     * 输出：true
     * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     *
     * 输入：s = "ab" p = ".*"
     * 输出：true
     * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     *
     * 输入：s = "aab" p = "c*a*b"
     * 输出：true
     * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        /**
         * 以一个例子详解动态规划转移方程：
         * S = abbbbc
         * P = ab*d*c
         * 1. 当 i, j 指向的字符均为字母（或 '.' 可以看成一个特殊的字母）时，
         *    只需判断对应位置的字符即可，
         *    若相等，只需判断 i,j 之前的字符串是否匹配即可，转化为子问题 f[i-1][j-1].
         *    若不等，则当前的 i,j 肯定不能匹配，为 false.
         *
         *        f[i-1][j-1]   i
         *             |        |
         *    S [a  b  b  b  b][c]
         *
         *    P [a  b  *  d  *][c]
         *                      |
         *                      j
         *
         *
         * 2. 如果当前 j 指向的字符为 '*'，则不妨把类似 'a*', 'b*' 等的当成整体看待。
         *    看下面的例子
         *
         *             i
         *             |
         *    S  a  b [b] b  b  c
         *
         *    P  a [b  *] d  *  c
         *             |
         *             j
         *
         *    注意到当 'b*' 匹配完 'b' 之后，它仍然可以继续发挥作用。
         *    因此可以只把 i 前移一位，而不丢弃 'b*', 转化为子问题 f[i-1][j]:
         *
         *          i
         *          | <--
         *    S  a [b] b  b  b  c
         *
         *    P  a [b  *] d  *  c
         *             |
         *             j
         *
         *    另外，也可以选择让 'b*' 不再进行匹配，把 'b*' 丢弃。
         *    转化为子问题 f[i][j-2]:
         *
         *             i
         *             |
         *    S  a  b [b] b  b  c
         *
         *    P [a] b  *  d  *  c
         *       |
         *       j <--
         *
         * 3. 冗余的状态转移不会影响答案，
         *    因为当 j 指向 'b*' 中的 'b' 时, 这个状态对于答案是没有用的,
         *    理由是因为达能存在b*的模式时，冗余的状态转移只发生在dp[][j-1]中，而dp[i][j]只与dp[][j-2]有关，与dp[][j-1]无关，所以答案不会受影响
         */

        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // 丢弃'字符*'
                    dp[i][j] = dp[i][j - 2];
                    // j-1的字符如果匹配
                    if (isMatch(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    // 如果非*
                    if (isMatch(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];

    }

    /**
     * 非*时匹配
     * @param s 待匹配串
     * @param p 正则表达式
     * @param i s的位置
     * @param j p的位置
     * @return
     */
    private static boolean isMatch(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        // 若为'.'，即任意匹配单个字符，true
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {
        String s = "abbddc";
        String p = "ab*d.c";
        System.out.println(isMatch(s, p));

    }

}
