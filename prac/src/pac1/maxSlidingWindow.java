package pac1;

import java.util.Arrays;

public class maxSlidingWindow {

    /**
     * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
     *
     * 返回滑动窗口中的最大值。
     *
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *
     * 
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
//        int[] res = new int[n - k + 1];
//        // curMax是在0~index的范围内的
//        int index = 0;
//        // 当前范围内的最大值
//        int curMax = nums[0];
//
//        for (int i = 0; i < n - (k - 1); i++) {
//            while (index < i + k && index < n) {
//                curMax = Math.max(curMax, nums[index]);
//                index++;
//            }
//            res[i] = curMax;
//        }

        /**
         * 分块 + 预处理
         * 如果我们希望求出 nums[i] 到 nums[i+k−1] 的最大值：
         * 情况1：i 是 k 的倍数，只要预处理出每个分组中的最大值
         * 情况2：i 不是 k 的倍数，前后会有重复，占有第一个分组的后缀以及第二个分组的前缀 max = max{前缀max， 后缀max}
         *
         * 即：max{suffixMax[i], prefixMax[i+k−1]}
         */
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % k == 0) {
                // i是k的倍数
                prefixMax[i] = nums[i];
            } else {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || (i + 1) % k == 0) {
                // i为最后一位，或i + 1是k的倍数
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }
        int[] res = new int[n - (k - 1)];
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] nums = {1, -1};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }
}
