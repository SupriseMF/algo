package pac1;

import java.util.Arrays;

public class nextPermutation {

    /**
     * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
     *
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     *
     * 必须 原地 修改，只允许使用额外常数空间。
     *
     * 输入：nums = [1,2,3]
     * 输出：[1,3,2]
     *
     * 输入：nums = [3,2,1]
     * 输出：[1,2,3]  (最大的排列 [3,2,1] 的下一个排列为最小的排列 [1,2,3])。
     *
     * 输入：nums = [1,1,5]
     * 输出：[1,5,1]
     *
     * 输入：nums = [1]
     * 输出：[1]
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        /**
         * 1、先找右侧的降序列
         * 2、找到降序列的左侧数字a
         * 3、找到降序列中的数字b，其中b最接近a，且b>a
         * 4、a、b交换 swap(nums, i, j)
         * 5、右侧将序列升序 reverse(nums, i, j)
         * OK
         * 时间复杂度O(N)
         * 空间复杂度O(1)
         */
        // i从倒数第二位  向前
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            // j从尾部开始，找到稍大数
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        // 向后逐位交换
        reverse(nums, i + 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 顺序交换
    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
//        int[] nums = {6, 2, 4, 3, 1};
        int[] nums = {4, 3, 1};
//        int[] nums = {1, 2, 3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }


}
