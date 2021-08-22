package pac1;

public class NumToChinese {
    /**
     * 第一级别段数
     */
    final static String[] units1 = { "", "拾", "佰", "仟", };

    /**
     * 第二级别段数
     */
    final static String[] units2 = { "", "万", "亿", "万亿" };
    final static String[] numEnum = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };

//    final static String[] numEnum = { "〇", "一", "二", "三", "四", "五", "六", "七", "八", "九" };

    public static void main(String[] args) {
        int num = 2134000123;
        System.out.println(numToChinese(num));
    }

    public static String numToChinese(int num) {
        char[] numChar = String.valueOf(num).toCharArray();

        StringBuffer sb = new StringBuffer("");

        int length = numChar.length;

        for (int i = 0; i < length; i++) {
            int mod = (length - 1 - i) % 4;

            int n = Integer.parseInt(numChar[i] + "");

            if (n == 0) {
                if (i + 1 < length && numChar[i + 1] != '0' && mod != 0) {
                    sb.append(numEnum[0]);
                }
            } else {
                sb.append(numEnum[n]).append(units1[mod]);
            }

            /**

             * 补上第二级别段数

             */
            if (mod == 0) {
                sb.append(units2[(length - i) / 4]);
            }
        }

        return sb.toString();

    }

}
