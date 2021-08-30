package pac1;

import java.security.SecureRandom;
import java.util.*;

public class QuickSort2Pivot {


    /**
     * 列表大小等于或小于该大小，将优先于 quickSort 使用插入排序
     */
    private static final int INSERTION_SORT_THRESHOLD = 7;

    private static final Random RANDOM = new Random();

    public static int[] sortArray(int[] nums) {
//        int len = nums.length;
//        quickSort(nums, 0, len - 1);
        sort1(nums);
        return nums;
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (right-left<=INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }
        if (left < right) {
            int pos = partition(nums, left, right);
            quickSort(nums, left, pos - 1);
            quickSort(nums, pos + 1, right);
        }
    }

    public static void sort(int[] data) {
        if (data == null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(data.length - 1);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            // 至少需要两个元素
            if (right - left > 1) {
//                int p = left + (right - left) / 2;
                int p = partition(data, left, right);
                stack.push(left);
                stack.push(p);
                stack.push(p + 1);
                stack.push(right);
            }
        }
    }

    public static void sort1(int[] nums) {
        if (nums == null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(nums.length - 1);
        while (!stack.isEmpty()) {
            int right = stack.pop();
            int left = stack.pop();
            if (right - left > 1) {
                int p = partition1(nums, left, right);
                stack.push(left);
                stack.push(p);
                stack.push(p + 1);
                stack.push(right);
            }
        }
    }

    /**
     * 插入排序
     * @param nums
     * @param left
     * @param right
     */
    private static void insertionSort(int[] nums, int left, int right) {
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
     * 从左侧lt到右侧gt，比较大小并相向移动，否则交换
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] nums, int left, int right) {
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, randomIndex, left);
        int pivot = nums[left];
        int lt = left + 1;
        int gt = right;
        while (true) {
            while (lt <= right && nums[lt] < pivot) {
                lt++;
            }
            while (gt > left && nums[gt] > pivot) {
                gt--;
            }
            if (lt >= gt) {
                break;
            }
            swap(nums, lt, gt);
            lt++;
            gt--;
        }
        // 由于此时pos >= gt，故需是上一位，故pos = pos - 1
        swap(nums, left, lt - 1);
        return lt - 1;
    }

    private static int partition1(int[] nums, int left, int right) {
        int random = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, left, random);
        int pivot = nums[left];
        int lt = left + 1;
        int gt = right;
        while (true) {
            while (lt <= right && nums[lt] < pivot) {
                lt++;
            }
            while (gt > lt && nums[gt] > pivot) {
                gt--;
            }
            if (lt >= gt) {
                break;
            }
            swap(nums, lt, gt);
            lt++;
            gt--;
        }
        swap(nums, left, lt - 1);
        return lt - 1;
    }


    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(RANDOM.nextInt(100) + 1);
        }
        System.out.println(Arrays.toString(sortArray(list.stream().mapToInt(Integer::intValue).toArray())));
    }


}
