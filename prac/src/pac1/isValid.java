package pac1;

import java.util.Stack;

public class isValid {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 
     *
     * 示例 1：
     *
     * 输入：s = "()"
     * 输出：true
     * 示例2：
     *
     * 输入：s = "()[]{}"
     * 输出：true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if (equals(stack.peek(), s.charAt(i))) {
                stack.pop();

            } else {
                stack.push(s.charAt(i));
            }

        }

        return stack.isEmpty();

    }

    private  boolean equals(Character a, Character b) {
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }
}
