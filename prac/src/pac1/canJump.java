package pac1;

public class canJump {


    /**
     * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个下标。
     *
     * 
     *
     * 示例1：
     *
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        /**
         * 使用贪心法
         * 每次跳远，记录，可调到的最远距离，并更新
         * 若最远距离大于n，返回true
         *
         * 时间复杂度O(M) M<=N
         * 空间复杂度O(1)
         */
        int farIndex = 0;
        int finalPos = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            // 未到达可达位置时
            if (i <= farIndex) {
                farIndex = Math.max(farIndex, i + nums[i]);
                if (farIndex >= finalPos) {
                    return true;
                }
            }
        }
        return farIndex >= finalPos;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));

    }
}
