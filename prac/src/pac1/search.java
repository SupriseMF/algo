package pac1;

public class search {


    /**
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     *
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
     * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
     *
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        /**
         * 时间复杂度为 O(log n)
         * 使用二分法
         * 因为全局有序，或部分有序
         * 翻转数组，肯定左侧或右侧有序
         */
        int len = nums.length;
        return binarySearch(nums, 0, len - 1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        int m = (left + right) / 2;

        if (nums[m] == target) {
            return m;
        }
        // 左侧有序
        if (nums[left] < nums[m]) {
            // 值于其中
            if (target > nums[left] && target < nums[m]) {
                return binarySearch(nums, left + 1, m - 1, target);
            } else {
                return binarySearch(nums, m + 1, right - 1, target);
            }
        } else {
            // 右侧有序
            if (target > nums[m] && target < nums[right]) {
                return binarySearch(nums, m + 1, right - 1, target);
            } else {
                return binarySearch(nums, left + 1, m - 1, target);
            }
        }
    }


    /**
     * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
     * 你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
     * 如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
     *
     * 输入：nums = [2,5,6,0,0,1,2], target = 0
     * 输出：true
     *
     * @param nums
     * @param target
     * @return
     */
    public static boolean searchNoOrder(int[] nums, int target) {
        /**
         * 对于数组中有重复元素的情况，二分查找时可能会有 a[l]=a[mid]=a[r]，
         * 此时无法判断区间 [l,mid] 和区间 [mid+1,r] 哪个是有序的。
         *
         */
        int len = nums.length;
        // 边界校验
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return nums[0] == target;
        }
        return binarySearchNoOrder(nums, 0, len - 1, target);
    }

    private static boolean binarySearchNoOrder(int[] nums, int left, int right, int target) {

        if (left >= right) {
            return false;
        }
        if (nums[left] == target) {
            return true;
        }
        if (nums[right] == target) {
            return true;
        }
        int m = (left + right) / 2;

        if (nums[m] == target) {
            return true;
        }
        // 由于可能重复
        // 左右中均相等时，继续缩小范围
        if (nums[left] == nums[m] && nums[m] == nums[right]) {
            return binarySearchNoOrder(nums, left+1, right - 1, target);
        } else if (nums[left] <= nums[m]) {
            // 左侧递增时
            // 目标介于左和中时
            if (nums[left] <= target && target <= nums[m]) {
                return binarySearchNoOrder(nums, left, m - 1, target);
            } else {
                // 在右侧查找
                return binarySearchNoOrder(nums, m + 1, right, target);
            }
        } else {
            // 右侧递增时
            // 在右侧范围时，在右侧内查找
            if (nums[m] <= target && target <= nums[right]) {
                return binarySearchNoOrder(nums, m + 1, right, target);
            } else {
                // 不再右侧范围，左侧查找
                return binarySearchNoOrder(nums, left, m - 1, target);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
        System.out.println(searchNoOrder(nums, 2));
    }

}
