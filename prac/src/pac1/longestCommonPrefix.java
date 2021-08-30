package pac1;

import com.sun.deploy.util.StringUtils;
import jdk.nashorn.internal.ir.IfNode;

public class longestCommonPrefix {


    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串""。
     *
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     *
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String s = strs[0];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            // 不是以此开头，则比较串去掉尾部
            while (!str.startsWith(s)) {
                if (s.length() == 0) {
                    return "";
                }
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            while (!str.startsWith(prefix)) {
                if (prefix.length() == 0) {
                    return "";
                }
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
