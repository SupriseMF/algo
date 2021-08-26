package pac1;

import java.util.ArrayList;
import java.util.List;

public class wordBreak {


    /**
     * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     *
     * 说明：
     *
     * 拆分时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     * 示例 1：
     *
     * 输入: s = "leetcode", wordDict = ["leet", "code"]
     * 输出: true
     * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {

        /**
         * 动态规划 + 记忆化回溯
         * dp[i] 表示：前i个字符串是否能被拆分成已存在单词
         * check(s[j..i−1])， 表示：j到i-1是否是已存在的单词
         * 状态转移式：
         * dp[i] = dp[j] && check(s[j..i−1])
         *
         */
        boolean[] dp = new boolean[s.length() + 1];
        // 初始边界
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(wordBreak(s, list));
    }
}
