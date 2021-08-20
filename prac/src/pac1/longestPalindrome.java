package pac1;

public class longestPalindrome {

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     * 
     *
     * 示例 1：
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     *
     * 输入：s = "cbbd"
     * 输出："bb"
     * 示例 3：
     *
     * 输入：s = "a"
     * 输出："a"
     *
     *
     */
    public static String longestPalindrome(String s) {
        if (s == null) {
            return "";
        }
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            int j = i + res.length() + 1;
            while (j <= s.length()) {
                if (isPalindromeStr(s.substring(i, j))) {
                    res = s.substring(i, j);
                }
                j++;
            }

        }
        return res;
    }

    private static boolean isPalindromeStr(String a) {
        if (a == null) {
            return false;
        }
        if (a.length() == 0 || a.length() == 1) {
            return true;
        }
        int len = a.length() - 1;
        int mid = len / 2;
        for (int i = 0; i <= mid; i++) {
            if (a.charAt(i) != a.charAt(len - i)) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String a = "abba";
        String b = "abcefecda";
        String c = "bb";
        String d = "aacabdkacaa";
//        System.out.println(c.substring(0, 2));
        System.out.println(longestPalindromeDp1(d));
//        System.out.println(isPalindromeStr(a));
//        System.out.println(isPalindromeStr(b));

    }


    /**
     *
     * 动态规划
     * P(i,j)=P(i+1,j−1) && (Si ==Sj)
     * 边界条件
     *
     *
     *
     * 根据这个思路，我们就可以完成动态规划了，最终的答案即为所有 P(i, j) = \text{true}P(i,j)=true 中 j-i+1j−i+1（即子串长度）的最大值。
     * 注意：在状态转移方程中，我们是从长度较短的字符串向长度较长的字符串进行转移的，因此一定要注意动态规划的循环顺序。
     *
     * 时间复杂度：O(n^2)，其中 nn 是字符串的长度。动态规划的状态总数为 O(n^2)，对于每个状态，我们需要转移的时间为 O(1)。
     *
     * 空间复杂度：O(n^2)，即存储动态规划状态需要的空间。
     *
     *
     * @param s
     * @return
     */
    public static String longestPalindromeDp(String s) {

            int len = s.length();
            if (len < 2) {
                return s;
            }

            int maxLen = 1;
            int begin = 0;
            // dp[i][j] 表示 s[i..j] 是否是回文串
            boolean[][] dp = new boolean[len][len];
            // 初始化：所有长度为 1 的子串都是回文串
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }

            char[] charArray = s.toCharArray();
            // 递推开始
            // 先枚举子串长度
            for (int L = 2; L <= len; L++) {
                // 枚举左边界，左边界的上限设置可以宽松一些
                for (int i = 0; i < len; i++) {
                    // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                    int j = L + i - 1;
                    // 如果右边界越界，就可以退出当前循环
                    if (j >= len) {
                        break;
                    }

                    if (charArray[i] != charArray[j]) {
                        dp[i][j] = false;
                    } else {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }

                    // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + maxLen);
    }


    /**
     *
     * 动态规划
     * P(i,j)=P(i+1,j−1) && (Si ==Sj)
     * 边界条件
     *
     *
     *
     * 根据这个思路，我们就可以完成动态规划了，最终的答案即为所有 P(i, j) = \text{true}P(i,j)=true 中 j-i+1j−i+1（即子串长度）的最大值。
     * 注意：在状态转移方程中，我们是从长度较短的字符串向长度较长的字符串进行转移的，因此一定要注意动态规划的循环顺序。
     *
     * 时间复杂度：O(n^2)，其中 nn 是字符串的长度。动态规划的状态总数为 O(n^2)，对于每个状态，我们需要转移的时间为 O(1)。
     *
     * 空间复杂度：O(n^2)，即存储动态规划状态需要的空间。
     *
     *
     * @param s
     * @return
     */
    public static String longestPalindromeDp1(String s) {
        int len = s.length();
        if (len < 2) {
            return "";
        }
        int maxLen = 1;
        int begin = 0;
        //初始化dp
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] arr = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (arr[i] != arr[j]) {
                    dp[i][j] = false;
                } else {
                    // 俩位置值相等
                    if (j - i < 3) {
                        // i、j相距<3，不需再找子
                        dp[i][j] = true;
                    } else {
                        // 相距较大，继续找子串是否能回文串
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // dp[i][j]为true，说明存在回文串，记录起始位置和最大长度
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);

    }



}


