package pac1;

import java.security.SecureRandom;
import java.util.Random;

public class QuickSort1 {

    // 快速排序 1：基本快速排序

    /**
     * 列表大小等于或小于该大小，将优先于 quickSort 使用插入排序
     */
    private static final int INSERTION_SORT_THRESHOLD = 7;

    private static final Random RANDOM = new Random();


    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        // 小区间使用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }

        // 正序的第N位
        int pIndex = partition(nums, left, right);
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);
    }

    /**
     * 对数组 nums 的子区间 [left, right] 使用插入排序
     *
     * @param nums  给定数组
     * @param left  左边界，能取到
     * @param right 右边界，能取到
     */
    private void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    /**
     * 分区
     * 随机选择一个位置的值，作为中轴
     * 中轴左侧的数均小，右侧的数均大
     */
    private int partition(int[] nums, int left, int right) {
        int randomIndex = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);

        // 基准值
        int pivot = nums[left];
        int pos = left;
        // 循环不变量：
        // all in [left + 1, lt] < pivot
        // all in [lt + 1, i) >= pivot
        // 从left右侧开始比较
        for (int i = left + 1; i <= right; i++) {
            // 值都比轴小，位置
            if (nums[i] < pivot) {
                pos++;
                swap(nums, i, pos);
            }
        }
        // 轴值放在中间位置
        swap(nums, left, pos);
        // 返回轴所在位置
        return pos;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
