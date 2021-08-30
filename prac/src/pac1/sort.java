package pac1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class sort {
    private static Random RANDOM = new Random();

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(RANDOM.nextInt(100) + 1);
        }
        System.out.println(list.toString());
        System.out.println();
        int[] nums = list.stream().mapToInt(Integer::intValue).toArray();
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 冒泡排序
     */
    private static void bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            // 先默认数组是有序的，只要发生一次交换，就必须进行下一轮比较，
            // 如果在内层循环中，都没有执行一次交换操作，说明此时数组已经是升序数组
            boolean ifSorted = true;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    ifSorted = false;
                }
            }
            if (ifSorted) {
                break;
            }
        }
    }

    /**
     * 归并排序
     * @param nums
     */
    private static void mergeSort(int[] nums) {
        if (nums == null) {
            return;
        }
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
    }

    private static void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) >>> 1;
            mergeSort(nums, left, mid, temp);
            mergeSort(nums, mid + 1, right, temp);
            if (nums[mid] <= nums[mid + 1]) {
                return;
            }
            mergeTwoSortedArray(nums, left, mid, right, temp);
        }
    }

    /**
     *
     * @param nums
     * @param left
     * @param mid           [left, mid] 有序，[mid + 1, right] 有序
     * @param right
     * @param temp
     */
    private static void mergeTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        // 数组拷贝，以temp
        System.arraycopy(nums, left, temp, left, right - left + 1);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            // i先到头
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                // j先到头
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // i更小，保持稳定
                nums[k] = temp[i];
                i++;
            } else {
                // temp[i] > temp[j]
                nums[k] = temp[j];
                j++;
            }
        }
    }

    private static int[] heapSort(int[] nums) {
        int len = nums.length;

        // 将数组整理成堆
        toHeap(nums);

        // 循环不变量：区间 [0, i] 堆有序
        for (int i = len - 1; i >= 1; ) {
            // 把堆顶元素（当前最大）交换到数组末尾
            swap(nums, 0, i);
            // 逐步减少堆有序的部分
            i--;
            // 下标 0 位置下沉操作，使得区间 [0, i] 堆有序
            shiftDown(nums, 0, i);
        }
        return nums;
    }

    /**
     * 元素下降
     * @param nums
     * @param k         当前下沉元素的下标
     * @param end       [0, end] 是 nums 的有效部分
     */
    private static void shiftDown(int[] nums, int k, int end) {
        while (2 * k + 1 <= end) {
            int j = 2 * k + 1;
            if (j + 1 <= end && nums[j + 1] > nums[j]) {
                j++;
            }
            if (nums[j] > nums[k]) {
                swap(nums, j, k);
            } else {
                break;
            }
            k = j;
        }
    }

    /**
     * 将数组整理成堆（堆有序）
     *
     * @param nums
     */
    private static void toHeap(int[] nums) {
        int len = nums.length;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            shiftDown(nums, i, len - 1);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
