package pac1;

import java.util.ArrayList;
import java.util.List;

public class countBits {


    /**
     * 给定一个非负整数num。对于0 ≤ i ≤ num 范围中的每个数字i，计算其二进制数中的 1 的数目并将它们作为数组返回。
     *
     * 示例 1:
     *
     * 输入: 2
     * 输出: [0,1,1]
     * 示例2:
     *
     * 输入: 5
     * 输出: [0,1,1,2,1,2]
     *
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        /**
         * 线性时间O(n)
         * 空间复杂度为O(n)
         *
         * 动态规划
         * 使用「最低有效位」计算「一比特数」
         *
         * 对于正整数 x，将其二进制表示右移一位，等价于将其二进制表示的最低位去掉，得到的数是 floor(x/2)
         * 如果 res[floor(x/2)]的值已知，则可以得到 res[x] 的值：
         * 如果 x 是偶数，则 res[x] = res[floor(x/2)]
         * 如果 x 是奇数，则 res[x] = res[floor(x/2)] + 1
         * 故：res[x] = res[floor(x/2)] + (x & 1)
         *
         */
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
