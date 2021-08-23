package pac1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinations {

    private static Map<Character, String> keyMap = new HashMap<Character, String>(){
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };

    /**
     * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     *
     * 
     * 首先使用哈希表存储每个数字对应的所有可能的字母，然后进行回溯操作。
     *
     * 回溯过程中维护一个字符串，表示已有的字母排列（如果未遍历完电话号码的所有数字，则已有的字母排列是不完整的）。
     * 该字符串初始为空。每次取电话号码的一位数字，从哈希表中获得该数字对应的所有可能的字母，
     * 并将其中的一个字母插入到已有的字母排列后面，然后继续处理电话号码的后一位数字，
     * 直到处理完电话号码中的所有数字，即得到一个完整的字母排列。然后进行回退操作，遍历其余的字母排列。
     *
     * 回溯算法用于寻找所有的可行解，如果发现一个解不可行，则会舍弃不可行的解。
     * 在这道题中，由于每个数字对应的每个字母都可能进入字母组合，因此不存在不可行的解，直接穷举所有的解即可。
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {

        /**
         * 时间复杂度O(3^m * 4^n)，m是三个字母的数字个数，n是四个字母的数字个数
         * 空间复杂度O(m + n)
         */
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> comb = new ArrayList<>();
        backTrace(comb, digits, 0, new StringBuffer());
        return comb;

    }

    /**
     * @param comb
     * @param digits
     * @param index       数据位置
     * @param combination
     */
    private static void backTrace(List<String> comb, String digits, int index, StringBuffer combination) {
        // 到达末端，将所有入
        if (index == digits.length()) {
            // 若所有数字都参与组合
//            comb.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = keyMap.get(digit);
            int letterLen = letters.length();
            for (int i = 0; i < letterLen; i++) {
                // 单个字符
                if (!comb.contains(String.valueOf(letters.charAt(i)))) {
                    comb.add(String.valueOf(letters.charAt(i)));
                }
                combination.append(letters.charAt(i));
                // 组合字符
                if (!comb.contains(combination.toString())) {
                    comb.add(combination.toString());
                }
                backTrace(comb, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        List<String> res = letterCombinations("234");
        System.out.println(res.size());
        for (String re : res) {
            System.out.println(re);
        }

    }
}
