package pac1;

public class maxProduct {


    /**
     * 给你一个整数数组 nums，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     *
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释:子数组 [2,3] 有最大乘积 6。
     *
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释:结果不能为 2, 因为 [-2,-1] 不是子数组。
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        /**
         * 当前位置的最优解未必是由前一个位置的最优解转移得到的。
         *
         */
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int max = maxF, min = minF;
            // 可能有负有正
            // 更新最大
            maxF = Math.max(max * nums[i], Math.max(nums[i], min * nums[i]));
            // 更新最大ans
            ans = Math.max(maxF, ans);
            // 更新最小
            minF = Math.min(min * nums[i], Math.min(nums[i], max * nums[i]));
        }
        return ans;
    }
}
