package pac1;

public class searchRange {

    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }
        /**
         * 寻找 leftIdx 即为在数组中寻找第一个大于等于 target 的下标，
         * 寻找rightIdx 即为在数组中寻找第一个大于 target 的下标，然后将下标减一。
         */
        int firstIndex = binarySearch(nums, target, true);
        int secondIndex = binarySearch(nums, target, false)-1;
        if (firstIndex <= secondIndex && secondIndex < len && nums[firstIndex] == target && nums[secondIndex] == target) {
            return new int[]{firstIndex, secondIndex};
        } else {
            return new int[]{-1, -1};
        }
    }

    private static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            // lower== true时，值要》=目标，即可左找
            // 否则，须继续向右查找
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] res = searchRange(nums, 7);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
