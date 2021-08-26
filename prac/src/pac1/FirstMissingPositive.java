package pac1;


public class FirstMissingPositive {


    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     *
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     * 
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,0]
     * 输出：3
     * 示例 2：
     *
     * 输入：nums = [3,4,-1,1]
     * 输出：2
     * 示例 3：
     *
     * 输入：nums = [7,8,9,11,12]
     * 输出：1
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {

        /**
         * 将数字放在i的位置上
         */
        int len = nums.length;
        boolean[] dp = new boolean[len + 1];
        for (int i = 0; i < len; i++) {
            if(nums[i] > 0 && nums[i] <= len) {
                dp[nums[i]] = true;
            }
        }
        /**
         * 顺序遍历，如果当前i位置值不是i，返回false
         */
        for (int i = 1; i <= len; i++) {
            if (!dp[i]) {
                return i;
            }
        }
        return len + 1;
    }
}
