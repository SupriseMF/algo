package pac1;


import java.util.*;

public class QuickSort3Ptr {

    private static int INSERTION_SORT_THRESHOLD = 7;

    private static Random RANDOM = new Random();


    /**
     * 利用三个指针排序
     * @param nums
     * @return
     */
    public static int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int left, int right) {
//        if (right-left<=INSERTION_SORT_THRESHOLD) {
//            insertionSort(nums, left, right);
//            return;
//        }

        if (left < right) {
            // 快速排序
            int pos = partition(nums, left, right);
            // 以lt和gt为区间划分，大大减少两侧分治的区间
            quickSort(nums, left, pos - 1);
            quickSort(nums, pos + 1, right);
        }

    }

    /**
     * 三轴快排
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static int partition(int[] nums, int left, int right) {
        int randomIndex = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);

        // 三个指针
        // 循环不变量：
        // all in [left + 1, leftPos] < pivot
        // all in [leftPos + 1, i) = pivot
        // all in [pos, right] > pivot
        int pivot = nums[left];
        int leftPos = left;
        // 从右侧开始
        int pos = right + 1;
        int i = left + 1;
        while (i < pos) {
            // 当前值小时，leftPos右移，和i交换后，i右移
            if (nums[i] < pivot) {
                leftPos++;
                swap(nums, i, leftPos);
                i++;
            } else if (nums[i] == pivot) {
                // 相等时，i右移
                i++;
            } else {
                // 当前值大于时，gt左移，当前值插入后方
                pos--;
                swap(nums, i, pos);
            }
        }
        swap(nums, left, leftPos);
        return pos;
    }

    /**
     * 插入排序
     * 无需额外的控空间
     * 时间上，最好情况O(N)，最坏O(n^2)
     * @param nums
     * @param left
     * @param right
     */
    private void insertionSort(int[] nums, int left, int right) {
        // 从左侧开始,向后遍历，当前
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                // 当前值比当前值大时，前面的值后移（前面的都已经排好序了，向右平移即可）
                nums[j] = nums[j - 1];
                j--;
            }
            // 最终插入到较小的位置
            nums[j] = temp;
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(RANDOM.nextInt(100) + 1);
        }
        System.out.println(Arrays.toString(sortArray(list.stream().mapToInt(Integer::intValue).toArray())));
    }


    /**
     * 快排非递归
     * @param nums
     * @return
     */
    public int[] sortArrayWithOutRecursion(int[] nums) {
        // 使用栈模拟递归
        Stack<Integer> stack = new Stack<>();
        stack.push(nums.length - 1);
        stack.push(0);
        while (!stack.isEmpty()) {
            int low = stack.pop();
            int high = stack.pop();

            if (low < high) {
                int index = partition1(nums, low, high);
                stack.push(index - 1);
                stack.push(low);
                stack.push(high);
                stack.push(index + 1);
            }
        }
        return nums;
    }

    /**
     * 双轴查找
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition1(int[] nums, int left, int right) {
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
        swap(nums, left, gt);
        return gt;
    }

}
