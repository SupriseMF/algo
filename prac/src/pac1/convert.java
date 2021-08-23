package pac1;

import java.util.ArrayList;
import java.util.List;

public class convert {


    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
     *
     * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        /**
         * 两种方法：
         * 1、逐个遍历，找到对应行 时间O(N)，空间O(N)：根据上下的方向，找到对应的行
         *
         * 2、从行遍历，直接找到对应的字符：根据所在行的高度，找到下个字符的下标
         * 其中：cycleLen = (2⋅numRows−2)
         * 对于所有整数 k，
         * 行 0 中的字符位于索引 k⋅cycleLen 处;
         * 行 numRows−1 中的字符位于索引 k⋅cycleLen + numRows − 1 处;
         * 内部的 行 i 中的字符位于索引 k⋅cycleLen + i 以及 (k + 1)⋅cycleLen − i 处;
         *
         */
        if (numRows == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();

        int n = s.length();
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j = j + cycleLen) {
                // 第0行和最后一行
                res.append(s.charAt(j + i));
                // 中间行
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    res.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return res.toString();
    }

    public String convertByChar(String s, int numRows) {
        /**
         * 1、逐个遍历，找到对应行 时间O(N)，空间O(N)：根据上下的方向，找到对应的行
         */
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goDown = false;
        for (char c : s.toCharArray()) {
            list.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goDown = !goDown;
            }
            curRow = goDown ? curRow + 1 : curRow - 1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            res.append(stringBuilder.toString());
        }
        return res.toString();
    }
}
