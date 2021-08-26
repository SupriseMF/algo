package pac1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class decodeString {


    /**
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     *
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     *
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
     *
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     *
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     *
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     *
     * 输入：s = "abc3[cd]xyz"
     * 输出："abccdcdcdxyz"
     *
     * @param s
     * @return
     */
    public static String decodeString(String s) {

        /**
         * 使用Stack
         * 其中根据出现顺序，将数字、字母和'['压栈
         *
         * 时间复杂度O(N）
         * 空间复杂度O(N）
         */
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c != ']') {
                // 把所有的字母push进去，除了]
                stack.push(c);
            } else {
                //step 1: 取出[] 内的字符串
                StringBuilder sb = new StringBuilder();

                while(!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }

                //[ ]内的字符串
                String sub = sb.toString();

                stack.pop(); // 去除[


                //step 2: 获取倍数数字

                sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }

                //倍数
                int count = Integer.valueOf(sb.toString());



                //step 3: 根据倍数把字母再push回去

                while(count > 0)
                {
                    for(char ch : sub.toCharArray()) {
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }

        //把栈里面所有的字母取出来，完事L('ω')┘三└('ω')｣
        StringBuilder retv = new StringBuilder();
        while(!stack.isEmpty()) {
            retv.insert(0, stack.pop());
        }

        return retv.toString();
    }

    public static void main(String[] args) {
        String s = "abc3[cd]xyz";
        System.out.println(decodeString(s));
    }
}
