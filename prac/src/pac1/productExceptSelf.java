package pac1;

import java.util.Arrays;

public class productExceptSelf {

    /**
     * 给你一个长度为n的整数数组nums，其中n > 1，返回输出数组output，
     * 其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。
     *
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        /**
         * 时间复杂度O(N^2)
         * 空间复杂度O(1)
         */
        int[] res = new int[nums.length];
//        Arrays.fill(res, 1);
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (i != j) {
//                    res[j] *= nums[i];
//                }
//            }
//        }


        /**
         * res[i] = num[0:i-1] * num[i+1:n]
         * 前缀 * 后缀
         */
        // 前缀
        // 因为索引为 '0' 的元素左侧没有元素， 所以 res[0] = 1
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        // 后缀
        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int r = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            res[j] = res[j] * r;
            //  R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            r *= nums[j];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
//        for (int re : res) {
//            System.out.println(re);
//        }
    }
}
