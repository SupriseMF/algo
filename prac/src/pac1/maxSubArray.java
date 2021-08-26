package pac1;

import java.util.ArrayList;
import java.util.List;

public class maxSubArray {

    /**
     * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 
     *
     * 示例 1：
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
     * 示例 2：
     *
     * 输入：nums = [1]
     * 输出：1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        /**
         * 时间复杂度O(N)
         * 空间复杂度O(1)
         */
        int pre = 0;
        int maxAns = nums[0];
        List<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        for (int x : nums) {
            if (pre + x > x) {
                res.add(x);
            } else {
                res.clear();
                res.add(x);
            }
            pre = Math.max(pre + x, x);

            // 存储当前最大的元素
            if (pre > maxAns) {
                ans.clear();
                ans = new ArrayList<>(res);
            }
            maxAns = Math.max(pre, maxAns);

        }

        /**
         * 打印最大子序和的组合、或者对应的下标
         */
        System.out.println(ans);
        return maxAns;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
