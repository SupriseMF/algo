package pac1;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {


    /**
     * 无重复字符的最长字串
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        /**
         * 滑动窗口
         *
         * 时间复杂度O(N)，每个只遍历一次
         * 空间复杂度O(M)，M为可能出现的char个数
         */
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occurred = new HashSet<>();
        int n = s.length();
        /**
         * 假设我们选择字符串中的第 k 个字符作为起始位置，
         * 并且得到了不包含重复字符的最长子串的结束位置为 rk
         *
         *  右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
         */
        int rk = -1;
        int ans = 0;
        String res = "";

        /**
         * 在左指针向右移动的时候，我们从哈希集合中移除一个字符，
         * 在右指针向右移动的时候，我们往哈希集合中添加一个字符。
         */
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occurred.remove(s.charAt(i - 1));
            }

            while (rk + 1 < n && !occurred.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occurred.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            if (ans < rk - (i - 1)) {
                ans = rk - (i - 1);
                res = s.substring(i, rk + 1);
            }
        }
        System.out.println(res);
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcdbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
