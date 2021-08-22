package pac1;

public class findMin {

    /**
     * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
     * 例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
     * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
     * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
     *
     * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。
     * 请你找出并返回数组中的 最小元素 。
     *
     * 输入：nums = [3,4,5,1,2]
     * 输出：1
     * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
     *
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        /**
         * 仍然部分有序
         * 利用二分法
         */
        int len = nums.length;
        return binarySearch(nums, 0, len - 1, nums[0]);
    }

    private static int binarySearch(int[] nums, int left, int right, int min) {
        if (left > right) {
            return min;
        }
        min = Math.min(min, nums[left]);
        min = Math.min(min, nums[right]);
        int m = (left + right) / 2;

        // 左侧有序
        if (nums[left] < nums[m]) {
            // 值于其中
            if (nums[m] < nums[right]) {
                return Math.min(min, nums[left]);
            } else {
                min = Math.min(min, nums[left]);
                return binarySearch(nums, m + 1, right, min);
            }
        } else {
            // 右侧有序
            if (nums[m] > nums[right]) {
                return Math.min(min, nums[right]);
            } else {
                min = Math.min(min, nums[m]);
                return binarySearch(nums, left, m - 1, min);
            }
        }
    }

    public static void main(String[] args) {
//        int[] nums = {3, 4, 5,6, 7, 0, 1, 2};
        int[] nums = {5, 0, 1, 2, 3, 4};
        System.out.println(findMin(nums));
    }
}
