package pac1;

public class lengthOfLastWord {

    /**
     * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
     *
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     *
     * 
     *
     * 示例 1：
     *
     * 输入：s = "Hello World"
     * 输出：5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/length-of-last-word
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (length>0) {
                    return length;
                }
                continue;
            }
            length++;

        }

        return length;
    }
}
