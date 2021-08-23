package pac1;

import java.util.ArrayList;
import java.util.List;

public class generateParenthesis {


    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * 有效括号组合需满足：左括号必须以正确的顺序闭合。
     *
     * 示例 1：
     *
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     *
     * 输入：n = 1
     * 输出：["()"]
     *
     * 只在序列仍然保持有效时才添加 '(' or ')'，而不是每次添加。我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
     *
     * 如果左括号数量不大于 nn，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号。
     *
     *
     * @param n
     * @return
     */


    /**
     * 判断一个括号字符串是否有效
     * @param current
     * @return
     */
    public static boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    /**
     * 解法
     */
    static List<String> res = new ArrayList<>();
    public static List<String> generateParenthesis1(int n) {
        if(n <= 0){
            return res;
        }
        getParenthesis("",n,n);
        return res;
    }

    /**
     * 递归处理
     * @param str     形成中的字符串
     * @param left    剩余的左括号个数
     * @param right   剩余的右括号个数
     */
    private static void getParenthesis(String str,int left, int right) {
        // 结束条件
        if(left == 0 && right == 0 ){
            res.add(str);
            return;
        }
        // 处理
        if(left == right){
            //剩余左右括号数相等，下一个只能用左括号
            getParenthesis(str + "(", left - 1, right);
        } else if (left < right) {

            //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
            if (left > 0) {
                getParenthesis(str + "(", left - 1, right);
            }
            getParenthesis(str + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        int a = 1;

        res = generateParenthesis1(a);
        for (String re : res) {
            if (valid(re.toCharArray())) {
                System.out.println(re);
            }

        }


    }
}
