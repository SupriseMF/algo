package pac1;

public class compareVersion {


    /**
     * 给你两个版本号 version1 和 version2 ，请你比较它们。
     *
     * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
     *
     * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
     *
     * 返回规则如下：
     *
     * 如果version1>version2返回1，
     * 如果version1<version2 返回 -1，
     * 除此之外返回 0。
     * 
     *
     * 示例 1：
     *
     * 输入：version1 = "1.01", version2 = "1.001"
     * 输出：0
     * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
     *
     * @param version1
     * @param version2
     * @return
     */
    public static int compareVersion(String version1, String version2) {
        String[] v1List = version1.split("\\.");
        String[] v2List = version2.split("\\.");
        int v1Len = v1List.length - 1;
        int v2Len = v2List.length - 1;
        int j = 0;
        // 现在l1上比较一遍
        for (int i = 0; i < v1List.length; i++) {
            int i1 = Integer.parseInt(v1List[i]);

            int i2 = 0;
            if (i<=v2Len) {
                i2 = Integer.parseInt(v2List[i]);
            }
            if (i1>i2) {
                return 1;
            } else if (i1 < i2) {
                return -1;
            } else {
                j++;
                continue;
            }
        }
        // 再在l2上走一遍，看剩余是否为0
        if (j <= v2Len) {
            boolean isZero = true;
            for (int i = j; i <= v2Len; i++) {
                int val = Integer.valueOf(v2List[i]);
                if (val != 0) {
                    isZero = false;
                    break;
                }
            }
            if (isZero) {
                return 0;
            } else {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String test = "1.1.1";
        System.out.println(compareVersion("1", "1.1"));

    }
}
