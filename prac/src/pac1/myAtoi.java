package pac1;

import java.util.HashMap;
import java.util.Map;

public class myAtoi {

    /**
     * 函数myAtoi(string s) 的算法如下：
     *
     * 读入字符串并丢弃无用的前导空格
     * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
     * 如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231− 1 的整数应该被固定为 231− 1 。
     * 返回整数作为最终结果。
     * 注意：
     *
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
     *
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        /**
         * 有限状态机     ' '	     +/-	     number	    other
         * start	    start	    signed	    in_number	end
         * signed	    end	        end	        in_number	end
         * in_number    end	        end	        in_number	end
         * end	        end	        end	        end	        end
         *
         */
        AutoMachine auto = new AutoMachine();
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            auto.put(s.charAt(i));
        }
        return (int) (auto.sign * auto.ans);
    }

    class AutoMachine {
        public AutoMachine() {

        }
        private int sign = 1;
        private long ans = 0;
        private String STATE = "start";
        private Map<String, String[]> machineMap = new HashMap<String, String[]>(){
            {
                put("start", new String[]{"start", "signed", "in_number", "end"});
                put("signed", new String[]{"end", "end", "in_number", "end"});
                put("in_number", new String[]{"end", "end", "in_number", "end"});
                put("end", new String[]{"end", "end", "end", "end"});
            }
        };

        public void put(char c) {
            STATE = machineMap.get(STATE)[getCol(c)];
            if ("in_number".equals(STATE)) {
                ans = ans * 10 + (c - '0');
                if (sign == 1) {
                    ans = Math.min(ans, Integer.MAX_VALUE);
                } else {
                    ans = Math.min(ans, -(long) Integer.MIN_VALUE);
                }
            } else if ("signed".equals(STATE)) {
                sign = c == '+' ? 1 : -1;
            }

        }

        private int getCol(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            } else {
                return 3;
            }
        }

    }
}
